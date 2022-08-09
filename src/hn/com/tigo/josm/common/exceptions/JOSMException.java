/**
 * ProfileException.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;



import javax.xml.ws.WebFault;

/**
 * JOSMException.
 * 
 * Class that allow manage the exceptions of the josm components.
 *
 * @author Saul Villasenor
 * @version 1.0
 * @since 02/15/2016 
 */
@WebFault(name = "JOSMException", targetNamespace = "http://www.tigo.com.hn/josm/common/exceptions/JOSMException/V1")
public class JOSMException extends Exception {

	/**  Attribute that determine the id of serial version. */
	private static final long serialVersionUID = 4845164924809897493L;
	
	
	/** Attribute that stores the error code. **/
	private int errorCode;
	
	/** Attribute that stores the message. */
	private String message;


	/**
	 * Instantiates a new josm exception.
	 */
	public JOSMException() {
		super();
	}

	/**
	 * Instantiates a new josm exception.
	 *
	 * @param message
	 *            the message of the exception
	 */
	public JOSMException(final String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Instantiates a new josm exception.
	 *
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public JOSMException(final String message, final Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	/**
	 * Instantiates a new josm exception.
	 *
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public JOSMException(final String message, final int errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}
	
	
	
	/**
	 * Method responsible to gets the error code.
	 * 
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Method responsible to sets the error code.
	 * 
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(final int errorCode) {
		this.errorCode = errorCode;
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
