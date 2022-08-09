/**
 * GatewayPolicyRemote.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.exceptions.GatewayPolicyException;
import hn.com.tigo.josm.common.order.PluginRequest;
import hn.com.tigo.josm.common.order.PluginResponse;

import javax.ejb.Remote;

/**
 * GatewayPolicyRemote.
 * 
 * Common Interface for the Policy-plugin's Projects.
 * 
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * 
 * @version 1.0
 * @since 23/01/2015 11:21:18 AM 2015
 */
@Remote
public interface GatewayPolicyRemote {

	/**
	 * Validate.
	 * 
	 * This method determines the validity of the policy.
	 *
	 * @param pluginRequest
	 *            the plugin request
	 * @return the boolean
	 */
	PluginResponse validate(PluginRequest pluginRequest) throws GatewayPolicyException;

}
