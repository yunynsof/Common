package hn.com.tigo.josm.common.exceptions;


public class ValidatorException extends Exception {
	
	private static final long serialVersionUID = 8673620214931120559L;
	
	/** Attribute that stores the error code. **/
	private int _errorCode;
	
	/** Attribute that stores the message. */
	private String _message;

	public ValidatorException(final String message) {
		super(message);
	}

	
	public ValidatorException(final String message, final Throwable cause) {
		super(message, cause);
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
