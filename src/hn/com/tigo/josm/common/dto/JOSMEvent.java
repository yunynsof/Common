/**
 * JOSMEvent.java
 * DataServices
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.dto;

import hn.com.tigo.josm.common.jmx.event.MonitoringEventType;

import java.io.Serializable;

/**
 * JOSMEvent an event generalization.
 * This JOSM events is used for JOSM monitoring listeners 
 * @author Juan Pablo Gomez <mailto:jgomezg@stefaninicolombia.com />
 * @version 
 * @since 27/11/2014 06:42:03 PM 2014
 */
public abstract class JOSMEvent implements Serializable {
	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = -4764771978003978540L;
	
	/** Attribute that determine component event. */
	private String _component;
	
	/** Attribute that determine objectName event. */
	private String _objectName;
	
	/** Attribute that determine type. */
	private MonitoringEventType _type;
	
	/**
	 * Instantiates a new JOSM event.
	 */
	protected JOSMEvent(final MonitoringEventType type) {
		this._type = type;
	}


	/**
	 * Gets the object name.
	 *
	 * @return the object name
	 */
	public String getObjectName() {
		return _objectName;
	}

	/**
	 * Sets the object name.
	 *
	 * @param objectName the new object name
	 */
	public void setObjectName(final String objectName) {
		this._objectName = objectName;
	}

	/**
	 * Gets the component.
	 *
	 * @return the component
	 */
	public String getComponent() {
		return _component;
	}

	/**
	 * Sets the component.
	 *
	 * @param component the new component
	 */
	public void setComponent(final String component) {
		this._component = component;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public MonitoringEventType getType() {
		return _type;
	}
	
}
