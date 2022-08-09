/**
 * 
 */
package hn.com.tigo.josm.common.exceptions.enumerators;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

/**
 * AdapterErrorCode. This enun defines the adapter error codes
 * 
 * @author Jimmy Muchachasoy <mailto:jamuchavisoy@stefanini.com />
 * @version
 * @see
 * @since 13-oct-2014 10:54:04 2014
 */
public enum AdapterErrorCode {

	/** Constant that defines sucess code OK. */
	OK(0, "Sucess"),

	/** Constant that defines the code TIMEOUT_CONNECTION_ERROR. */
	TIMEOUT_CONNECTION_ERROR(AdapterErrorCode.CONSTANT_ERROR_1, "Connection timeout on host %s driver %s"),

	/** Constant that defines the code PARAMETERS_ERROR. */
	PARAMETERS_ERROR(AdapterErrorCode.CONSTANT_ERROR_2, "Invalid parameters"),

	/** Constant that defines the code SESSION_ERROR. */
	SESSION_ERROR(AdapterErrorCode.CONSTANT_ERROR_3, "Session error"),

	/** Constant that defines the code MAX_THROUGHPUT_ERROR. */
	MAX_THROUGHPUT_ERROR(AdapterErrorCode.CONSTANT_ERROR_4, "Exceeds max Throughput"),

	/** Constant that defines the code MAX_SESSION_ERROR. */
	MAX_SESSION_ERROR(AdapterErrorCode.CONSTANT_ERROR_5, "Exceeds max Sessions"),

	/** Constant that defines the code TASK_ERROR. */
	TASK_ERROR(AdapterErrorCode.CONSTANT_ERROR_6, "Task error"),

	/** Constant that defines the code TOO_MANY_CONNECTIONS. */
	TOO_MANY_CONNECTIONS(AdapterErrorCode.CONSTANT_ERROR_7, "Too many connections"),

	/** Constant that defines the code LGI_ERROR. */
	LGI_ERROR(AdapterErrorCode.CONSTANT_ERROR_8, "Error getting session in LGI task"),

	/** Constant that defines the code LGI_ERROR. */
	SERVICE_NOT_FOUND(AdapterErrorCode.CONSTANT_ERROR_9, "Service Not Found"),
	
	/** Constant that defines the code LGI_ERROR. */
	COMMUNICATION_ERROR(AdapterErrorCode.CONSTANT_ERROR_10, "Communication Error"),
	
	/** Constant that defines the code LGI_ERROR. */
	PLATFORM_ERROR(AdapterErrorCode.CONSTANT_ERROR_11, "Error generated in platform"),
	
	/** Constant that defines the code INTERNAL_EXECUTOR_ERROR. */
	INTERNAL_EXECUTOR_ERROR(AdapterErrorCode.CONSTANT_ERROR_12, "Internal error in service executor"),

	/** The invalid authentication error. */
	INVALID_AUTHENTICATION_ERROR(AdapterErrorCode.CONSTANT_ERROR_13, "Invalid Authentication"),
	
	/** The subcriber not found. */
	SUBCRIBER_NOT_FOUND(AdapterErrorCode.CONSTANT_SUBCRIBER_NOT_FOUND_14, "Subcriber not found"),

	/** Constant that defines the code UNKNOWN_ERROR. */
	UNKNOWN_ERROR(AdapterErrorCode.CONSTANT_ERROR_999999999, "Unknown error");

	

	/** Constant that defines the code CONSTANT_ERROR_1. */
	private static final int CONSTANT_ERROR_1 = 201;

	/** Constant that defines the code CONSTANT_ERROR_2. */
	private static final int CONSTANT_ERROR_2 = 202;

	/** Constant that defines the code CONSTANT_ERROR_3. */
	private static final int CONSTANT_ERROR_3 = 203;

	/** Constant that defines the code CONSTANT_ERROR_4. */
	private static final int CONSTANT_ERROR_4 = 204;

	/** Constant that defines the code CONSTANT_ERROR_5. */
	private static final int CONSTANT_ERROR_5 = 205;

	/** Constant that defines the code CONSTANT_ERROR_6. */
	private static final int CONSTANT_ERROR_6 = 206;

	/** Constant that defines the code CONSTANT_ERROR_7. */
	private static final int CONSTANT_ERROR_7 = 207;

	/** Constant that defines the code CONSTANT_ERROR_8. */
	private static final int CONSTANT_ERROR_8 = 208;

	/** Constant that defines the code CONSTANT_ERROR_9. */
	private static final int CONSTANT_ERROR_9 = 209;
	
	/** Constant that defines the code CONSTANT_ERROR_10. */
	private static final int CONSTANT_ERROR_10 = 210;
	
	/** Constant that defines the code CONSTANT_ERROR_11. */
	private static final int CONSTANT_ERROR_11 = 211;

	/** Constant that defines the code CONSTANT_ERROR_12. */
	private static final int CONSTANT_ERROR_12 = 212;
	
	/** The Constant CONSTANT_ERROR_13. */
	private static final int CONSTANT_ERROR_13 = 213;
	
	/** Attribute that determine a constant. */
	private static final int CONSTANT_SUBCRIBER_NOT_FOUND_14 = 214;

	/** Constant that defines the code CONSTANT_ERROR_999999999. */
	private static final int CONSTANT_ERROR_999999999 = 1;

	/** Attribute that determine log. */
	private static final transient Logger LOGGER = Logger.getLogger(AdapterErrorCode.class);
	
	/** Attribute that stores _error. */
	private int _error;

	/** Attribute that stores _message. */
	private String _message;

	/**
	 * Instantiates a new code exception.
	 * 
	 * @param error
	 *            the error
	 * @param message
	 *            the message
	 */
	private AdapterErrorCode(final int error, final String message) {
		this._error = error;
		this._message = message;
	}

	/**
	 * Gets the error.
	 * 
	 * @return the _error
	 */
	public int getError() {
		return _error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(final int error) {
		this._error = error;
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

	/**
	 * Gets the type exception.
	 * 
	 * @param e
	 *            the e
	 * @return the type exception
	 */
	public static AdapterErrorCode getValue(final Exception e) {
		AdapterErrorCode cause;
		if (e instanceof TimeoutException) {
			cause = AdapterErrorCode.TIMEOUT_CONNECTION_ERROR;
		} else if (e instanceof SocketTimeoutException) {
			cause = AdapterErrorCode.TIMEOUT_CONNECTION_ERROR;
		} else {
			cause = AdapterErrorCode.UNKNOWN_ERROR;
		}

		LOGGER.error("ERROR: " + cause.getError() + "- CAUSE:" + cause.getMessage());
		return cause;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return "Failed: Code " + _error + " Message " + _message;

	}
}
