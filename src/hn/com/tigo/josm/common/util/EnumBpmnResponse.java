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
	SUCCESSFUL(0, "SUCCESSFUL"),
	
	/** Attribute that determine FAILED. */
	FAILED(1, "FAILED");
	
	/** Attribute that determine _code. */
	private int _code;
	
	/** Attribute that determine _message. */
	private String _message;
	
	/**
	 * Instantiates a new enum bpmn response.
	 *
	 * @param code the code
	 * @param message the message
	 */
	private EnumBpmnResponse(final int code, final String message){
		this._code=code;
		this._message=message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return _code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
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
	public void setMessage(String message) {
		this._message = message;
	}
	
	
}
