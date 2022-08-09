package hn.com.tigo.josm.common.util;

import hn.com.tigo.josm.common.exceptions.GatewayPolicyException;
import hn.com.tigo.josm.common.interceptor.PluginInterceptorBinding;
import hn.com.tigo.josm.common.interfaces.GatewayPolicyRemote;
import hn.com.tigo.josm.common.interfaces.PluginConfigurationRemote;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.order.PluginRequest;
import hn.com.tigo.josm.common.order.PluginResponse;
import hn.com.tigo.josm.plugin.configuration.dto.ConfigurationType;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * AbstractPolicy.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 07-09-2015 09:17:08 AM 2015
 */
public abstract class AbstractPolicy implements GatewayPolicyRemote {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AbstractPolicy.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hn.com.tigo.josm.common.interfaces.GatewayPolicyRemote#validate(hn.com
	 * .tigo.josm.common.order.PluginRequest)
	 */
	@PluginInterceptorBinding
	@Override
	public PluginResponse validate(final PluginRequest pluginRequest) throws GatewayPolicyException {

		LOGGER.info("Init Policy Execution");

		final InterfaceFactory interfaceFactory = new InterfaceFactory();
		final PluginConfigurationRemote pluginConfiguration = interfaceFactory.getPluginConfiguration();

		final String instance = pluginRequest.getInstance();
		
		final ConfigurationType  confType = getConfiguration(pluginConfiguration, instance);
		final List<String> valuesList = getPolicyList(confType);
		
		final PluginResponse response = new PluginResponse();
		final String subscriberFeature = getSubscriberFeature(pluginRequest,confType);
		
		final String loggerInfo = "Feature: %s ValueList: %s ";
		
		LOGGER.info(String.format(loggerInfo, subscriberFeature, valuesList));
		if (isPolicyValid(subscriberFeature,valuesList)) {
			response.setResult(true);
		} else {
			response.setResult(false);
			response.setMessage(getMessage(subscriberFeature, pluginRequest,confType));
			response.setCode(getErrorCode(confType));

		}

		LOGGER.info("End Policy Execution");

		return response;

	}

	
	/**
	 * Policy apply.
	 *
	 * @param value the value
	 * @param valuesList the values list
	 * @return the boolean
	 * @throws GatewayPolicyException the gateway policy exception
	 */
	public abstract Boolean isPolicyValid(final String value, final List<String> valuesList) throws GatewayPolicyException;

	/**
	 * Gets the policy list.
	 *
	 * @param coType the co type
	 * @return the policy list
	 * @throws GatewayPolicyException the gateway policy exception
	 */
	public abstract List<String> getPolicyList(final ConfigurationType coType) throws GatewayPolicyException;

	/**
	 * Gets the policy list.
	 *
	 * @param pluginConfiguration the plugin configuration
	 * @param instance the instance
	 * @return the policy list
	 * @throws GatewayPolicyException the gateway policy exception
	 */
	public abstract ConfigurationType getConfiguration(final PluginConfigurationRemote pluginConfiguration,final String instance) throws GatewayPolicyException;

	/**
	 * Gets the policy restriction.
	 *
	 * @param pluginRequest the plugin request
	 * @param confType the conf type
	 * @return the policy restriction
	 * @throws GatewayPolicyException the gateway policy exception
	 */
	public abstract String getSubscriberFeature(final PluginRequest pluginRequest ,final ConfigurationType confType) throws GatewayPolicyException;

	
	
	/**
	 * Gets the message.
	 *
	 * @param subscriberType the subscriber type
	 * @param productId the product id
	 * @return the message
	 */
	public abstract String getMessage(final String subscriberFeature,final PluginRequest pluginRequest ,final ConfigurationType confType);
	
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public abstract int getErrorCode(ConfigurationType confType);
	
}
