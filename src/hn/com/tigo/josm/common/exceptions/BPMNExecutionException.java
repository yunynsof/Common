package hn.com.tigo.josm.common.exceptions;

/**
 * BpmnException.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 
 * @since 17/02/2015 05:17:48 PM 2015
 */
public class BPMNExecutionException extends Exception {

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
	public BPMNExecutionException(final int errorCode,
			final String message, final Exception cause) {
		super(message, cause);
		_errorCode = errorCode;
		_message = message;
	}

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the exception error's code
	 * @param message
	 *            the exception's message
	 */
	public BPMNExecutionException(final int errorCode,
			final String message) {
		this(errorCode, message, null);
		this._message = message;
	}

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the exception's error code
	 */
	public BPMNExecutionException(final int errorCode) {
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
