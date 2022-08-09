/**
 * BrokerException.java
 * Broker
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;


/**
 * BrokerException. Exception thrown by the broker in case of fail in it's logic
 * conditionals
 * 
 * @author Juan Pablo Gomez<mailto:jgomezg@stefaninicolombia.com />
 * @version
 * @since 21/10/2014 04:21:47 PM 2014
 */
public class BrokerException extends AbstractException {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = -334169680713L;

	/**
	 * Instantiates a new broker exception.
	 */
	public BrokerException() {
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param exception the exception
	 */
	public BrokerException(final Exception exception) {
		super(exception);
		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param orderIndex the order index
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @param cause the cause
	 */
	public BrokerException(final int orderIndex, final int errorCode, final String message, final Exception cause) {
		super(orderIndex, errorCode, message, cause);
		this._errorMessage = message;
		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @param cause the cause
	 */
	public BrokerException(final int errorCode, final String message, final Exception cause) {
		super(errorCode, message, cause);
		this._errorMessage = message;

		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param errorCode the error code
	 * @param msg the msg
	 * @param cause the cause
	 */
	public BrokerException(final int errorCode, final String message, final Throwable cause) {
		super(errorCode, message, cause);
		this._errorMessage = message;

		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public BrokerException(final int errorCode, final String message) {
		super(errorCode, message);
		this._errorMessage = message;
		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param errorCode the error code
	 */
	public BrokerException(final int errorCode) {
		super(errorCode);
		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BrokerException(final String message, final Exception cause) {
		super(message, cause);
		this._errorMessage = message;

		
	}

	/**
	 * Instantiates a new broker exception.
	 *
	 * @param message the message
	 */
	public BrokerException(final String message) {
		super(message);
		this._errorMessage = message;

		
	}


	
}
