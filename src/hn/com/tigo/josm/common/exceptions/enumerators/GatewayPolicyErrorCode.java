package hn.com.tigo.josm.common.exceptions.enumerators;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;


/**
 * GatewayPolicyErrorCode.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 05-25-2015 09:24:43 AM 2015
 */
public enum GatewayPolicyErrorCode {

	
	/** Constant that defines sucess code OK. */
	OK(0, "Sucess"),

	/** The gatw pol xml file. */
	GATW_POL_XML_FILE(301, "Error creating PluginConfigurationResponse from xml file  %s."),

	/** The gatw pol data type. */
	GATW_POL_DATA_TYPE(302, "Error in DataTypeFactory."),

	/** The gatw pol profile query. */
	GATW_POL_PROFILE_QUERY(303, "Error getting profile query."),
	
	/** The gatw pol loading properties. */
	GATW_POL_LOADING_PROPERTIES(304, "Error loading properties file %s."),
	
	/** The gatw pol validating xml. */
	GATW_POL_VALIDATING_XML(305, "Error validating xml."),
	
	/** The gatw pol validating xml policy. */
	GATW_POL_VALIDATING_XML_POLICY(306, "Configuration error,the policy instance does not exist in the xml file."),
	
	/** The gatw pol transaction amount policy. */
	GATW_POL_TRANSACTION_AMOUNT_POLICY(307, "No amount additional parameter to validate TransactionAmount policy."),
	
	/** The gatw pol subscriber acl policy. */
	GATW_POL_SUBSCRIBER_ACL_POLICY(308, "SubscriberACL Policy. Configured instance not found."),

	/** The gatw pol subscriber acl policy subscriber. */
	GATW_POL_SUBSCRIBER_ACL_POLICY_SUBSCRIBER(309, "SubscriberACL Policy invalid susbcriber."),

	/** The gatw pol subscriber acl policy other. */
	GATW_POL_SUBSCRIBER_ACL_POLICY_OTHER(310, "SubscriberACL Policy invalid field."),
	
	/** The gatw pol subscriber acl policy other. */
	GATW_POL_AUTOCORRECT(311, "Incorrect Word."),

	/** The gatw pol subscriber cos. */
	GATW_POL_SUBSCRIBER_COS(312, "Subscriber COS Policy invalid susbcriber."),

	/** The gatw pol subscriber type. */
	GATW_POL_SUBSCRIBER_TYPE(313, "Subscriber TYPE Policy invalid susbcriber."),

	/** The gatw pol subscriber type. */
	GATW_POL_MASTER_STATUS(314, "Master Status Policy invalid susbcriber."),
	
	/** The gatw pol dos policy. */
	GATW_POL_DOS_POLICY(315, "DOS Policy invalid susbcriber."),

	/** The gatw pol cbs policy. */
	GATW_POL_CBS_POLICY(316, "CBS Policy invalid susbcriber."),
	
	/** Attribute that determine GATW_POL_CHANNEL_POLICY. */
	GATW_POL_CHANNEL_POLICY(317, "Channel Policy. The channel %s is not allowed for the product %s"),

	/** Constant that defines the code UNKNOWN_ERROR. */
	UNKNOWN_ERROR(9999, "Unknown error.");


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
	private GatewayPolicyErrorCode(final int error, final String message) {
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
