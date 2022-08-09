/**
 * EnumMasterStatusResponse.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * EnumMasterStatusResponse.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 23/04/2015 16:26:31
 */
public enum EnumMasterStatusResponse {

	/** The successful creation. */
	SUCCESSFUL_CREATION(0, "creating successful", "The values were successfully created"),

	/** The no found. */
	NOT_FOUND(1, "Not found", "Data entered not generate any results"),

	/** The empty data. */
	EMPTY_DATA(2, "Empty data", "Enter the information requested on the signature of Service"),

	/** The illegal characters. */
	ILLEGAL_CHARACTERS(3, "Illegal characters", "The request data contains illegal characters"),

	/** The subscriber not exist. */
	SUBSCRIBER_NOT_EXIST(4, "The subscriber does not exist", "Check that it exists in the database"),

	/** The profile not exist. */
	PROFILE_NOT_EXIST(5, "The profile does not exist", "Check that it exists in the database"),

	/** The deletion successful. */
	DELETED_SUCCESSFUL(0, "deleted successful", "Delete actions correctly executed"),

	/** The subscriber exists. */
	SUBSCRIBER_EXISTS(7, "The subscriber exists", "The subscriber is already registered"),

	/** The null date. */
	NULL_DATE(8, "The date cannot be null or empty", "The date cannot be null or empty"),

	/** The invalid formta date. */
	INVALID_FORMTA_DATE(9, "The format date is incorrect", "The format date is incorrect"),

	/** The transaction failed. */
	TRANSACTION_FAILED(10, "Transaction failed ", "The transaction is not executed correctly"),

	/**  Change of number successful. */
	CHANGE_NUMBER_SUCCESSFUL(10, "Change of number successful", "The transaction change of number was executed correctly"),

	/** Attributes not found. */
	ATTRIBUTES_NOT_FOUND(
			11,
			"Attributes not found",
			"The transaction is not executed correctly, entering the attributes associated with the subscriber and the profile");

	/** The code. */
	private int code;

	/** The message. */
	private String message;

	/** The message detail. */
	private String messageDetail;

	/**
	 * Instantiates a new enum master status response.
	 * 
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param messageDetail
	 *            the message detail
	 */
	private EnumMasterStatusResponse(int code, String message, String messageDetail) {
		this.code = code;
		this.message = message;
		this.messageDetail = messageDetail;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
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

	/**
	 * Gets the message detail.
	 * 
	 * @return the message detail
	 */
	public String getMessageDetail() {
		return messageDetail;
	}

	/**
	 * Sets the message detail.
	 * 
	 * @param messageDetail
	 *            the new message detail
	 */
	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}

}
