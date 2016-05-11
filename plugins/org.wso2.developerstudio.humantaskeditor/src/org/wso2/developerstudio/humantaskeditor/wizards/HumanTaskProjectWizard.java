/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.humantaskeditor.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.humantaskeditor.Activator;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class HumanTaskProjectWizard extends Wizard implements INewWizard {

    private HumanTaskProjectWizardPage page;

    private ISelection selection;

    private static final Logger logger = Logger.getLogger(Activator.PLUGIN_ID);

    /**
     * Constructor for HumanTaskWizard.
     */
    public HumanTaskProjectWizard() {
        super();
        setNeedsProgressMonitor(true);
    }

    /**
     * Adding the page to the wizard.
     */

    @Override
    public void addPages() {
        page = new HumanTaskProjectWizardPage(selection);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in the wizard. We
     * will create an operation and run it using wizard as execution context.
     */
    @Override
    public boolean performFinish() {
        final String containerName = page.getContainerName();
        final String fileName = page.getFileName();
        final String taskName = page.getTaskName();
        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, fileName, taskName, monitor);
                } catch (CoreException e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };
        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), HumantaskEditorConstants.ERROR_MESSAGE, realException.getMessage());
            return false;
        }
        return true;
    }

    /**
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     */

    private void doFinish(String containerName, String fileName, String taskName, IProgressMonitor monitor)
            throws CoreException {
        monitor.beginTask("Creating " + fileName, 2);
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(containerName);
        if (project.exists()) {
            throwCoreException(HumantaskEditorConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE);
        } else {
            project.create(null);
            project.open(null);
        }

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            throwCoreException("Container \"" + containerName + "\" does not exist.");
        }
        IContainer container = (IContainer) resource;
        final IFile file = container.getFile(new Path(fileName));
        final IFile wsdlfile = container.getFile(new Path(taskName + "Task.wsdl"));
        final IFile cbWsdlfile = container.getFile(new Path(taskName + "CBTask.wsdl"));
        final IFile htconfigfile = container.getFile(new Path(HumantaskEditorConstants.INITIAL_HTCONFIG_NAME));
        addNature(file.getProject());
        try {
            InputStream stream = openContentStream(taskName);
            InputStream wsdlStream = openWSDLStream();
            InputStream htconfigStream = openHTConfigStream();
            if (file.exists()) {
                file.setContents(stream, true, true, monitor);
            } else {
                file.create(stream, true, monitor);
                wsdlfile.create(wsdlStream, true, monitor);
                cbWsdlfile.create(wsdlStream, true, monitor);
                htconfigfile.create(htconfigStream, true, monitor);

            }
            stream.close();
            wsdlStream.close();
            htconfigStream.close();
        } catch (IOException e) {
            logger.log(Level.FINE, HumantaskEditorConstants.ERROR_CREATING_INITIAL_FILE_MESSAGE, e);
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE,
                    HumantaskEditorConstants.ERROR_CREATING_INITIAL_FILE_MESSAGE, editorStatus);
        }
        monitor.worked(1);
        monitor.setTaskName(HumantaskEditorConstants.OPENING_FILE_FOR_EDITING_MESSAGE);
        getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                    logger.log(Level.FINE, HumantaskEditorConstants.ERROR_OPENING_THE_EDITOR_MESSAGE, e);
                    IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                    ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                            HumantaskEditorConstants.ERROR_MESSAGE,
                            HumantaskEditorConstants.ERROR_OPENING_THE_EDITOR_MESSAGE, editorStatus);

                }
            }
        });
        monitor.worked(1);
    }

    /**
     * We will initialize file contents with a sample text.
     *
     * @throws IOException
     * @throws CoreException
     */

    private InputStream openContentStream(String taskName) throws IOException, CoreException {
        String contents = changeXMLName(readDummyHT(), taskName);
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * We will initialize file contents with a sample text.
     *
     * @throws IOException
     */

    private InputStream openWSDLStream() throws IOException {
        String contents = readDummyWSDL();
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * We will initialize file contents with a sample text.
     *
     * @throws IOException
     */

    private InputStream openHTConfigStream() throws IOException {
        String contents = readDummyHtConfig();
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * Read dummy ht file which is needed to initialize a new ht file
     *
     * @throws IOException
     */
    private String readDummyHT() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url;
        try {
            url = new URL(HumantaskEditorConstants.DUMMY_HT_LOCATION);
            InputStream inputStream = url.openConnection().getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine + "\n");
            }

            in.close();

        } catch (IOException e) {
            logger.log(Level.FINE, "Error reading from HT file", e);
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read dummy ht file which is needed to initialize a new ht file
     *
     * @throws IOException
     */
    private String readDummyWSDL() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url;
        try {
            url = new URL(HumantaskEditorConstants.DUMMY_WSDL_LOCATION);
            InputStream inputStream = url.openConnection().getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine + "\n");
            }

            in.close();

        } catch (IOException e) {
            logger.log(Level.FINE, "Error reading from WSDL file", e);
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    private String readDummyHtConfig() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url;
        try {
            url = new URL(HumantaskEditorConstants.DUMMY_HTCONFIG_LOCATION);
            InputStream inputStream = url.openConnection().getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine + "\n");
            }

            in.close();

        } catch (IOException e) {
            logger.log(Level.FINE, "Error reading from HTConfig file", e);
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    private void throwCoreException(String message) throws CoreException {
        IStatus status = new Status(IStatus.ERROR, HumantaskEditorConstants.PLUGIN_ID, IStatus.OK, message, null);
        throw new CoreException(status);
    }

    private static void addNature(IProject project) throws CoreException {
        if (!project.hasNature(HumanTaskNature.NATURE_ID)) {
            IProjectDescription description = project.getDescription();
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 1];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            newNatures[prevNatures.length] = HumanTaskNature.NATURE_ID;
            description.setNatureIds(newNatures);

            IProgressMonitor monitor = null;
            project.setDescription(description, monitor);
        }
    }

    /**
     * We will accept the selection in the workbench to see if we can initialize
     * from it.
     *
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    private String changeXMLName(String content, String taskName) throws CoreException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
        String xmlString = null;
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(content));
            dom = db.parse(is);
            NodeList taskList = dom.getElementsByTagName(HumantaskEditorConstants.QUALIFIED_TASK_NODE_NAME);
            for (int i = 0; i < taskList.getLength(); i++) {
                Node task = taskList.item(i);
                task.getAttributes().getNamedItem("name").setNodeValue(taskName);
            }
            TransformerFactory transfactory = TransformerFactory.newInstance();
            Transformer transformer = transfactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            DOMSource source = new DOMSource(dom.getDocumentElement());

            transformer.transform(source, result);
            xmlString = stringWriter.toString();
        } catch (ParserConfigurationException pce) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_PARSING_XML);
        } catch (SAXException se) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_PARSING_XML);
        } catch (IOException ioe) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_FILE_IO);
        } catch (TransformerConfigurationException e) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_TRANSFORM_CONFIG);
        } catch (TransformerException e) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_TRANSFORMING_XML_TO_TEXT);
        }
        return xmlString;
    }
}
