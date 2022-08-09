/**
 * EnumValidateResponse.java
 * Gateway
 * Copyright (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.exceptions.enumerators;

/**
 * EnumValidateResponse.
 * This enum is used on the gateway project, contains the code
 * of gateway response.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @see
 * @since 15/10/2014 10:31:48 AM 2014
 */
public enum EnumValidateResponse {

	/** SUCESS gateway's validation,  code and message. */
	SUCESS(0, "Gateway Validation Sucess."),
	
	/** ACL IP gateway's validation,  code and message. */
	ACL_IP(101, "Invalid Access IP."),
	
	/** BLACK LIST  gateway's validation,  code and message. */
	BLACK_LIST(102, "Subscriber in Blacklist."),
	
	/** WHITE LIST  gateway's validation,  code and message. */
	WHITE_LIST(103, "Subscriber not in Whitelist."),
	
	/** SCHEDULE  gateway's validation,  code and message. */
	SCHEDULE(104, "Product not active in current date or hour."),
	
	/** PRODUCT_NO_EXISTS gateway's validation, code and message. */
	PRODUCT_NOT_EXISTS(105, "Product %s not exists ."),
	
	/** Attribute that determine REMOTE_SERVICE_ERROR. */
	REMOTE_SERVICE_ERROR(106, "Error acquiring remote instance service."),
	
	/** Attribute that determine CONFIGURATION_ERROR. */
	CONFIGURATION_ERROR(107, "Error in configuration item {0}."),
	
	/** Attribute that determine ADDITIONAL_PARAM_REQUIRED_ERROR. */
	ADDITIONAL_PARAM_REQUIRED_ERROR(108, "The additional parameter {0} is required for the product {1}."),
	
	/** Attribute that determine BPMN_COMPILER_ERROR. */
	BPMN_COMPILER_ERROR(109, "Error in BPMN Compilation."),

	/** Attribute that determine JNDI_NAME_NOT_FOUND. */
	JNDI_NAME_NOT_FOUND(110, "ServiceTask name {0} not found in the server runtime."),
	
	/** Attribute that determine AMBIGUOUS_JNDI_NAME. */
	AMBIGUOUS_JNDI_NAME(111, "Found {0} coincidence's with the ServiceTask name {1}."),
		
	/** Attribute that determine ERROR_MBEAN_SERVER_LOOKUP. */
	ERROR_MBEAN_SERVER_LOOKUP(112, "Error lookup MBeanServer {0}."),
	
	/** FAILED gateway's validation,  code and message. */
	GATEWAY_FAILED(113, "Gateway Validation Failed."),
	
	/** Attribute that determine HANDLER_VALIDATION. */
	HANDLER_VALIDATION(114, "Handler Validation."),
	
	/** The unhandled exception. */
	UNHANDLED_EXCEPTION (115, "Unhendled exception."),

	/** The gateway failed execution. */
	GATEWAY_FAILED_EXECUTION(116, "Gateway execution is on going. Product %s. OrderType %s. SubscriberId %s."),
	
	/** The transaction exception. */
	TRANSACTION_ROLLBACK_EXCEPTION (117, "Transaction RollBack exception."),
	
	/** Attribute that determine CHANNEL_NOT_EXIST. */
	CHANNEL_NOT_EXIST (118, "The channel id not exist."),

	/** Unhandled Error,  code and message. */
	UNHANDLED_ERROR(999, "Unhandled Error: {0}."),
	
	/** The product is invalid*/
	PRODUCT_INVALID(119,"The product %s with order type %s is invalid");

	/** Attribute that contains enum code. */
	private int code;

	/** Attribute that contains enum message. */
	private String message;

	/**
	 * Instantiates a new enum validate response.
	 *
	 * @param code the code
	 * @param message the message
	 */
	private EnumValidateResponse(final int code, final String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the message from the response.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Gets the code from the response.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

}
