package hn.com.tigo.josm.common.util;

public class JOSMConstants {
	
	/** Attribute that determine a constant with the partitioning file name. */
	public static final String PARTITION_FILE = "JOSM";
	
	/** Attribute that determine a constant with the partitioning file name for the external datasource (dev/prod). */
	public static final String PARTITION_FILE_EXT = "JOSM_EXT";
	
	/** Attribute that determine a constant with the minimum length of a product Id */	
	public static final int ID_PRODUCT_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a product Id */
	public static final long ID_PRODUCT_MAX = 999999999999L;
	
	/** Attribute that determine a constant with the maximum length of a product name */
	public static final int NAME_PRODUCT_MAX = 50;
	
	/** Attribute that determine a constant with the maximum length of a product name */
	public static final int DESCRIPTION_PRODUCT_MAX = 200;
	
	/** Attribute that determine a constant with the minimum length of a product family Id */
	public static final int ID_PRODUCT_FAMILY_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a product family Id */
	public static final long ID_PRODUCT_FAMILY_MAX = 999999999999L; 
	
	/** Attribute that determine a constant with the maximum length of a product family name */
	public static final int NAME_PRODUCT_FAMILY_MAX = 50;
	
	/** Attribute that determine a constant with the maximum length of a product family description */
	public static final int DESCRIPTION_PRODUCT_FAMILY_MAX = 200; 
	
	/** Attribute that determine a constant with the maximum page number */
	public static final int PAGE_NUMBER_MIN = 0;
	
	/** Attribute that determine a constant with the minimum page number */
	public static final long PAGE_NUMBER_MAX = 999999999999999L;
	
	/** Attribute that determine a constant with the minimum page size */
	public static final int PAGE_SIZE_MIN = 0;
	
	/** Attribute that determine a constant with the maximum page size */
	public static final long PAGE_SIZE_MAX = 999999999999L;
	
	/** Attribute that determine a constant with the default page size */
	public static final long PAGE_SIZE_DEFAULT = 999999999999L;
	
	/** Attribute that determine a constant with the default page number */
	public static final int PAGE_NUMBER_DEFAULT = 1;
	
	/** Attribute that determine a constant with the maximum length of a channel description */
	public static final int DESCRIPTION_CHANNEL_MAX = 200;
	
	/** Attribute that determine a constant with the minimum length of a channel id */
	public static final int ID_CHANNEL_MIN = 0;
	
	/** Attribute that determine a constant with the maximum length of a channel id */
	public static final int ID_CHANNEL_MAX = 99999;
	
	/** Attribute that determine a constant with the minimum length of a message id */
	public static final int ID_MESSAGEBUNDLE_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a message id */
	public static final long ID_MESSAGEBUNDLE_MAX = 999999999999L; 
	
	/** Attribute that determine a constant with the maximum length of a message text in a messageBundle */
	public static final int MESSAGETEXT_MESSAGEBUNDLE_MAX = 500;
	
	/** Attribute that determine a constant with the maximum length of a message from in a messageBundle */
	public static final int MESSAGEFROM_MESSAGEBUNDLE_MAX = 20;
	
	/** Attribute that determine a constant with the minimum length of a product message id */
	public static final int ID_PRODUCTMESSAGE_MIN = 1;
	
	/** Attribute that determine a constant with the minimum length of a policy id */
	public static final int ID_POLICY_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a policy id */
	public static final long ID_POLICY_MAX = 999999999999L;
	
	/** Attribute that determine a constant with the maximum length of a policy name */
	public static final int NAME_POLICY_MAX = 50;
	
	/** Attribute that determine a constant with the maximum length of a policy jndi */
	public static final int JNDI_POLICY_MAX = 200;
	
	/** Attribute that determine a constant with the minimum length of a policy instance id */
	public static final int ID_POLICYINSTANCE_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a policy instance id */
	public static final long ID_POLICYINSTANCE_MAX = 999999999999L;
	
	/** Attribute that determine a constant with the minimum length of a policy instance name */
	public static final int NAME_POLICYINSTANCE_MAX = 50;
	
	/** Attribute that determine a constant with the minimum length of a product policy instance id */
	public static final int ID_PRODUCTPOLICYINSTANCE_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a product policy instance id */
	public static final long ID_PRODUCTPOLICYINSTANCE_MAX = 999999999999L;
	
