package hn.com.tigo.josm.common.util;

/**
 * EnumBpmnResponse.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0
 * @since 3/07/2015 04:23:38 PM 2015
 */
public enum EnumBpmnResponse {

	/** Attribute that determine SUCCESSFUL. */
	SUCCESSFUL("0", "SUCCESSFUL"),
	
	/** Attribute that determine FAILED. */
	FAILED("1", "FAILED"),
	
	/** Attribute that determine UNASSIGNED. */
	UNASSIGNED("100", "UNASSIGNED");
	
	/** Attribute that determine _code. */
	private String _code;
	
	/** Attribute that determine _message. */
	private String _message;
	
	/**
	 * Instantiates a new enum bpmn response.
	 *
	 * @param code the code
	 * @param message the message
	 */
	private EnumBpmnResponse(final String code, final String message){
		this._code=code;
		this._message=message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return _code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(final String code) {
		this._code = code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(final String message) {
		this._message = message;
	}
	
	
}
