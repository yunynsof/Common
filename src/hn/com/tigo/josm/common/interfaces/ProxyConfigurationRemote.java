/**
 * ProxyConfigurationRemote.java
 * ProxyConfiguration
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.proxy.configuration.dto.ProxyConfigurationResponse;

import javax.ejb.Remote;

/**
 * The Interface ProxyConfigurationRemote that exposes getProxyConfiguration
 * method.
 * 
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 
 * @since 26/11/2014 05:41:30 PM 2014
 */
@Remote
public interface ProxyConfigurationRemote {

	
	/**
	 * Method that gets the proxy configuration for kannel.
	 * Retrieves configuration values from a XML file searching the
	 * corresponding set according to the given parameters. 
	 *
	 * @param command the text associated with an order command in a given platform.
	 * @param destination the destination number users sent the command using an option or a word.
	 * @return the proxy configuration response wrapping the proxy element
	 * or an empty response if no matches found with the given parameters.
	 */
	ProxyConfigurationResponse getProxyConfiguration(final String command, final String destination);
}
