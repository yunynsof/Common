/**
 * ServiceLocator.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.locator;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * ServiceLocator.
 * 
 * Allows to create service instance from a JNDI string
 * 
 * @author Harold Castillo
 * @version 1.0
 * @since 16/10/2014 11:53:36 AM
 */
public class ServiceLocator {


	/** This variable store a self instance. */
	private static ServiceLocator _serviceLocator;
	
	
	/** Attribute that determine _customInstances. */
	private static Map<String, ServiceLocator> _providerInstances = new HashMap<String, ServiceLocator>();

	/** This variable stores context of a service. */
	private Context _context = null;

	/**
	 * Instantiates a new service locator.
	 * 
	 * @throws ServiceLocatorException
	 *             the service locator exception
	 */
	private ServiceLocator() throws ServiceLocatorException {

		try {
			final Properties prop = new Properties();
			_context = new InitialContext(prop);
		} catch (NamingException ne) {
			throw new ServiceLocatorException("Initial context no created " + ne.getMessage(), ne);
		}

	}
	
	
	
	/**
	 * Instantiates a new service locator.
	 *
	 * @param providerURL the provider url
	 * @throws ServiceLocatorException the service locator exception
	 */
	private ServiceLocator(final String providerURL) throws ServiceLocatorException {

		try {
			
			final Properties prop = new Properties();
			prop.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			prop.setProperty(Context.PROVIDER_URL, "t3://"+providerURL);
			
			_context = new InitialContext(prop);
		} catch (NamingException ne) {
			throw new ServiceLocatorException("Initial context no created " + ne.getMessage(), ne);
		}

	}
	
	

	/**
	 * Gets the single instance of ServiceLocator.
	 * 
	 * @return An instance of ServiceLocator
	 * @throws ServiceLocatorException
	 *             the service locator exception
	 */
	public static ServiceLocator getInstance() throws ServiceLocatorException {

		if (_serviceLocator == null) {
			_serviceLocator = new ServiceLocator();
		}

		return _serviceLocator;
	}
	
	
	/**
	 * Gets the provider instance.
	 *
	 * @param providerURL the provider url
	 * @return the provider instance
	 * @throws ServiceLocatorException the service locator exception
	 */
	public static ServiceLocator getProviderInstance(final String providerURL) throws ServiceLocatorException {
		
		ServiceLocator serviceLocator = _providerInstances.get(providerURL);
		if(serviceLocator == null){
			serviceLocator = new ServiceLocator(providerURL);
			_providerInstances.put(providerURL, serviceLocator);
		}
		return serviceLocator;
	}

	/**
	 * Gets the service from a jni.
	 * 
	 * @param <T>
	 *            The type of generic class
	 * @param serviceJndi
	 *            The string from JNDI service
	 * @return the service
	 * @throws ServiceLocatorException
	 *             Exception thrown when service locator fails
	 */
	@SuppressWarnings("unchecked")
	public <T> T getService(final String serviceJndi) throws ServiceLocatorException {

		T service = null;

		try {
			service = (T) _context.lookup(serviceJndi);
		} catch (NamingException ne) {
			throw new ServiceLocatorException("JNDI not found ".concat(serviceJndi), ne);
		}

		return service;

	}

}
