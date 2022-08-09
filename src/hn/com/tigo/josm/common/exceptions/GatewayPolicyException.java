/**
 * GatewayPolicyException.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.exceptions;

/**
 * GatewayPolicyException.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 27/01/2015 10:37:53 AM 2015
 */
public class GatewayPolicyException extends Exception {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Attribute that stores the  code exception value. */
	private int _errorCode = 1;
	
	/** Attribute that stores the _message. */
	private String _message;
	
	/**
	 * Instantiates a new gateway policy exception.
	 *
	 * @param msg the msg
	 */
	public GatewayPolicyException(final String msg){
		super(msg);
		this._message = msg;
		
	}
	
	
	/**
	 * Instantiates a new gateway exception.
	 *
	 * @param code the code
	 * @param msg the msg
	 */
	public GatewayPolicyException(final int code, final String msg){
		super(msg);
		this._message = msg;
		this._errorCode = code;
	}
	
		
	
	/**
	 * Instantiates a new gateway policy exception.
	 */
	public GatewayPolicyException(){
		super();
	}
	
	
	/**
	 * Instantiates a new gateway policy exception.
	 *
	 * @param ex the ex
	 */
	public GatewayPolicyException(final Throwable ex){
		super(ex);
	}
	
	
	/**
	 * Instantiates a new gateway policy exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GatewayPolicyException(final String msg, final Throwable cause) {
		super(msg, cause);
		this._message = msg;
	}
	
	
	/**
	 * Instantiates a new adapter exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public GatewayPolicyException(final int errorCode,
			final String message, final Exception cause) {
		super(message, cause);
		_errorCode = errorCode;
		_message = message;
	}
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode(){
		return _errorCode;
	}
	
	
	/**
	 * Gets the message.
	 * 
	 * @return the _message
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(final String message) {
		this._message = message;
	}
}
