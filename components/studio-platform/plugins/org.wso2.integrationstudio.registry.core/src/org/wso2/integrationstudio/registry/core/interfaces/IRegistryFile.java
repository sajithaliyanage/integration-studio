package org.wso2.integrationstudio.registry.core.interfaces;

import java.io.InputStream;

public interface IRegistryFile extends IRegistryResource {
	
	/**
	 * Return the data stream of the resource
	 * @return
	 * @throws Exception 
	 */
	public InputStream getStream() throws Exception;
}
