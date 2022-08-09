/**
 * EnumMasterStatusResponse.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * EnumMasterStatusResponse.
 * 
 * Enum for the values of any of the josm component.
 *
 * @author Saul Villasenor
 * @version 1.0
 * @since 15/02/2016 
 */
public enum EnumJOSMResponse {

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
	
	/** The BPM Authorization successful. */
	BPM_AUTHORIZATION_SUCCESSFUL(0, "bpm authorization successful", "The bpm was successfully authorized"),

	/** The invalid formta date. */
	INVALID_FORMTA_DATE(9, "The format date is incorrect", "The format date is incorrect"),

	/** The transaction failed. */
	TRANSACTION_FAILED(10, "Transaction failed ", "The transaction is not executed correctly "),
	
	/** The product does not exist. */
	PRODUCT_NOT_EXIST(11,"Product Error","The Product %s does not exists"),
	
	/** The channel does not exist. */
	CHANNEL_NOT_EXIST(12,"Channel Error","The Channel %s does not exists"),
	
	/** The message id in message bundle does not exists. */
	MESSAGEBUNDLE_NOT_EXIST(13,"Message Bundle Error","The message %s does not exist"),
	
	/** The product message does not exists.  */
	PRODUCTMESSAGE_NOT_EXISTS(14,"Product Message Error","The product message %s does not exists"),
	
	/** JOSM Exception Error */
	JOSM_EXCEPTION_ERROR(15,"JOSM Exception","JOSM Exception"),
	
	/** Validation Exception error. */
	VALIDATION_EXCEPTION_ERROR(16,"Validation Exception", "Validation Exception"),
	
	/** The policy does not exist. */
	POLICY_NOT_EXIST(17,"Policy Error","The policy %s does not exist"),
	
	/** The policy instance does not exist. */
	POLICYINSTANCE_NOT_EXIST(18,"Policy Instance Error","The policy instance %s does not exist"),
	
	/** The policy instance does not exist. */
	PRODUCTPOLICYINSTANCE_NOT_EXIST(19,"Product Policy Instance Error","The product policy instance %s does not exist"),
	
	/** The product bpm version does not exist. */
	PRODUCTBPMVERSION_NOT_EXIST(20,"Product Bpm Version Error","The product bpm version %s does not exist for product family: %s and order type: %s"),
	
	/** The bpm version does not exist. */
	BPMVERSION_NOT_EXIST(21,"Bpm Version Error", "The bpm version does not exist for product family: %s and order type: %s "),
	
	/** The bpm is not the last version. */
	BPMVERSION_WRONG_VERSION(22,"Bpm Version Error","The bpm version is not the last version"),
	
	/** The value in param cannot be null if datasource = C. */
	PARAM_VALUE_NULL(23,"Param Error", "The value cannot be null if the datasource is C for the param id: %s"),
	
	/** The value in param must be null if datasource = PC .*/
	PARAM_VALUE_NOT_NULL(24,"Param Error", "The value must be null if the datasource is PC for the param id: %s"),
	
	/** The param does not exist. */
	PARAM_NOT_EXIST(25,"Param Error", "The param %s does not exist"),
	
	/** The product family does not exist. */
	PRODUCTFAMILY_NOT_EXIST(26,"Product Family Error", "The product family: %s does not exist"),
	
	/** The product param does not exist */
	PRODUCTPARAM_NOT_EXIST(27,"Product Param Error","The product param %s does not exist"),
	
	/** The value in product param must be null if datasource = C. */
	PRODUCTPARAM_VALUE_NOT_NULL(28,"Product Param Error", "The value must be null if param %s datasource is C"),
	
	/** The value in param cannot be null if datasource = PC .*/
	PRODUCTPARAM_VALUE_NULL(29,"Param Error", "The value cannot be null if the param %s datasource is PC"),
	
	/** The bpm version does not exist. */
	DATATRANSFER_NOT_EXIST(30,"Data Transfer Bpm Error", "The data transfer bpm %s does not exist"),
	
	/** successful batch operation. */
	SUCCESSFUL_BATCH_OPERATION(0,"Batch Success", "The batch operation was successful."),
	
	/** There is a data transfer for the % product and the % order type */
	DATATRANSFER_ALREADY_EXIST(31,"Data Transfer Error","There is a data transfer with the same product id and order type: %d"),
	
	/** The date is before the current date. */
	DATATRANSFER_INVALID_DATE(32,"Data Transfer Error","The date provided cannot be before the current date "),
	
	/** The start error code can´t be bigger than the end error code */
	PRODUCTMESSAGE_INVALID_START_END_CODES(33,"Product Message Error", "The start error %s code can´t be bigger than the end error code %s for the product message %s"),
	
	/** The bpm version does not exist. */
	BPMVERSION_NOT_EXIST_ID(34,"Bpm Version Error", "The bpm version does not exist: %s "),
	
	/** The compilation of the bpm version failed. */
	BPMVERSION_COMPILE_ERROR(35,"Bpm Version Error", "The compile service failed, gateway message: <%s>"),
	
	/** The compilation of the bpm failed, cause. */
	BPMCOMPILE_ERROR(37,"Bpm Compile Error","Compilation Error"),
	
	/** The initial date if a product policy instance cannot be after its final date */
	PRODUCTPOLICYINSTANCE_INVALID_DATE(38,"Product Policy Instance Error","The final date cannot be after the initial date")

	;

	
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
	private EnumJOSMResponse(int code, String message, String messageDetail) {
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
