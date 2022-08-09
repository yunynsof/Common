/**
 * ServiceLocator.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.locator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The ServiceLocator class is a singleton responsible to gets the EJB
 * references and to store it in cache.
 * 
 * Allows to create service instance from a JNDI string.
 * 
 * @author Harold Castillo
 * @version 1.5
 * @since 16/10/2014 11:53:36 AM
 */
public class ServiceLocator {

	/** Attribute that determine a Constant of REMOVE_SUCCESS_MSG. */
	private static final String REMOVE_SUCCESS_MSG = "The jndi with name: %s has been removed";
	
	/** Attribute that determine serviceLocator. */
	private static ServiceLocator serviceLocator;

	/** Attribute that determine jndiReferenceCache. */
	private Map<String, Object> jndiReferenceCache;

	/** Attribute that determine contextCache. */
	private Map<String, Context> contextCache;

	/**
	 * Construct method that instantiates a new service locator.
	 */
	private ServiceLocator() {
		jndiReferenceCache = new Hashtable<String, Object>();
		contextCache = new Hashtable<String, Context>();
	}

	/**
	 * Method responsible to gets the single instance of ServiceLocator.
	 *
	 * @return single instance of ServiceLocator
	 */
	public static ServiceLocator getInstance() {
		if(serviceLocator == null){
			ServiceLocator.serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}

	/**
	 * Method responsible to gets the ejb reference.
	 *
	 * @param <T> the generic type
	 * @param serviceJndi the service jndi
	 * @return the service
	 * @throws ServiceLocatorException the service locator exception
	 */
	public <T> T getService(final String serviceJndi) throws ServiceLocatorException {
		return this.getService(serviceJndi, null);
	}

	/**
	 * Method responsible to gets the EJB reference settings the properties context.
	 *
	 * @param <T> the generic type
	 * @param serviceJndi the service jndi
	 * @param properties the properties
	 * @return the service
	 * @throws ServiceLocatorException the service locator exception
	 */
	@SuppressWarnings("unchecked")
	public <T> T getService(final String serviceJndi,
			final Properties properties) throws ServiceLocatorException {

		T service = null;

		try {

			// Create the context if not exists.
			if (!contextCache.containsKey(serviceJndi)) {
				final Context context = new InitialContext(properties);
				contextCache.put(serviceJndi, context);
			}

			// Create the JNDI reference if not exists.
			if (!jndiReferenceCache.containsKey(serviceJndi)) {
				service = (T) contextCache.get(serviceJndi).lookup(
						serviceJndi);
				jndiReferenceCache.put(serviceJndi, service);
			}

			service = (T) jndiReferenceCache.get(serviceJndi);
		} catch (NamingException ne) {
			throw new ServiceLocatorException(
					"JNDI not found ".concat(serviceJndi), ne);
		}

		return service;
	}
	
	/**
	 * Method responsible to removes the EJB reference of cache.
	 *
	 * @param serviceJndi the service jndi
	 * @return the message
	 */
	public String removeJNDICache(final String serviceJndi){
		contextCache.remove(serviceJndi);
		jndiReferenceCache.remove(serviceJndi);
		return String.format(REMOVE_SUCCESS_MSG, serviceJndi);
	}
	
	/**
	 * Method responsible to gets the JNDI cache list.
	 *
	 * @return the JNDI cache list
	 */
	public List<String> getJNDICacheList(){
		List<String> jndiList = new ArrayList<String>();
		
		for(Map.Entry<String, Object> entry : jndiReferenceCache.entrySet()){
			jndiList.add(entry.getKey());			
		}
		
		return jndiList;
	}
	
	/**
	 * Method responsible to reset all cache.
	 */
	public void resetAllCache(){
		jndiReferenceCache = new Hashtable<String, Object>();
		contextCache = new Hashtable<String, Context>();
	}

}
