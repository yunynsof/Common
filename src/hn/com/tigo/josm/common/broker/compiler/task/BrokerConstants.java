/**
 * BrokerConstants.java
 * Broker
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.broker.compiler.task;

/**
 * BrokerConstants.
 * 
 * Collection of constants used on Broker project
 * 
 * @author Harold Castillo
 * @version 1.0
 * @since 20/10/2014 06:44:43 PM 2014
 */
public final class BrokerConstants {

	/** Attribute that determine the path of configuration of the project. */
	public static final String REQUEST_CONFIG = "hn.com.tigo.josm.broker.business.Broker";

	/** Attribute that determine a Constant of PRODUCT_NAME_PARAM. */
	public static final String PRODUCT_NAME_PARAM = "PRODUCT_NAME"; 

	/** Attribute that determine a Constant of PRODUCT_DESC_PARAM. */
	public static final String PRODUCT_DESC_PARAM = "PRODUCT_DESCRIPTION";
	
	/** Attribute that defines a successful bpmn compilation code.*/
	public static final String COMPILATION_SUCCESS_CODE = "0";
	
	/** Attribute that defines a failed bpmn compilation code.*/
	public static final String COMPILATION_FAIL_CODE = "1";
	
	/** Attribute that defines a successful bpmn compilation message.*/
	public static final String COMPILATION_SUCCESS_MESSAGE = "The BPMN has been compiled and updated in data base";
	
	/** Attribute that defines a failed bpmn compilation message.*/
	public static final String COMPILATION_FAIL_MESSAGE = "compile FAIL: ";
	
	/** Attribute that determine a Constant of DEACTIVATE_PRODUCT_SUCCESS. */
	public static final String CHANGE_STATUS_PRO_SUCCESS  = "The product %S with order type %s has been %s";
	
	/** Attribute that determine a Constant of CHANGE_STATUS_PRO_FAILED_COD. */
	public static final int CHANGE_STATUS_PRO_FAILED_COD  = 2;
	
	/** Attribute that determine a Constant of CHANGE_STATUS_PRO_FAILED_DESC. */
	public static final String CHANGE_STATUS_PRO_FAILED_DESC  = "Invalid value in 'enable' field";
	
	/** Attribute that determine a Constant of CHANGE_STATUS_PRO_FAILED_ORDER_COD. */
	public static final int CHANGE_STATUS_PRO_FAILED_ORDER_COD  = 3;
	
		/** Attribute that determine a Constant of CHANGE_STATUS_PRO_FAILED_ORDER_DESC. */
	public static final String CHANGE_STATUS_PRO_FAILED_ORDER_DESC  = "Invalid order type";
	
	/**
	 * Instantiates a new broker constants.
	 */
	private BrokerConstants() {
	}



}
