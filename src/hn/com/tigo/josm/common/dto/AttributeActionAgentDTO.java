/**
 * AttributeActionAgentDTO.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.dto;

import java.math.BigDecimal;

/**
 * AttributeActionAgentDTO.
 * DTO for AttributeActionAgent.
 *
 * @author Harold Castillo <mailto:hjobando@stefanini.com />
 * @version 1.0
 * @since 24/10/2014 14:23:44 2014
 */
public class AttributeActionAgentDTO {
	
	/** This attribute stores the actionId. */
	private BigDecimal actionId;
	
	/** This attribute stores the name. */
	private String name;
	
	/** This attribute stores the defaultValue. */
	private String defaultValue;
	
	/** This attribute stores the type. */
	private String type;
	
	/** This attribute stores the agentId. */
	private Long agentId;
	
	/**  This attribute stores the value. */
	private String value;
	
	/**  This attribute stores the endpoint. */
	private String endpoint;
	
	/**
	 * Instantiates a new attribute action agent dto.
	 */
	public AttributeActionAgentDTO() {
	}
	

	/**
	 * Instantiates a new attribute action agent dto.
	 *
	 * @param actionId Id of action
	 * @param name Name of action
	 * @param defaultValue Value of action
	 * @param type type of action
	 * @param agentId agent id
	 * @param endpoint value
	 */
	public AttributeActionAgentDTO(BigDecimal actionId, String name,
			String defaultValue, String type, long agentId, String endpoint) {
		super();
		this.actionId = actionId;
		this.name = name;
		this.defaultValue = defaultValue;
		this.type = type;
		this.agentId = agentId;
		this.endpoint = endpoint;
	}

	/**
	 * Gets the action id.
	 *
	 * @return the actionId
	 */
	public BigDecimal getActionId() {
		return actionId;
	}

	/**
	 * Sets the action id.
	 *
	 * @param actionId the actionId to set
	 */
	public void setActionId(BigDecimal actionId) {
		this.actionId = actionId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the default value.
	 *
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value.
	 *
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the agent id.
	 *
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * Sets the agent id.
	 *
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}


	/**
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
}
