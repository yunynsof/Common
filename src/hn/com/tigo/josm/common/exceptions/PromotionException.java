/**
 * PromotionException.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;

import hn.com.tigo.josm.common.exceptions.enumerators.OrchestratorErrorCode;

import javax.xml.ws.WebFault;

/**
 * PromotionException.
 * 
 * Class that allow manage the exceptions of the Promotions.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 10/02/2015 14:44:22
 */
@WebFault(name = "PromotionException", targetNamespace = "http://www.tigo.com.hn/josm/common/exceptions/PromotionException/V1")
public class PromotionException extends Exception {

	/**  Attribute that determine the id of serial version. */
	private static final long serialVersionUID = 644683070149663189L;
	
	/** Attribute that stores the error code. **/
	private int _errorCode;
	
	/** Attribute that stores the _message. */
	private String _message;


	/**
	 * Instantiates a new Promotion exception.
	 * @param e 
	 * @param string 
	 * @param i 
	 */
	public PromotionException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this._errorCode = errorCode;
		if (message == null) {
			this._message = message;
		} else {
			this._message = message;
		}
	}
	
	public PromotionException(int errorCode, String message) {
		super(message);
		this._errorCode = errorCode;
		if (message == null) {
			this._message = message;
		} else {
			this._message = message;
		}
	}

	/**
	 * Instantiates a new Promotion exception.
	 *
	 * @param message
	 *            the message of the exception
	 */
	public PromotionException(final String message) {
		super(message);
		this._message = message;
	}

	/**
	 * Instantiates a new Promotion exception.
	 *
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public PromotionException(final String message, final Throwable cause) {
		super(message, cause);
		this._message = message;
	}
	
	
	/**
	 * Instantiates a new Promotion exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public PromotionException(final OrchestratorErrorCode errorCode,
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
	 * Instantiates a new Promotion exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public PromotionException(final OrchestratorErrorCode errorCode,
			final String message) {
		this(errorCode, message, null);
		this._message = message;

	}

	
	/**
	 * Instantiates a new Promotion exception.
	 *
	 * @param errorCode the error code
	 */
	public PromotionException(final OrchestratorErrorCode errorCode) {
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
