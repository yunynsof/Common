/**
 * BPMNCompilerException.java
 * Broker
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.exceptions;

/**
 * BPMNCompilerException.
 *
 * @author izelaya
 */
public class BPMNCompilerException extends Exception {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Attribute that stores the error code. **/
	private int _errorCode;

	/** Attribute that stores the _message. */
	private String _message;
	
	
	/**
	 * Instantiates a new BPMN compiler exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public BPMNCompilerException(final int errorCode,
			final String message, final Exception cause) {
		super(message, cause);
		_errorCode = errorCode;
		_message = message;
	}

	
	/**
	 * Instantiates a new BPMN compiler exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public BPMNCompilerException(final int errorCode,
			final String message) {
		this(errorCode, message, null);
		_message = message;
	}

	
	/**
	 * Instantiates a new BPMN compiler exception.
	 *
	 * @param errorCode the error code
	 */
	public BPMNCompilerException(final int errorCode) {
		this(errorCode, null);
	}

	/**
	 * Method responsible to gets the error code.
	 * 
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return _errorCode;
	}

	/**
	 * Method responsible to sets the error code.
	 * 
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(final int errorCode) {
		this._errorCode = errorCode;
	}

	/**
	 * Method responsible to gets the message exception.
	 * 
	 * @return the _message
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Method responsible to sets the message exception.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this._message = message;
	}

}
