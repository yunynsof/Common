/**
 * ConfigurationJosmRemote.java
 * Common-Configuration
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.configuration.dto.ResponseJOSM;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Remote;
import javax.xml.bind.JAXBException;


/**
 * The Interface ConfigurationJosmRemote
 * defining the contract for retrieving configuration values using JAXB classes.
 *
 * @author Camilo Gutierrez <mailto:cgutierrez@stefanini.com />
 * @version 
 * @since 25/11/2014 06:00:56 PM 2014
 */
@Remote
public interface ConfigurationJosmRemote {
	 
 	/**
 	 * Gets the configuration object wrapped in a response.
 	 *
 	 * @param request the package for the desired configuration.
 	 * @return the configuration object wrapped in a response.
 	 * @throws JAXBException the exception thrown whenever the unmarshalling fails.
 	 */
 	ResponseJOSM getConfiguration(final String request)throws JAXBException, IOException, FileNotFoundException;

 	/**
	  * Gets any file from system.
	  *
	  * @param path the path
	  * @return the file from system
	  */
	 byte[] getFileFromSystem(String path);
}
