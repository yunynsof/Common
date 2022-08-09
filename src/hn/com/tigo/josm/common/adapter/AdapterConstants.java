/**
 * AdapterConstants.java
 * LTE-EJB
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.adapter;

import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;


/**
 * AdapterConstants. This class defines the constants used by the adapters
 * 
 * @author Juan Pablo Gomez <mailto:jgomezg@stefaninicolombia.com />
 * @version 1.0
 * @see
 * @since 06-oct-2014 15:44:56 2014
 */
public final class AdapterConstants {

	/**
	 * CONFIGURATION_JDNI constant of type String.
	 */
	public static String CONFIGURATION_JDNI = InterfaceFactory.COMMON_CONFIGURATION_REMOTE;
	
	/**
	 * EMPTY constant of type String.
	 */
	public static final String EMPTY = "";

	/** ZERO   constant  of type int. */
	public static final int ZERO = 0;

	/** TYPE_CONVERSION_ERROR_MSG constant of type string. */
	public static final String TYPE_CONVERSION_ERROR_MSG = "Error occurred converting data type ";

	/** NUMERIC constant of type string. */
	public static final String NUMERIC = "^[0-9]+$";
	
	/** DECIMAL constant of type string. */
	public static final String DECIMAL = "^\\-{0,1}\\d+\\.{0,1}[0-9]+$";

	/** ALFANUMERIC constant of type string. */
	public static final String ALFANUMERIC = "^[a-zA-Z0-9\\_]+$";
	
	/** ALFANUMERIC constant of type string. */
	public static final String ALFANUMERIC_EXTENDED = "^[a-zñA-ZÑ0-9\\_\\/\\-\\s\\=\\>\\<\\!\\¡\\:\\.\\&\\,\\;\\*\\¿\\?\\#\\+]+$";
	
	/** ALFANUMERIC ALL constant of type string. */
	public static final String ALFANUMERIC_ALL = "(.*?)|(.*?(\\n))+.*?";
	
	/** Attribute that determine a Constant of BOOLEAN. */
	public static final String BOOLEAN = "([T,t][R,r][U,u][E,e])|([F,f][A,a][L,l][S,s][E,e])";
	
	/** Attribute that determine a Constant of IP_V4. */
	public static final String IP_V4 = "^(?=\\d+\\.\\d+\\.\\d+\\.\\d+$)(?:(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\\.?){4}$";
	
	/** Attribute that determine a Constant of ALL. */
	public static final String ALL = null;
	
	
	/** Attribute that determine a constant for new line character. */
	public static final String NEW_LINE = "\n";
	
	/** Attribute that determine the constant missing parameter message. */
	public static final String MSG_MISSING_PARAMETER = "Missing parameter <%s>";
	
	/** Attribute that determine the constant invalid parameter message. */
	public static final String MSG_INVALID_PARAMETER = "Parameter <%s> value is invalid";
	
	/** Attribute that determine the constant invalid parameter message. */
	public static final String MSG_INVALID_PARAMETER_COMPARE_DATE = "Parameter <%s> value cannot be greater than Parameter <%s>";

	/** Attribute that determine the Constant MSG_INVALID_PARAMETER. */
	public static final String MSG_INVALID_PARAMETER_LENGTH = "Maximum length is %s characters for %s parameter";
	/**
	 * Attribute that determine the Constant MSG_INVALID_PARAMETER_LENGTH_BETWEEN.
	 */
	public static final String MSG_INVALID_PARAMETER_LENGTH_BETWEEN = "Length must be between  %s and %s characters for %s parameter";

	/** Attribute that determine the Constant PARAMETER_LENGH_64. */
	public static final int PARAMETER_LENGH_64 = 64;
	
	/** Attribute that determine the Constant PARAMETER_LENGH_32. */
	public static final int PARAMETER_LENGH_32 = 32;
	
	/** Attribute that determine the Constant PARAMETER_LENGH_8. */
	public static final int PARAMETER_LENGH_8 = 8;
	
	/** Attribute that determine a Constant of XML_DATE_PATTERN. */
	public static final String XML_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	
	/** Attribute that determine a Constant of XML_DATE_PATTERN_2. */
	public static final String XML_DATE_PATTERN_MILL = "yyyy-MM-dd'T'HH:mm:ss";
	
	/** Attribute that determine a Constant of FAULT_ERROR_CODE. */
	public static final String FAULT_ERROR_CODE = "/Fault/detail/ErrorCode";
	
	/** Attribute that determine a Constant of FAULT_ERROR_DESC. */
	public static final String FAULT_ERROR_DESC = "/Fault/detail/ErrorDescription";
	
	/**
	 * Instantiates a new adapter constants.
	 */
	private AdapterConstants() {

	}

	
}
