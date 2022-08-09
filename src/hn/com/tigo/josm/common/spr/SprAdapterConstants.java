package hn.com.tigo.josm.common.spr;


/**
 * The Class SprAdapterConstants class contains all constant parameters for
 * SprAdapter monitor configuration. The parameters are
 * max_throughput,login_system_code,root_endpoint
 * ,password,request_timeout_value
 * ,connect_timeout_value,config_timeout_value,version,owner.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version 1.0
 * @since 17/03/2015 10:20:40 AM 2015
 */
public final class SprAdapterConstants {
	
	/** The Constant REQUEST_TIMEOUT. */
	public static final String REQUEST_TIMEOUT = "com.sun.xml.ws.request.timeout";
	
	/** The Constant CONNECT_TIMEOUT. */
	public static final String CONNECT_TIMEOUT = "com.sun.xml.ws.connect.timeout";
	
	/** The Constant PORT_8080. */
	public static final int PORT_8080 = 8080;
	
	/** The Constant PORT_8787. */
	public static final int PORT_8787 = 8787;
	
	/** The Constant HTTP_RESPONSE_200. */
	public static final int HTTP_RESPONSE_200 = 200;
	
	/** The Constant HTTP_RESPONSE_204. */
	public static final int HTTP_RESPONSE_204 = 204;

	/** The Constant CUSTOM. */
	public static final String CUSTOM = "Custom";

	/** The Constant EXPRESSION_NAME_VALUE_OP_STATE. */
	public static final String EXPRESSION_NAME_VALUE_OP_STATE = "<expr><attr name=\"%s\"/><op value=\"=\"/><value val=\"%s\" isnull=\"y\"/></expr>";
	
	/** The Constant EXPRESSION_NAME_VALUE_OP_QUOTA. */
	public static final String EXPRESSION_NAME_VALUE_OP_QUOTA = "<expr><attr name=\"%s\"/><op value=\"=\"/><value val=\"%s\"/></expr>";
	
	/** The Constant EXPRESION. */
	public static final String EXPRESSION_NAME_VALUE = "<expr><attr name=\"%s\"/><value val=\"%s\"/></expr>";
	
	/** The Constant EXPRESSION_NAME. */
	public static final String EXPRESSION_NAME = "<expr><attr name=\"%s\"/></expr>";
	
	/** The Constant EXPRESSION_BODY. */
	public static final String EXPRESSION_BODY = "<tx><req name=\"%s\">%s<%s>%s</%s>%s</req></tx>";
	
	/** The Constant EXPRESSION_ENTITY. */
	public static final String EXPRESSION_ENTITY = "<ent name=\"%s\" ns=\"policy\"/>";
	
	/** The Constant XPATH_QUERY. */
	public static final String XPATH_QUERY = "/tx/req/res";

	/** The Constant XPATH_QUERY_SELECT. */
	public static final String XPATH_QUERY_SELECT = "/tx/req/select";

	/** The Constant XPATH_QUERY_SELECT. */
	public static final String XPATH_QUERY_SELECT_ROW = "/tx/req/rset/row";
	
	/** The Constant XPATH_QUERY_PATTERN_RESPONSE. */
	public static final String XPATH_QUERY_PATTERN_ERROR_RESPONSE = "<res error=\"(\\d+)\".+?affected=\"(\\d+)\">";
																	 
	/** The Constant XPATH_QUERY_PATTERN_RV_RESPONSE. */
	public static final String XPATH_QUERY_PATTERN_RV_RESPONSE = "<rv><\\/rv>|<rv>(.+?)<\\/rv>|<rv null=(.+?)/>";
	
	
	/** The Constant XPATH_QUERY_PATTERN_QUOTA_RESPONSE. */
	public static final String XPATH_QUERY_PATTERN_QUOTA_RESPONSE = "<quota name=\"(.+?)\">.+?<totalVolume>(.+?)<\\/totalVolume>";
	
