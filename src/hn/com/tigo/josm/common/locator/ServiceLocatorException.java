/**
 * ServiceLocatorException.java
 * UIOSMCore
 * Copyright (c) Millicon.
 */
package hn.com.tigo.josm.common.locator;

/**
 * ServiceLocatorException.
 * 
 * Exception thrown when ServiceLocator fails.
 * 
 * @author Harold Castillo
 * @version 1.0
 * @since 16/10/2014 11:53:24 AM 2014
 */
public class ServiceLocatorException extends Exception {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new service locator exception.
	 *
	 * @param message
	 *            the message of the exception
	 */
	public ServiceLocatorException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new service locator exception.
	 *
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public ServiceLocatorException(String message, Throwable cause) {
		super(message, cause);
	}

}