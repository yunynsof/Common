/**
 * ConfigurationJosmRemote.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBException;

import hn.com.tigo.josm.common.configuration.dto.ResponseJOSM;
import hn.com.tigo.josm.common.exceptions.ConfigurationException;

/**
 * The Interface ConfigurationJosmRemote defining the contract for retrieving
 * configuration values using JAXB classes.
 *
 * @author Camilo Gutierrez <mailto:cgutierrez@stefanini.com />
 * @version
 * @since 25/11/2014 06:00:56 PM 2014
 */
@Remote
@WebService(name = "IConfigurationJosm", targetNamespace = "http://tigo.com.hn/josm/common/configuration/interfaces/CommonConfiguration/V1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface ConfigurationJosmRemote {

	/**
	 * Method responsible to gets the configuration.
	 *
	 * @param fileName
	 *            the file name
	 * @return the configuration
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	@WebMethod(operationName = "getConfiguration")
	String getCurrentConfiguration(@WebParam(name = "fileName") final String fileName) throws ConfigurationException;

	/**
	 * Method responsible to persist any configuration in Cassandra database.
	 *
	 * @param fileName
	 *            the file name
	 * @param fileConfiguration
	 *            the file configuration
	 * @return the configuration response
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	@WebMethod(operationName = "persistConfiguration")
	String persistConfiguration(@WebParam(name = "fileName") final String fileName, @WebParam(name = "fileConfiguration") final String fileConfiguration)
			throws ConfigurationException;

	/**
	 * Gets the configuration object wrapped in a response.
	 *
	 * @param request
	 *            the package for the desired configuration.
	 * @return the configuration object wrapped in a response.
	 * @throws JAXBException
	 *             the exception thrown whenever the unmarshalling fails.
	 */
	ResponseJOSM getConfiguration(final String request) throws JAXBException, IOException, FileNotFoundException;

	/**
	 * Gets any file from system.
	 *
	 * @param path
	 *            the path
	 * @return the file from system
	 */
	byte[] getFileFromSystem(String path);

}
