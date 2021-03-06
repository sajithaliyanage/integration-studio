/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.artifact.messagestore.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.integrationstudio.artifact.messagestore.Activator;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;

public class AvailableMessageStoreList extends AbstractListDataProvider {
	private static IIntegrationStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	@Override
	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		
		List<ListData> availableMessageStoreList = new ArrayList<ListData>();
		availableMessageStoreList.add(createListData("",""));
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject workspaceProject : projects) {
			
				try {
					if (workspaceProject.isOpen() && workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
					
 						
 						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
 						try {
							esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
							
 							List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
 							for (ESBArtifact esbArtifact : allESBArtifacts) {
 								if(esbArtifact.getType().equals("synapse/message-store")){
 									String relativeFilePath = esbArtifact.getFile().replaceAll("/", (File.separatorChar=='/')?"/":"\\\\");
 									String fileName = new File((relativeFilePath)).getName().replaceAll(".xml$", "");
									availableMessageStoreList.add(createListData(fileName,fileName));
 								}
 							}
 						}
 						
 						catch (Exception e) {

 		 				} 
					}
				}
					catch (Exception e) {
 		 					log.error("Error occured while scanning the workspace for Message-Store artifacts", e);
 		 				} 
 					}
 		 		
 				return availableMessageStoreList;
 		 	}
}
