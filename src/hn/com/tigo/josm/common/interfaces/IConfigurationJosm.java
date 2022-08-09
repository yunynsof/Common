package hn.com.tigo.josm.common.interfaces;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import hn.com.tigo.josm.common.exceptions.ConfigurationException;

@Remote
@WebService(name = "IConfigurationJosm", targetNamespace = "http://tigo.com.hn/josm/common/configuration/interfaces/CommonConfiguration/V1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface IConfigurationJosm {

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

}
