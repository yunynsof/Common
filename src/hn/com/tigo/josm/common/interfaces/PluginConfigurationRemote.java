/**
 * PluginConfigurationRemote.java
 * PluginConfiguration
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.exceptions.GatewayPolicyException;
import hn.com.tigo.josm.plugin.configuration.dto.ConfigurationType;

import javax.ejb.Remote;

/**
 * PluginConfigurationRemote.
 *
 * @author Alexis Berrio
 * @version 1.0
 * @since 23/01/2015 05:39:13 PM 2015
 */
@Remote
public interface PluginConfigurationRemote {


	
	/**
	 * Gets the configuration.
	 *
	 * @param xmlFile the xml file
	 * @param instanceId the instance id
	 * @return the configuration
	 * @throws GatewayPolicyException the gateway policy exception
	 */
	ConfigurationType getConfiguration(String xmlFile, String instanceId) throws GatewayPolicyException;
}
