/**
 * ProfileException.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;

import hn.com.tigo.josm.common.exceptions.enumerators.OrchestratorErrorCode;

import javax.xml.ws.WebFault;

/**
 * ProfileException.
 * 
 * Class that allow manage the exceptions of the profiles.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 10/02/2015 14:44:22
 */
@WebFault(name = "ProfileException", targetNamespace = "http://www.tigo.com.hn/josm/common/exceptions/ProfileException/V1")
public class MasterStatusException extends Exception {

	/**  Attribute that determine the id of serial version. */
	private static final long serialVersionUID = 644683070149663189L;
	
	/** Attribute that stores the error code. **/
	private int _errorCode;
	
	/** Attribute that stores the _message. */
	private String _message;


	/**
	 * Instantiates a new profile exception.
	 */
	public MasterStatusException() {
		super();
	}

	/**
	 * Instantiates a new profile exception.
	 *
	 * @param message
	 *            the message of the exception
	 */
	public MasterStatusException(final String message) {
		super(message);
		this._message = message;
	}
	
	/**
	 * Instantiates a new master status exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public MasterStatusException(final int errorCode, final String message){
		super(message);
		this._errorCode = errorCode;
		this._message = message;
	}
	
	/**
	 * Instantiates a new master status exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public MasterStatusException(final int errorCode, final String message, final Throwable cause){
		super(message, cause);
		this._errorCode = errorCode;
	}

	/**
	 * Instantiates a new profile exception.
	 *
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public MasterStatusException(final String message, final Throwable cause) {
		super(message, cause);
		this._message = message;
	}
	
	
	/**
	 * Instantiates a new profile exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public MasterStatusException(final OrchestratorErrorCode errorCode,
			final String message, final Exception cause) {
		super(errorCode.getMessage(), cause);
		this._errorCode = errorCode.getError();
		if (message == null) {
			this._message = errorCode.getMessage();
		} else {
			this._message = message;
		}
	}
	
	/**
	 * Instantiates a new profile exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public MasterStatusException(final OrchestratorErrorCode errorCode,
			final String message) {
		this(errorCode, message, null);
		this._message = message;

	}

	
	/**
	 * Instantiates a new profile exception.
	 *
	 * @param errorCode the error code
	 */
	public MasterStatusException(final OrchestratorErrorCode errorCode) {
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

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this._message = message;
	}
}
