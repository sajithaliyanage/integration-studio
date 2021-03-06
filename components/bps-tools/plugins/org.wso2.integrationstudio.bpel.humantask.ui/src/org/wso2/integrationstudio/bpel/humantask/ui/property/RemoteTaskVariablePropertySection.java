/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.wso2.integrationstudio.bpel.humantask.ui.property;


import org.eclipse.bpel.common.ui.details.ButtonIValue;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.dialogs.VariableSelectorDialog;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.properties.EditController;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.wso2.integrationstudio.bpel.humantask.model.ModelPackage;
import org.wso2.integrationstudio.bpel.humantask.model.PeopleActivityRT;


public class RemoteTaskVariablePropertySection extends BPELPropertySection{

	protected Composite parentComposite;
	
	//InputVariable
	protected Label inputVariableName;
	protected Button inputVariableBrowseButton;
	//OutputVaraible
	protected Label outputVariableName;
	protected Button outputVariableBrowseButton;
	//isSkippable and dontShareComments
	protected Button isSkipableCheckbox;
	protected Button dontShareCommentsCheckbox;
	
	protected EditController isSkipableCheckboxController ;
	protected EditController dontShareCommentsController ;
	protected EStructuralFeature fisSkipableFeature;
	protected EStructuralFeature fdontShareCommentsFeature;
	
