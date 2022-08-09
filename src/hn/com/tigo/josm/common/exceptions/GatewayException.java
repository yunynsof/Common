/**
 * GatewayException.java
 * Gateway
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.exceptions;


/**
 * GatewayException.
 * Exception thrown by the broker in case of fail in it's logic conditionals
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 21/10/2014 10:38:26 AM 2014
 */
public class GatewayException extends AbstractException {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = -334169680716939363L;

	/**
	 * Instantiates a new gateway exception.
	 */
	public GatewayException() {
		super();
	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param exception the exception
	 */
	public GatewayException(final Exception exception) {
		super(exception);
	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param orderIndex the order index
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @param cause the cause
	 */
	public GatewayException(final int orderIndex, final int errorCode, final String message, final Exception cause) {
		super(orderIndex, errorCode, message, cause);
		this._errorMessage = message;
	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @param cause the cause
	 */
	public GatewayException(final int errorCode, String message, final Exception cause) {
		super(errorCode, message, cause);
		this._errorMessage = message;
	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param errorCode the error code
	 * @param msg the msg
	 * @param cause the cause
	 */
	public GatewayException(final int errorCode, final String message, final Throwable cause) {
		super(errorCode, message, cause);
		this._errorMessage = message;

	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public GatewayException(final int errorCode, final String message) {
		super(errorCode, message);
		this._errorMessage = message;

	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param errorCode the error code
	 */
	public GatewayException(final int errorCode) {
		super(errorCode);
	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GatewayException(final String message, final Exception cause) {
		super(message, cause);
		this._errorMessage = message;

	}

	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param message the message
	 */
	public GatewayException(final String message) {
		super(message);
		this._errorMessage = message;
	}
	


}