	/** The Constant pattern xml gregorian calendar. */
	public static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}-\\d{2}:\\d{2}";
	
	/** Attribute that determine a constant with the minimum length of a product policy instance priority */
	public static final int PRIORITY_PRODUCTPOLICYINSTANCE_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a product policy instance priority */
	public static final long PRIORITY_PRODUCTPOLICYINSTANCE_MAX = 999999999999L;
	
	/** Attribute that determine a Constant of PATTERN_TIMESTAMP_FORMAT. */
	public static final String PATTERN_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	
	/** Attribute that determine a constant with the minimum length of a product bpm version id. */
	public static final int ID_PRODUCTBPMVERSION_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a product bpm version id. */
	public static final int ID_PRODUCTBPMVERSION_MAX = 99999999;
	
	/** Attribute that determine a constant with the minimum length of a  bpm version id. */
	public static final int ID_BPMVERSION_MIN = 1;
	
	/** Attribute that determine a constant with the maximum length of a  bpm version id. */
	public static final int ID_BPMVERSION_MAX = 99999999;
	
	/** Attribute that determine a constant with the pattern for the valid values of an order type. */
	public static final String ORDER_TYPE_PATTERN = "(ACTIVATE|DEACTIVATE|LOAN|PURCHASE|SELL|TRANSFER)";
	
	/** Attribute that determine a constant with the maximum value of a product bpm version bpm state */
	public static final int BPMSTATE_PRODUCTBPMVERSION_MAX = 1;
	
	/** Attribute that determine a constant with the pattern of the value of a product bpm version bpm state */
	public static final String BPMSTATE_PRODUCTBPMVERSION_PATTERN = "(0|1)";
	
	/** Attribute that determine a constant with the maximum value of a bpm version name. */
	public static final int NAME_BPMVERSION_MAX = 100;
	
	/** Attribute that determine a constant with the default version for new bpm versions.  */
	public static final String VERSION_BPMVERSION_DEFAULT="1.0.0";
	
	/** Attribute that determine the pattern of a editType in a bpm version. */
	public static final String  EDITTYPE_BPMVERSION_PATTERN ="(MAJOR|MINOR|PATCH)";
	
	/** Attribute that determine the regex separator for the versions in bpm version. */
	public static final String VERSION_SEPARATOR_BPMVERSION_REGEX = "\\."; 
	
	/** Attribute that determine the separator for the versions in bpm version. */
	public static final String VERSION_SEPARATOR_BPMVERSION = ".";
	
	/** Attribute that determine the separator for the versions in bpm version. */
	public static final String XML_BPMVERSION_SINGLE_VALUE_DEFAULT = "0";
	
	/** Attribute that determine the length of a version */
	public static final int XML_BPMVERSION_LENGTH_VALUE = 3;
	
	/** Attribute that determine the X position in the array for a version. */
	public static final int X_VERSION_POSITION = 0;
	
	/** Attribute that determine the Y position in the array for a version. */
	public static final int Y_VERSION_POSITION = 1;
	
	/** Attribute that determine the Z position in the array for a version. */
	public static final int Z_VERSION_POSITION = 2;
	
	/** Attribute that determine a constant with the minimum value if a param id. */
	public static final int ID_PARAM_MIN = 1;
	
	/** Attribute that determine a constant with the maximum value if a param id. */
	public static final long ID_PARAM_MAX = 999999999999L;
	
	/** Attribute that determine a constant with the max length of a param name. */
	public static final int NAME_PARAM_MAX = 50;
	
	/** Attribute that determines a constant with the pattern for a datasource in param. */
	public static final String DATASOURCE_PARAM_PATTERN = "(PC|C)";
	
	/** Attribute that determines a constant with the maximum length of a param value. */
	public static final int VALUE_PARAM_MAX = 1000;
	
	/** Attribute that determines a constant with the minimum value of a product param id. */
	public static final int ID_PRODUCTPARAM_MIN = 1;
	
	/** Attribute that determines a constant with the maximum value of a product param id. */
	public static final long ID_PRODUCTPARAM_MAX = 999999999999L;
	
	/** Attribute that determine a constant with the Insert Operation Type */
	public static final String OPERATION_TYPE_INSERT = "I";
	
	/** Attribute that determine a constant with the Edit Operation Type */
	public static final String OPERATION_TYPE_EDIT = "U";
	
	/** Attribute that determine a constant with the Insert Operation Type */
	public static final String OPERATION_TYPE_DELETE = "D";
	
	/** Attribute that determine the minimum value of a data transfer id */
	public static final int ID_DATATRANSFER_MIN = 1;
	
	/** Attribute that determine the maximum value of a data transfer id */
	public static final long ID_DATATRANSFER_MAX = 999999999999L;
	
	/** Attribute that determine the success operation of an enumJOSM. */
	public static final String SUCCESS_RESPONSE_CODE = "0";
	
	/** Attribute that determine the open (newly created) state in the data transfer object */
	public static final String STATE_DATATRANSFER_OPEN = "O";
	
	/** Attribute that determine the checked state in the data transfer object */
	public static final String STATE_DATATRANSFER_CHECKED = "C";
	
	/** Attribute that determine the open (newly created) state in the data transfer object */
	public static final String STATE_DATATRANSFER_IMPORTED = "I";
	
	/** Attribute that determine the open (newly created) state in the data transfer object */
	public static final String STATE_DATATRANSFER_BACKEDUP = "B";
	
	/** Attribute that determine a constant with the pattern for the valid values of an order type. */
	public static final String STATE_DATATRANSFER_PATTERN = "(O|C|I|B)";
	
	/** Attribute that determine a constant with the success code for a response **/
	public static final String RESPONSE_SUCCESS_CODE = "0";
	
	/**Attribute that determine the detail index according to the simple or complex order**/ 
	public static final String DETAIL_ID = "0";
	
	
	
	
	
		
	
	
}
