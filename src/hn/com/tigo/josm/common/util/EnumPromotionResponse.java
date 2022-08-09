/**
 * EnumPromotionResponse.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * EnumPromotionResponse.java
 *
 * @author Kenneth Vittetoe
 * @version 1.0
 * @since Apr 5, 2016 
 */
public enum EnumPromotionResponse {
	/** The successful creation. */
	SUCCESSFUL_CREATION(0, "creating successful", "The values were successfully created"),

	/** The no found. */
	NOT_FOUND(1, "Not found", "Data entered not generate any results"),

	/** The empty data. */
	EMPTY_DATA(2, "Empty data", "Enter the information requested on the signature of Service"),

	/** The illegal characters. */
	ILLEGAL_CHARACTERS(3, "Illegal characters", "The request data contains illegal characters"),
	

	/** The deletion successful. */
	DELETED_SUCCESSFUL(0, "deleted successful", "Delete actions correctly executed"),
	
	/** The deletion successful. */
	UPDATE_SUCCESSFUL(0, "update successful", "Update actions correctly executed"),
	
	/** The invalid formta date. */
	INVALID_FORMTA_DATE(9, "The format date is incorrect", "The format date is incorrect"),

	/** The transaction failed. */
	TRANSACTION_FAILED(10, "Transaction failed ", "The transaction is not executed correctly "),
	
	/**  JOSM Exception Error. */
	PROMOTION_EXCEPTION_ERROR(15,"Promotion Exception","Promotion Exception"),
	
	/** Validation Exception error. */
	VALIDATION_EXCEPTION_ERROR(16,"Validation Exception", "Validation Exception"),
	
	/** successful batch operation. */
	SUCCESSFUL_BATCH_OPERATION(0,"Batch Success", "The batch operation was successful."), 
	
	/** the event does not exist. */
	EVENT_NOT_EXIST(77990,"Event Error.", "The event does not exist."),
	
	/** the action does not exist. */
	ACTION_NOT_EXIST(77991,"Action Error.", "The action does not exist."), 
	
	/** the event group does not exist. */
	EVENT_GROUP_NOT_EXIST(77992,"Event Group Error.", "The Event Group does not exist."),
	
	/**  The action group does not exist. */
	ACTION_GROUP_NOT_EXIST(77993,"Action Group Error.","The action group does not exist."),
	
	/** The promotion does not exist.s */
	PROMOTION_NOT_EXIST(77994,"Promotion Error.", "The Promotion does not exist."),
	
	/** Attribute that determine CATEGORY_TYPE_NOT_EXIST. */
	CATEGORY_TYPE_NOT_EXIST(77995, "Category type error", "The category type does not exist"),
	
	/** Attribute that determine CATEGORY_NOT_EXIST. */
	CATEGORY_NOT_EXIST(77996, "Category error", "The category does not exist"),
	
	/** Attribute that determine the empty list message. */
	EMPTY_LIST(77997, "Empty List", "The data entered did not generate any results."),
	
	/** The promotion detail not exist. */
	PROMOTION_DETAIL_NOT_EXIST(77997,"Promotion Error.", "The Promotion detail does not exist."),

	/**  The action PARAM does not exist. */
	ACTION_PARAM_NOT_EXIST(77998,"Action Param Error.","The action param does not exist."),
	
	/**  The action PARAM batch error. */
	ACTION_PARAM_BATCH_ERROR(77999,"Action Param Error.","The action list could not be created."),
	
	/** The invalid date error */
	INVALID_DATE(78000, "Promotion Log Error", "The final date cannot be after the initial date"),
	
	/** The action param batch name error */
	ACTION_PARAM_BATCH_NAME(78001,"Action Param Error","The name of the param cannot be null"),
	
	/** The action param batch type error */
	ACTION_PARAM_BATCH_TYPE(78002,"Action Param Error","The type of the param cannot be null"),
	
	/** The action param batch empty name error */
	ACTION_PARAM_BATCH_NAME_EMPTY(78003,"Action Param Error","The name of the param cannot be empty"),
	
	/** The promotion action param does not exist */
	PROMOTION_ACTION_PARAM_NOT_EXIST(78004,"Promotion Action Param Error","The promotion action param does not exist"),
	
	/** The promotion action param does not exist */
	PROMOTION_PROGRESS_BAR_NOT_EXIST(78005,"Promotion Progress Bar Error","The promotion progress bar does not exist"),
	
	/** Attribute that determine ACTION_GROUP_EXIST. */
	ACTION_GROUP_EXIST(78006, "The action group already exists", "The action group already exists in database"),
	
	/** Attribute that determine EVENT_GROUP_EXIST. */
	EVENT_GROUP_EXIST(78006, "The event group already exists", "The event group already exists in database");;
	
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
	private EnumPromotionResponse(int code, String message, String messageDetail) {
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
