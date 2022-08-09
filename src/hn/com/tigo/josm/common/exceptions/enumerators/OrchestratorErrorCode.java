/**
 * OrchestratorErrorCode.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions.enumerators;

/**
 * OrchestratorErrorCode.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 
 * @since 16/02/2015 11:07:19 AM 2015
 */
public enum OrchestratorErrorCode {
	
	/** Constant that defines success code OK. */
	OK(0, "Success"),
	
	
	/** The bpmn script required. */
	BPMN_SCRIPT_REQUIRED(401, "Script is required in ScriptTask  %s." ),
	
	/** The bpmn script invalid. */
	BPMN_SCRIPT_INVALID(402, "Invalid script in ScriptTask  %s." ),
	
	/** The bpmn cyclic flow. */
	BPMN_CYCLIC_FLOW(403, "Cyclic flow detected at %s." ),
	
	/** The bpmn io specification. */
	BPMN_IO_SPECIFICATION(404, "IOSpecification in ServiceTask is required." ),

	/** The bpmn duplicate events. */
	BPMN_DUPLICATE_EVENTS(405, "Duplicate Event element in BPMN." ),
	
	/** The bpmn start event expected. */
	BPMN_START_EVENT_EXPECTED(406, "StartEvent Expected." ),
	
	/** The bpmn statement recahed past. */
	BPMN_STATEMENT_RECAHED_PAST(407, "Statement reached past end of program." ),
	
	/** The bpmn multiple flow elements expected. */
	BPMN_MULTIPLE_FLOW_ELEMENTS_EXPECTED(408, "Multiple flow elements Expected." ),
	
	/** The bpmn sequience flow expected. */
	BPMN_SEQUIENCE_FLOW_EXPECTED(409, "SequenceFlow Expected." ),
	
	/** The bpmn expected task. */
	BPMN_EXPECTED_TASK(410, "Expected Task or ExclusiveGateWay or EndEvent." ),
	
	/** The bpmn parser file task. */
	BPMN_PARSER_FILE_TASK(411, "File parser exception." ),
	
	/** Constant that defines class not found error. **/
	TYPE_NOT_FOUND(412 , "The class type <s%> not found."),
	
	/** Attribute that determine the platform error field. */
	PLATFORM_ERROR(413, "The platform has thrown a controlled error code."),
	
	/** Attribute that determine the bpmn error field. */
	BPMN_ERROR(414, "The BPM model has thrown a controlled error code."),

	/** Attribute that determine interrupt debug field. */
	INTERRUPT_DEBUG(415, "The debugger has been interrupted."),

	/** Attribute that determine the bpmn error field. */
	SCRIPT_TASK_ERROR(416, "JavaScript execution error.");

	
	/** Attribute that stores _error. */
	private int _error;

	/** Attribute that stores _message. */
	private String _message;

	/**
	 * Instantiates a new code exception.
	 * 
	 * @param error
	 *            the error
	 * @param message
	 *            the message
	 */
	private OrchestratorErrorCode(final int error, final String message) {
		this._error = error;
		this._message = message;
	}

	/**
	 * Method responsible to gets the error.
	 * 
	 * @return the _error
	 */
	public int getError() {
		return _error;
	}

	/**
	 * Method responsible to sets the error.
	 * 
	 * @param error
	 *            the error to set
	 */
	public void setError(final int error) {
		this._error = error;
	}

	/**
	 *Method responsible to gets the message.
	 * 
	 * @return the _message
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Method responsible to sets the message.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this._message = message;
	}
}
