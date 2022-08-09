package hn.com.tigo.josm.common.broker.compiler.task;

import hn.com.tigo.josm.common.exceptions.BPMNExecutionException;
import hn.com.tigo.josm.common.exceptions.enumerators.OrchestratorErrorCode;

import java.util.LinkedList;

import javax.script.ScriptEngine;

/**
 * EndEventError. 
 * This class represents an end event with an error definition.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 5/08/2015 10:04:45 AM 2015
 */
public class EndEventError extends AbstractElement {
	
	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Attribute that determine _errorCode. */
	private int _errorCode;
	
	/** Attribute that determine _description. */
	private String _description;
	
	
	/**
	 * Instantiates a new end event error.
	 */
	private EndEventError(){
		this.setType(TaskType.END_EVENT_ERROR);
	}
	
	/**
	 * Instantiates a new end event error.
	 *
	 * @param errorCode the error code
	 * @param description the description
	 */
	public EndEventError(final int errorCode, final String description){
		this();
		_errorCode = errorCode;
		_description = description;
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.broker.compiler.task.AbstractElement#execute(javax.script.ScriptEngine)
	 */
	@Override
	public LinkedList<AbstractElement> execute(ScriptEngine engine) throws BPMNExecutionException {
		throw new BPMNExecutionException(OrchestratorErrorCode.END_EVENT_ERROR.getError(), _errorCode+" - "+_description);
	}

}
