/**
 * GatewayConstant.java
 * Gateway
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * GatewayConstant. This class that stores gateway's constants,
 * 
 * @author Harold Castillo <mailto:hjobando@stefanini.com />
 * @version 1.0
 * @since 16/10/2014 11:23:44 2014
 */
public final class GatewayRemoteConstant {

	/** This constants store anonymous string. **/
	public static final String ANONYMOUS = "<anonymous>";

	/** Attribute that determine a Constant of XML_SUBSCRIBER_ACL_POLICY. */
	public static final String XML_SUBSCRIBER_ACL_POLICY = "subscriber.SubscriberACLPolicy";

	/** Attribute that determine a Constant with the path name of the folder. */
	public static final String XML_PLUGIN_CONFIGURATION_PROPERTIES = "plugin.pluginConfigurationProperties";

	/** Attribute that determine pluginConfigurationJndi. */
	private static String pluginConfigurationJndi = "java:global/PluginConfiguration-ear-1.0/PluginConfiguration-1.0/PluginConfiguration!hn.com.tigo.josm.common.interfaces.PluginConfigurationRemote";

	/** Attribute that determine a constant of the jndi of validate bean. */
	public static String gatewayRemoteJndi = "java:global.JOSM-1.0.Gateway-1.0.Gateway!hn.com.tigo.josm.common.interfaces.GatewayRemote";

	/**
	 * Instantiates a new gateway rest.
	 */
	private GatewayRemoteConstant() {

	}

	/**
	 * Sets the plugin configuration jndi.
	 *
	 * @param pluginConfigurationJndi
	 *            the new plugin configuration jndi
	 */
	public static void setPluginConfigurationJndi(final String pluginConfigurationJndi) {
		GatewayRemoteConstant.pluginConfigurationJndi = pluginConfigurationJndi;
	}

	/**
	 * @return the pluginConfigurationJndi
	 */
	public static String getPluginConfigurationJndi() {
		return pluginConfigurationJndi;
	}

	/**
	 * @param gatewayRemoteJndi
	 *            the gateway jndi to set
	 */
	public static void setGatewayRemoteJndi(String gatewayRemoteJndi) {
		GatewayRemoteConstant.gatewayRemoteJndi = gatewayRemoteJndi;
	}

}
