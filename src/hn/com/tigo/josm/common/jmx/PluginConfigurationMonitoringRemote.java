/**
 * PluginConfigurationMonitoringRemote.java
 * PluginConfiguration
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.jmx;

import javax.ejb.Remote;

/**
 * PluginConfigurationMonitoringRemote.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 13/02/2015 15:08:04
 */
@Remote
public interface PluginConfigurationMonitoringRemote {

	/**
	 * Method to remove a policy cache policies.
	 *
	 * @param configurationType
	 *            Path of the xml to erase for example: <code>folder.file</code>
	 */
	void removePolicy(String configurationType);

	/**
	 * Method to remove all cached schemas.
	 */
	void resetPolicies();
	
}
