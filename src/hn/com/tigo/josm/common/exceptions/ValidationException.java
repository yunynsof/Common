/**
 * ValidationException.java
 * ValidationService
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;

import javax.xml.ws.WebFault;

/**
 * ValidationException.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 12/11/2015 01:40:01 PM 2015
 */
@WebFault(name = "ValidationException", targetNamespace = "http://tigo.com.hn/ValidationException/V1")
public class ValidationException extends Exception {

	/**
	 * The Constant of serial version.
	 */
	private static final long serialVersionUID = -6486332176920736436L;

	/** The error. */
	protected String error;

	/** The message. */
	protected String message;

	/**
	 * Instantiates a new validation exception.
	 */
	public ValidationException() {
		super();
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param error the error
	 * @param message            the message of the exception
	 */
	public ValidationException(final String error, final String message) {
		super(message);
		this.message = message;
		this.error = error;
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param throwable
	 *            the throwable exception
	 */
	public ValidationException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param error the error
	 * @param message            the message of the exception
	 * @param throwable            the throwable exception
	 */
	public ValidationException(final String error, final String message, final Throwable throwable) {
		super(message, throwable);
		this.message = message;
		this.error = error;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(String error) {
		this.error = error;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
