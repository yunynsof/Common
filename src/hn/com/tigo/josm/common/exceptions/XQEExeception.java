/**
 * XQEExeception.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;

/**
 * XQEExeception.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 15/10/2015 08:55:40 AM 2015
 */
public class XQEExeception extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new XQuery engine exception.
	 *
	 * @param message the message
	 */
	public XQEExeception(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new XQuery engine exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public XQEExeception(final String message, final Throwable throwable) {
		super(message, throwable);
	}

}
