package hn.com.tigo.josm.common.exceptions;


/**
 * AbstractException.
 * 
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 05-22-2015 06:39:59 PM 2015
 */
public abstract class AbstractException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The _simple order request. */
	protected int _orderIndex;

	/** Attribute that stores the error code. **/
	protected int _errorCode;

	/** Attribute that stores the _message. */
	protected String _errorMessage;
	
	
	/**
	 * Instantiates a new abstract exception.
	 */
	public AbstractException(){
		
		
	}

	/**
	 * Instantiates a new abstract exception.
	 *
	 * @param orderIndex the order index
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @param cause the cause
	 */
	public AbstractException(final int orderIndex, final int errorCode, final String errorMessage, final Exception exception) {
		super(exception);
		this._orderIndex = orderIndex;
		this._errorCode = errorCode;
		this._errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public AbstractException(final int errorCode, final String errorMessage, final Exception cause) {
		super(errorMessage, cause);
		this._errorCode = errorCode;
		this._errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new abstract exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param msg
	 *            the msg
	 * @param cause
	 *            the cause
	 */
	public AbstractException(final int errorCode, final String msg, final Throwable cause) {
		super(msg, cause);
		this._errorCode = errorCode;
	}

	/**
	 * Instantiates a new abstract exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public AbstractException(final String message, final Exception cause) {
		super(message, cause);
		_errorMessage = message;
	}

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 */
	public AbstractException(final int errorCode, final String message) {
		this(errorCode, message, null);
		this._errorMessage = message;
	}

	/**
	 * Instantiates a new adapter exception.
	 * 
	 * @param errorCode
	 *            the error code
	 */
	public AbstractException(final int errorCode) {
		this(errorCode, null);
		this._errorCode = errorCode;
	}

	/**
	 * Instantiates a new abstract exception.
	 * 
	 * @param message
	 *            the message
	 */
	public AbstractException(final String message) {
		super(message);
		_errorMessage = message;
	}

	/**
	 * Instantiates a new abstract exception.
	 * 
	 * @param exception
	 *            the exception
	 */
	public AbstractException(final Exception exception) {
		super(exception);
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
		return _errorMessage;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	public void setMessage(final String message) {
		this._errorMessage = message;
	}

	/**
	 * Gets the _index.
	 * 
	 * @return the _index
	 */
	public int getIndex() {
		return _orderIndex;
	}

	/**
	 * Sets the _index.
	 * 
	 * @param _index
	 *            the new _index
	 */
	public void setIndex(final int index) {
		this._orderIndex = index;
	}

}
