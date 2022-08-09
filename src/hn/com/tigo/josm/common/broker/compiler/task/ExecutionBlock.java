/**
 * SwitchBlock.java
 * BPMNCompiler
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.broker.compiler.task;

import hn.com.tigo.josm.common.exceptions.BPMNExecutionException;
import hn.com.tigo.josm.common.exceptions.enumerators.OrchestratorErrorCode;

import java.util.LinkedList;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.log4j.Logger;

/**
 * ExecutionBlock.
 *
 * @author Jose David Martinez
 * @version 1.0
 * @since 13/01/2015 11:33:17 AM 2015
 */
public class ExecutionBlock extends AbstractElement {
	
	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** This attribute contains an instance of log4j logger for  Engine.  */
	private static final transient Logger LOGGER = Logger.getLogger(ExecutionBlock.class);

	/** Attribute that determine _conditions. */
	private String _preConditions;

	/** Attribute that determine _executableBlocks. */
	private LinkedList<AbstractElement> _executionList;
	
	/**
	 * Instantiates a new execution block.
	 */
	public ExecutionBlock(TaskType type) {
		super();
		_type = type;
		_executionList = new LinkedList<AbstractElement>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hn.com.tigo.josm.broker.compiler.task.AbstractTask#execute(javax.script
	 * .ScriptEngine)
	 */
	@Override
	public LinkedList<AbstractElement> execute(ScriptEngine engine) throws BPMNExecutionException {

		Boolean success = null;

		try {
			LOGGER.info("preConditions: "+ _preConditions);
			if (_preConditions == null) {
				success = true;
			}
			else {
				success = (Boolean) engine.eval(_preConditions);
				LOGGER.info("eval: " + success);
				//_msgLogger.append(String.format(MSG_BASE, getType(), _name, _preConditions, success));
				//_msgLogger.append(AdapterConstants.NEW_LINE);
			}
			
			if(success == null){
				throw new BPMNExecutionException(OrchestratorErrorCode.SCRIPT_TASK_ERROR.getError(),
						"Invalid preconditions: " + toString());
			}

			if (success.booleanValue()) {
				return _executionList;

			}

		} catch (ScriptException e) {
			throw new BPMNExecutionException(OrchestratorErrorCode.SCRIPT_TASK_ERROR.getError(), e.getMessage(), e);
		}
		return null;

	}

	/**
	 * Gets the conditions.
	 *
	 * @return the conditions
	 */
	public String getPreConditions() {
		return _preConditions;
	}

	/**
	 * Sets the conditions.
	 *
	 * @param _conditions
	 *            the new conditions
	 */
	public void setPreConditions(final String conditions) {
		this._preConditions = conditions;
	}

	/**
	 * Gets the executable blocks.
	 *
	 * @return the executable blocks
	 */
	public LinkedList<AbstractElement> getExecutionList() {
		return _executionList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder strSwitchBlock = new StringBuilder();
		strSwitchBlock.append("Name: ").append(_name).append(", Type: ").append(_type)
				.append(", Conditions: ").append("[" + getPreConditions() + "] ");

		return strSwitchBlock.toString();
	}

}
