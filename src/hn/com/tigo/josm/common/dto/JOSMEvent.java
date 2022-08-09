/**
 * JOSMEvent.java
 * DataServices
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.dto;

import hn.com.tigo.josm.common.jmx.event.MXBeanType;
import hn.com.tigo.josm.common.jmx.event.MonitoringEventType;

import java.io.Serializable;

/**
 * JOSMEvent an event generalization, this events is used for JOSM monitoring
 * listeners.
 * 
 * @author Juan Pablo Gomez <mailto:jgomezg@stefaninicolombia.com />
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
	
	/** Attribute that determine _mxBeanType. */
	private MXBeanType _mxBeanType;
	
	/**
	 * Instantiates a new JOSM event.
	 *
	 * @param type the type
	 */
	protected JOSMEvent(final MonitoringEventType type) {
		this._type = type;
		this._mxBeanType = MXBeanType.BASIC;
	}
	
	/**
	 * Instantiates a new JOSM event.
	 *
	 * @param type the type
	 * @param mxBeanType the mx bean type
	 */
	protected JOSMEvent(final MonitoringEventType type, final MXBeanType mxBeanType) {
		this._type = type;
		this._mxBeanType = mxBeanType;
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

	/**
	 * Gets the MX bean type.
	 *
	 * @return the MX bean type
	 */
	public MXBeanType getMXBeanType() {
		return _mxBeanType;
	}

	/**
	 * Sets the MX bean type.
	 *
	 * @param mxBeanType the new MX bean type
	 */
	public void setMXBeanType(final MXBeanType mxBeanType) {
		this._mxBeanType = mxBeanType;
	}
	
}