	private PeopleActivityRT getActivity() {
		return (PeopleActivityRT)getInput();
	}
	
	
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new BatchedMultiObjectAdapter() {
				
				
				public void notify (Notification n) {
				}
				
				
				public void finish() {
					updateVariableWidgets();
				}
			}
		};
	}
	
	
	public class SetInputVariableCommand extends SetCommand {

		public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_VARIABLE; }

		public SetInputVariableCommand(EObject target, Variable newVariable)  {
			super(target, newVariable);
		}

		
		public Object get() {
			return ((PeopleActivityRT)fTarget).getInputVariable();
		}
		
		public void set(Object o) {
			((PeopleActivityRT)fTarget).setInputVariable((Variable)o);
		}
	}
	
	public class SetOutputVariableCommand extends SetCommand {

		public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_VARIABLE; }

		public SetOutputVariableCommand(EObject target, Variable newVariable)  {
			super(target, newVariable);
		}

		
		public Object get() {
			return ((PeopleActivityRT)fTarget).getOutputVariable();
		}
		
		public void set(Object o) {
			((PeopleActivityRT)fTarget).setOutputVariable((Variable)o);
		}
	}
	
	
	
	protected void createClient(Composite parent) {
		fisSkipableFeature = ModelPackage.eINSTANCE.getPeopleActivityRT_IsSkipable();
		fdontShareCommentsFeature =ModelPackage.eINSTANCE.getPeopleActivityRT_DontShareComments();
		
		final Composite composite = parentComposite = createFlatFormComposite( createFlatFormComposite(parent) );
		
		createAttributeWidget(composite);
		createChangeTrackers();
		
	}

	protected void createAttributeWidget(final Composite composite)
	{
		FlatFormData data;
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		composite.setLayoutData(data);
		
		// Input Variable
		Label inputVariableLabel = fWidgetFactory.createLabel(composite, "inputVariable:"); 
		inputVariableName = fWidgetFactory.createLabel(composite, "", SWT.BORDER); //$NON-NLS-1$
		inputVariableBrowseButton = fWidgetFactory.createButton(composite, Messages.FaultThrowNameSection_Browse_1, SWT.PUSH); 

		//Set Output Variable
		Label outputVariableLabel = fWidgetFactory.createLabel(composite, "outputVariable:"); 
		outputVariableName = fWidgetFactory.createLabel(composite, "", SWT.BORDER); //$NON-NLS-1$
		outputVariableBrowseButton = fWidgetFactory.createButton(composite, Messages.FaultThrowNameSection_Browse_1, SWT.PUSH); 
		
		//isSkipable and dontShareComments
		isSkipableCheckbox = fWidgetFactory.createButton(composite,"Is Skipable",SWT.CHECK);
		dontShareCommentsCheckbox = fWidgetFactory.createButton(composite,"Dont Share Comments",SWT.CHECK);
		/*
		 *  Setup positions 
		 */
		
		//inputVariable
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(inputVariableLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(inputVariableBrowseButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		data.height = FigureUtilities.getTextExtents(inputVariableBrowseButton.getText(), inputVariableBrowseButton.getFont()).height + 4;
		inputVariableName.setLayoutData(data);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 0);
		data.bottom = new FlatFormAttachment(inputVariableName, 2, SWT.BOTTOM);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(inputVariableBrowseButton, SHORT_BUTTON_WIDTH)-IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50, -IDetailsAreaConstants.CENTER_SPACE);
		inputVariableBrowseButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(inputVariableName, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		inputVariableLabel.setLayoutData(data);
		
		
		
		// Output Variable
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(outputVariableLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(outputVariableBrowseButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(inputVariableName, 10);
		data.height = FigureUtilities.getTextExtents(outputVariableBrowseButton.getText(), outputVariableBrowseButton.getFont()).height + 4;
		outputVariableName.setLayoutData(data);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(outputVariableName, 0, SWT.TOP);
		data.bottom = new FlatFormAttachment(outputVariableName, 2, SWT.BOTTOM);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(outputVariableBrowseButton, SHORT_BUTTON_WIDTH)-IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50, -IDetailsAreaConstants.CENTER_SPACE);
		outputVariableBrowseButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(outputVariableName, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(outputVariableName, 0, SWT.CENTER);
		outputVariableLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(outputVariableLabel, 10);
		isSkipableCheckbox.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(isSkipableCheckbox, 20);
		data.top = new FlatFormAttachment(outputVariableLabel, 10);
		dontShareCommentsCheckbox.setLayoutData(data);
		
		/*
		 * Listeners 
		 */
		
		//action Listener for Button: Input Variable
		inputVariableBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = composite.getShell();
				EObject model = getInput();
				VariableSelectorDialog dialog = new VariableSelectorDialog(shell, model, ModelHelper.getVariableType(model, ModelHelper.OUTGOING));
				dialog.setTitle("Select Input Variable"); 
				if (dialog.open() == Window.OK) {
					Variable variable = dialog.getVariable();
					Command command = new SetInputVariableCommand(model, variable);
					getCommandFramework().execute(wrapInShowContextCommand(command));
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
		
		//action Listener for Button: OutputVariable
		outputVariableBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = composite.getShell();
				EObject model = getInput();
				VariableSelectorDialog dialog = new VariableSelectorDialog(shell, model, ModelHelper.getVariableType(model, ModelHelper.OUTGOING));
				dialog.setTitle("Select Output Variable"); 
				if (dialog.open() == Window.OK) {
					Variable variable = dialog.getVariable();
					Command command = new SetOutputVariableCommand(model, variable);
					getCommandFramework().execute(wrapInShowContextCommand(command));
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
		
	
	}
	
	
	
	public void updateVariableWidgets() {
		
		if (getActivity() != null ) {
			
			inputVariableName.setText("");
			outputVariableName.setText("");
			isSkipableCheckbox.setSelection(false);
			dontShareCommentsCheckbox.setSelection(false);
			
			Variable inputVariable = getActivity().getInputVariable();
			Variable outputVariable = getActivity().getOutputVariable();
			if (inputVariable!=null) {
				String name = inputVariable.getName();
				if (name==null)
					name = "";
				inputVariableName.setText(name);
			}
			if (outputVariable!=null) {
				String name = outputVariable.getName();
				if (name==null)
					name = "";
				outputVariableName.setText(name);
			}
		
			isSkipableCheckbox.setSelection(getActivity().isIsSkipable());
			dontShareCommentsCheckbox.setSelection(getActivity().isDontShareComments());
		}
	}
	
	
	protected void basicSetInput(EObject newInput) {
		if ( newInput instanceof PeopleActivityRT) {
			super.basicSetInput(newInput);
			updateVariableWidgets();
			isSkipableCheckboxController.setInput(newInput);
			dontShareCommentsController.setInput(newInput);
			addExtensionTag();
		}
	}
	
	// Change Tracker Code for controllers
	void createChangeTrackers() {
		
		/** Parallel execution setting/un-setting */
		isSkipableCheckboxController = createEditController();
		isSkipableCheckboxController.setFeature( fisSkipableFeature );
		isSkipableCheckboxController.setViewIValue( new ButtonIValue( isSkipableCheckbox ));
		isSkipableCheckboxController.startListeningTo( isSkipableCheckbox );
		
		dontShareCommentsController = createEditController();
		dontShareCommentsController.setFeature( fdontShareCommentsFeature );
		dontShareCommentsController.setViewIValue( new ButtonIValue( dontShareCommentsCheckbox ));
		dontShareCommentsController.startListeningTo( dontShareCommentsCheckbox );
		
	}
	
	/**
	 * Creating <Extensions /> & <extension /> tags
	 */
	protected void addExtensionTag() {
		Extensions exts;
		Extension ext;
		String ns= ModelPackage.eINSTANCE.getNsURI();
		boolean isExtensionExist=false;
		if(BPELUtils.getProcess(getInput())!=null){
			
			Process process = BPELUtils.getProcess(getInput());
			
			// check for <extenstions>
			exts = ((BPELUtils.getProcess(getInput())).getExtensions());
			if(exts!=null){
				isExtensionExist = false;
				//check for existing <extension> with ns;
				for(Extension extension: exts.getChildren())
				{
					if(ns.equalsIgnoreCase(extension.getNamespace())){
						//found <extension> with ns;
						isExtensionExist = true;
						break;
					}
				}
			}else {
				exts = BPELFactory.eINSTANCE.createExtensions();
				isExtensionExist = false;
			}
			// Create tags;
			if(!isExtensionExist){
			
				ext = BPELFactory.eINSTANCE.createExtension();
				ext.setMustUnderstand(true);
				ext.setNamespace(ns);
				exts.getChildren().add(ext);
				process.setExtensions(exts);
				getCommandFramework().execute( wrapInShowContextCommand((
						new SetCommand( process, exts, BPELPackage.eINSTANCE.getProcess_Extensions()))));
			}
		}else{
			System.err.println("Error: Fail to add Extensions;");
		}
	}
	

}
