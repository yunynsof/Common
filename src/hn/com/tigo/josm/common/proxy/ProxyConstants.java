package hn.com.tigo.josm.common.proxy;

import hn.com.tigo.josm.common.util.ProxyUtil;

import javax.ws.rs.core.Response;

public class ProxyConstants {
	
	
	/** The Constant HEADER_XML. */
	public static final String HEADER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

	/** The Constant HEADER_USSD_ROOT. */
	public static final String HEADER_USSD_ROOT = "<ussdrequest xmlns=\"http://tigo.com.hn/ProxyUssdRequest/V1\">";

	/** The Constant HEADER_USSD_ROOT_ORIGINAL. */
	public static final String HEADER_USSD_ROOT_ORIGINAL = "<ussdrequest> ";

	/** The Constant RESPONSE_CODE_OK_ADAPTER. */
	public static final String RESPONSE_CODE_OK_ADAPTER = "0";

	/** The Constant RESPONSE_STRING_ERROR. */
	public static final String RESPONSE_STRING_ERROR = "ERROR";

	/** The Constant RESPONSE_STRING_OK. */
	public static final String RESPONSE_STRING_OK = "OK";

	/** The Constant RESPONSE_STRING_SEND_MESSAGE. */
	public static final String RESPONSE_STRING_SEND_MESSAGE = "SEND_MESSAGE";

	/** The Constant RESPONSE_STRING_SUCCESS_USER_RESPONSE. */
	public static final String RESPONSE_STRING_SUCCESS_USER_RESPONSE = "Mensaje Satisfactorio";

	/** The Constant RESPONSE_STRING_SUCCESS_USER_RESPONSE. */
	public static final String RESPONSE_STRING_ERROR_PARAMETERS_NULL = "Parameters can not be null.";

	/**
	 * The Constant RESPONSE_ERROR.
	 */
	public static final int RESPONSE_CODE_ERROR = 500;

	/** The Constant RESPONSE_CODE_OK. */
	public static final int RESPONSE_CODE_OK = 200;

	/** The Constant RESPONSE_DESCRIPTION. */
	public static final String RESPONSE_DESCRIPTION = "Response : ";

	/** The Constant OK_RESPONSE. */
	public static final Response OK_RESPONSE = ProxyUtil.createResponse(RESPONSE_CODE_OK, RESPONSE_STRING_OK);

	/** The Constant CHANNEL_ID. */
	public static final String CHANNEL_ID = "2";

	/** The Constant PRODUCT_KEY. */
	public static final String PRODUCT_KEY = "USSD";

	/** The Constant PARAM_REQUEST_PLATFORM. */
	public static final String PARAM_REQUEST_PLATFORM = "PLATFORM_NAME";

	/** The Constant PARAM_REQUEST_TO. */
	public static final String PARAM_REQUEST_TO = "TO";

	/** The Constant PARAM_REQUEST_TO. */
	public static final String PARAM_REQUEST_MESSAGE = "MESSAGE";

	/** The Constant PARAM_RESPONSE_ORDER_TYPE. */
	public static final String PARAM_RESPONSE_ORDER_TYPE = "ORDER_TYPE";

	/** The Constant PARAM_RESPONSE_QUANTITY. */
	public static final String PARAM_RESPONSE_QUANTITY = "QUANTITY";

	/** The Constant PARAM_RESPONSE_PRODUCT_ID. */
	public static final String PARAM_RESPONSE_PRODUCT_ID = "PRODUCT_ID";

	/**
	 * The Constant COMMON_CONFIGURATION.
	 */
	public static final String JNDI_COMMON_CONFIGURATION = "ConfigurationJosm#hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote";

	/**
	 * Instantiates a new proxy ussd constants.
	 */
	public ProxyConstants() {
	}


}
