/**
 * ScriptTask.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.broker.compiler.task;

import hn.com.tigo.josm.common.exceptions.BPMNExecutionException;
import hn.com.tigo.josm.common.exceptions.enumerators.OrchestratorErrorCode;

import java.util.LinkedList;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * ScriptTask.
 *
 * @author Jose David Martinez
 * @version 
 * @since 17/02/2015 05:24:17 PM 2015
 */
public class ScriptTask extends AbstractElement {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Attribute that determine the _script field. */
	private String _script;
	
	
	/**
	 * Instantiates a new script task.
	 */
	private ScriptTask(){
		this.setType(TaskType.SCRIPT);
	}

	/**
	 * Instantiates a new script task.
	 *
	 * @param script the script
	 */
	public ScriptTask(final String script) {
		this();
		this._script = script;
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.broker.compiler.task.AbstractElement#execute(javax.script.ScriptEngine)
	 */
	@Override
	public LinkedList<AbstractElement> execute(ScriptEngine engine) throws BPMNExecutionException{
		try {
			engine.eval(_script);
			//_msgLogger.append(String.format(MSG_BASE, _name, _script));
		} catch (ScriptException e) {
			throw new BPMNExecutionException(OrchestratorErrorCode.SCRIPT_TASK_ERROR.getError(), e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the script.
	 *
	 * @return the script
	 */
	public String getScript() {
		return _script;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Name: " + _name + ", Type: " + _type);
		return s.toString();
	}

}
