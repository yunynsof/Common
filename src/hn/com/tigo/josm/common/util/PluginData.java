/**
 * PluginData.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * PluginData.
 * 
 * Class type data transfer object, for the project Gateway Plugin.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 26/01/2015 14:44:09 2015
 */
public class PluginData {

	
	/** Attribute that determine instanceId. */
	private Long instanceId;
	
	/** Attribute that determine instanceName. */
	private String instanceName;

	/** Attribute that determine policyId. */
	private Long policyId;

	/** Attribute that determine policyName. */
	private String policyName;

	/** Attribute that determine jndi. */
	private String jndi;
	
	/** The all or nothing. */
	private int allOrNothing ; 

	/**
	 * Instantiates a new plugin data.
	 *
	 * @param instanceId the instance id
	 * @param instanceName            the instance name
	 * @param policyId the policy id
	 * @param policyName            the policy name
	 * @param jndi            the jndi
	 */
	public PluginData(final long instanceId, final String instanceName, final long policyId, final String policyName, final String jndi,final int allOrNothing) {
		super();
		this.instanceId = instanceId;
		this.instanceName = instanceName;
		this.policyId = policyId;
		this.policyName = policyName;
		this.jndi = jndi;
		this.allOrNothing = allOrNothing; 
	}

	/**
	 * Gets the instance name.
	 *
	 * @return the instanceName
	 */
	public String getInstanceName() {
		return instanceName;
	}

	/**
	 * Sets the instance name.
	 *
	 * @param instanceName
	 *            the instanceName to set
	 */
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	/**
	 * Gets the policy id.
	 *
	 * @return the policyId
	 */
	public Long getPolicyId() {
		return policyId;
	}

	/**
	 * Sets the policy id.
	 *
	 * @param policyId            the policyId to set
	 */
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	/**
	 * Gets the policy name.
	 *
	 * @return the policyName
	 */
	public String getPolicyName() {
		return policyName;
	}

	/**
	 * Sets the policy name.
	 *
	 * @param policyName
	 *            the policyName to set
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	/**
	 * Gets the jndi.
	 *
	 * @return the jndi
	 */
	public String getJndi() {
		return jndi;
	}

	/**
	 * Sets the jndi.
	 *
	 * @param jndi
	 *            the jndi to set
	 */
	public void setJndi(String jndi) {
		this.jndi = jndi;
	}

	/**
	 * Gets the instance id.
	 *
	 * @return the instance id
	 */
	public Long getInstanceId() {
		return instanceId;
	}

	/**
	 * Sets the instance id.
	 *
	 * @param instanceId the new instance id
	 */
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * Gets the all or nothing.
	 *
	 * @return the all or nothing
	 */
	public int getAllOrNothing() {
		return allOrNothing;
	}

	/**
	 * Sets the all or nothing.
	 *
	 * @param allOrNothing the new all or nothing
	 */
	public void setAllOrNothing(int allOrNothing) {
		this.allOrNothing = allOrNothing;
	}
	

}
