package hn.com.tigo.josm.common.exceptions;

/**
 * The class ConfigurationException contains the <Usage of this class> for
 * Common project.
 *
 * @author Gary Gonzalez Zepeda <mailto:ggzepeda@stefanini.com/>
 * @version 1.0.0
 * @since Apr 7, 2017
 */
public class ConfigurationException extends Exception {

	/**
	 * The Constant of serial version.
	 */
	private static final long serialVersionUID = -6486332176920736436L;

	/** The error. */
	protected String error;

	/** The message. */
	protected String message;

	/**
	 * Instantiates a new validation exception.
	 */
	public ConfigurationException() {
		super();
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param error
	 *            the error
	 * @param message
	 *            the message of the exception
	 */
	public ConfigurationException(final String error, final String message) {
		super(message);
		this.message = message;
		this.error = error;
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param throwable
	 *            the throwable exception
	 */
	public ConfigurationException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param error
	 *            the error
	 * @param message
	 *            the message of the exception
	 * @param throwable
	 *            the throwable exception
	 */
	public ConfigurationException(final String error, final String message, final Throwable throwable) {
		super(message, throwable);
		this.message = message;
		this.error = error;
	}

	/**
	 * Instantiates a new configuration exception.
	 *
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 */
	public ConfigurationException(final String message, final Throwable throwable) {
		super(message, throwable);
		this.message = message;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error
	 *            the new error
	 */
	public void setError(String error) {
		this.error = error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
