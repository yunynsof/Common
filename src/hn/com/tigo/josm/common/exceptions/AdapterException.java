/**
 * 
 */
package hn.com.tigo.josm.common.exceptions;

import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;

/**
 * AdapterException.
 * Exception thrown by the adapter's logic user exception 
 * 
 * @author Jimmy Muchachasoy <mailto:jamuchavisoy@stefanini.com />
 * @version
 * @see
 * @since 13-oct-2014 10:54:14 2014
 */
public class AdapterException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** Attribute that stores the error code. **/
	private int _errorCode;

	/** Attribute that stores the _message. */
	private String _message;

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *           		Exception's error code 
	 * @param message
	 *            Exception's message 
	 * @param cause
	 *            the cause of the exception
	 */
	public AdapterException(final AdapterErrorCode errorCode,
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
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the exception error's code
	 * @param message
	 *            the exception's message
	 */
	public AdapterException(final AdapterErrorCode errorCode,
			final String message) {
		this(errorCode, message, null);
		this._message = message;
	}
	
	
	public AdapterException(final int  errorCode,
			final String message) {
		this._errorCode = errorCode;
		this._message = message;
	}

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the exception's error code
	 */
	public AdapterException(final AdapterErrorCode errorCode) {
		this(errorCode, null);
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return _errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(final int errorCode) {
		this._errorCode = errorCode;
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
	 * @param _message
	 *            the _message to set
	 */
	public void setMessage(final String message) {
		this._message = message;
	}

}
