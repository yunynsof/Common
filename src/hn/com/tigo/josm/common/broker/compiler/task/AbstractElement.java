/**
 * AbstractElement.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.broker.compiler.task;

import hn.com.tigo.josm.common.exceptions.BPMNExecutionException;

import java.io.Serializable;
import java.util.LinkedList;

import javax.script.ScriptEngine;
/**
 * AbstractElement.
 *
 * @author Jose David Martinez
 * @version 1.0
 * @since 
 */
public abstract class AbstractElement implements Cloneable, Serializable {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Attribute that determine the _id field. */
	protected String _id;
	
	/** Attribute that determine the _name field. */
	protected String _name;
	
	/** Attribute that determine the _type field. */
	protected TaskType _type;
	
	/** Attribute that determine the _compensation block field. */
	protected AbstractElement _compensationBlock;
	
	/** Attribute that determine loopCharacteristics. */
	protected StandardLoopCharacteristics _loopCharacteristics;
	
	/** Attribute that determine _msgLogger. */
	//protected StringBuilder _msgLogger = new StringBuilder();

	/**
	 * Execute.
	 *
	 * @param engine the engine
	 * @return the list
	 * @throws BPMNExecutionException the bpmn exception
	 */
	public abstract LinkedList<AbstractElement> execute(ScriptEngine engine) throws BPMNExecutionException;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return _id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(final String id) {
		this._id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(final String name) {
		this._name = name;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public TaskType getType() {
		return _type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(final TaskType type) {
		this._type = type;
	}

	/**
	 * Gets the compensation block.
	 *
	 * @return the compensation block
	 */
	public AbstractElement getCompensationBlock() {
		return _compensationBlock;
	}

	/**
	 * Sets the compensation block.
	 *
	 * @param compensateBlock the new compensation block
	 */
	public void setCompensationBlock(final AbstractElement compensateBlock) {
		this._compensationBlock = compensateBlock;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
    public AbstractElement clone() throws CloneNotSupportedException {
        return (AbstractElement) super.clone();
    }

	/**
	 * Gets the loop characteristics.
	 *
	 * @return the loop characteristics
	 */
	public StandardLoopCharacteristics getLoopCharacteristics() {
		return _loopCharacteristics;
	}

	/**
	 * Sets the loop characteristics.
	 *
	 * @param loopCharacteristics the new loop characteristics
	 */
	public void setLoopCharacteristics(final StandardLoopCharacteristics loopCharacteristics) {
		this._loopCharacteristics = loopCharacteristics;
	}

	/**
	 * Method responsible to gets the message logger.
	 *
	 * @return the msg logger
	 */
//	public String getMsgLogger() {
//		return _msgLogger.toString();
//	}

}