	/** The Constant XPATH_QUERY_PATTERN_STATE_RESPONSE. */
	public static final String XPATH_QUERY_PATTERN_STATE_RESPONSE = "<property><name>(.+?)<\\/name><value>(.+?)<\\/value><\\/property>";
	
	/** The Constant PARAM_OPERATION_SET. */
	public static final String PARAM_OPERATION_SET = "set";

	/** The Constant CONFIG_EXPIRATION. */
	public static final Integer CONFIG_EXPIRATION = 3000;

	/** Attribute that determine the constant max throughput. */
	public static final int MAX_THROUGHPUT = 50;

	/** Attribute that determine a constant of driver pool size. */
	public static final int DRIVER_POOL_SIZE = 20;

	/** Attribute that determine a constant of request timeout value. */
	public static final Integer REQUEST_TIMEOUT_VALUE = 30000;

	/** The Constant CONNECT_TIMEOUT_VALUE. */
	public static final Integer CONNECT_TIMEOUT_VALUE = 3000;

	/** Attribute that determine a constant of config timeout value. */
	public static final Long CONFIG_TIMEOUT_VALUE = 30 * 60000L;

	/** Attribute that determine a constant for new line character. */
	public static final String CHANGE_LINE = "\n";

	/** Attribute that determine the Constant SECURITY_FAILED_CODE. */
	public static final String SECURITY_FAILED_CODE = "40";

	/** The Constant PARAM_OPERATION. */
	public static final String PARAM_OPERATION = "OPERATION";

	/** The Constant PARAM_OPERATION_SELECT. */
	public static final String PARAM_OPERATION_SELECT = "select";

	/** The Constant PARAM_OPERATION_INSERT. */
	public static final String PARAM_OPERATION_INSERT = "insert";

	/** The Constant PARAM_OPERATION_DELETE. */
	public static final String PARAM_OPERATION_DELETE = "delete";

	/** The Constant PARAM_OPERATION_UPDATE. */
	public static final String PARAM_OPERATION_UPDATE = "update";

	/** The Constant PARAM_ENTITY. */
	public static final String PARAM_ENTITY = "ENTITY";
	
	/** The Constant PARAM_QUOTA. */
	public static final String PARAM_QUOTA = "QUOTA";
	
	/** The Constant PARAM_STATE. */
	public static final String PARAM_STATE = "STATE";

	/** The Constant CUSTOM_QUANTITY. */
	public static final String CUSTOM_QUANTITY = "CUSTOM_QUANTITY";
	
	/** The Constant PARAM_WHERE_ATTRIBUTE. */
	public static final String PARAM_MSISDN = "MSISDN";
	
	/** The Constant PARAM_SOAP_REQUEST. */
	public static final String PARAM_SOAP_REQUEST_DATA = "SOAP_REQUEST_DATA";
	
	/** The Constant PARAM_SOAP_REQUEST_URL. */
	public static final String PARAM_SOAP_REQUEST_URL = "SOAP_REQUEST_URL";

	/** The Constant NAME_QUOTA. */
	public static final String PARAM_NAME_QUOTA = "NAME_QUOTA";
	
	/** The Constant VALUE_QUOTA. */
	public static final String PARAM_VALUE_QUOTA = "totalVolume";
	
	/** The Constant PARAM_VALUE_QUOTA_IN. */
	public static final String PARAM_VALUE_QUOTA_IN = "VALUE_QUOTA";
	
	/** The Constant CONNECTION. */
	public static final String CONNECTION = "Connection";

	/** The Constant TYPE_REQUEST. */
	public static final String TYPE_REQUEST = "TYPE_REQUEST";
	
	/** The Constant METHOD_POST. */
	public static final String METHOD_POST = "POST";
	
	/** The Constant METHOD_GET. */
	public static final String METHOD_GET = "GET";
	
	/** The Constant METHOD_PUT. */
	public static final String METHOD_PUT = "PUT";

	/**
	 * Instantiates a new spr adapter constants.
	 */
	private SprAdapterConstants() {
	}

}
