package hn.com.tigo.josm.common.adapter;


public enum AdapterValidationType {
	
	/** Constant that defines the code LGI_ERROR. */
	NUMERIC(AdapterValidationType.CONSTANT_NUMERIC, "Validation for numeric values"),

	/** Constant that defines the code UNKNOWN_ERROR. */
	DECIMAL(AdapterValidationType.CONSTANT_DECIMAL, "Validation for decimal values"),
	
	/** Constant that defines the code UNKNOWN_ERROR. */
	ALFANUMERIC(AdapterValidationType.CONSTANT_ALFANUMERIC, "Validation for alfanumeric values"),
	
	/** Constant that defines the code UNKNOWN_ERROR. */
	ALFANUMERIC_EXTENDED(AdapterValidationType.CONSTANT_ALFANUMERIC_EXTENDED, "Validation for alfanumeric values with some special characters"),
	
	/** Constant that defines alfanumeric all type. */
	ALFANUMERIC_ALL(AdapterValidationType.CONSTANT_ALFANUMERIC_ALL, "Validation for alfanumeric values with any special characters"),
	
	/** Attribute that determine BOOLEAN. */
	BOOLEAN(AdapterValidationType.CONSTANT_BOOLEAN, "Validation for boolean values");
	
	/** Constant that defines the code CONSTANT_NUMERIC. */
	private static final int CONSTANT_NUMERIC = 1;
	
	/** Constant that defines the code CONSTANT_DECIMAL. */
	private static final int CONSTANT_DECIMAL = 2;
	
	/** Constant that defines the code CONSTANT_DECIMAL. */
	private static final int CONSTANT_ALFANUMERIC = 3;
	
	/** Constant that defines the code CONSTANT_DECIMAL. */
	private static final int CONSTANT_ALFANUMERIC_EXTENDED = 4;
	
	private static final int CONSTANT_ALFANUMERIC_ALL = 5;
	
	/** Attribute that determine a Constant of CONSTANT_BOOLEAN. */
	private static final int CONSTANT_BOOLEAN = 6;
	
	/** Attribute that stores _error. */
	private int _code;

	/** Attribute that stores _message. */
	private String _description;
	
	private AdapterValidationType(final int code, final String description){
		_code = code;
		_description = description;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return _code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this._code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return _description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this._description = description;
	}
	
	public String getValidationExpression(){
		String res = "";
		switch(this._code){
		case CONSTANT_NUMERIC:
			res = AdapterConstants.NUMERIC;
			break;
		case CONSTANT_DECIMAL:
			res = AdapterConstants.DECIMAL;
			break;
		case CONSTANT_ALFANUMERIC:
			res = AdapterConstants.ALFANUMERIC;
			break;
		case CONSTANT_ALFANUMERIC_EXTENDED:
			res = AdapterConstants.ALFANUMERIC_EXTENDED;
			break;
		case CONSTANT_BOOLEAN:
			res = AdapterConstants.BOOLEAN;
			break;
		}
		return res;
	}
}
