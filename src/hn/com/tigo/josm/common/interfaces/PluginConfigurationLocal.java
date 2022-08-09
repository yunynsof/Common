/**
 * PluginConfigurationLocal.java
 * PluginConfiguration
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.exceptions.GatewayPolicyException;
import hn.com.tigo.josm.plugin.configuration.dto.ConfigurationType;

import javax.ejb.Local;

/**
 * PluginConfigurationLocal.
 *
 * @author Alexis Berrio
 * @version 1.0
 * @since 26/01/2015 08:59:01 AM 2015
 */
@Local
public interface PluginConfigurationLocal {

	
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
