/**
 * InterfaceFactory.java
 * Common
 * Copyright (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.interfaces.producer;

import hn.com.tigo.josm.common.adapter.task.Task;
import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;
import hn.com.tigo.josm.common.interfaces.CrudServiceAsyncLocal;
import hn.com.tigo.josm.common.interfaces.CrudServiceLocal;
import hn.com.tigo.josm.common.interfaces.CrudServiceRemote;
import hn.com.tigo.josm.common.interfaces.GatewayRemote;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote;
import hn.com.tigo.josm.common.interfaces.PluginConfigurationRemote;
import hn.com.tigo.josm.common.jmx.PluginConfigurationMonitoringRemote;
import hn.com.tigo.josm.common.jmx.ProfileMonitoringRemote;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import org.apache.log4j.Logger;

/**
 * A factory for creating Interface objects using producer methods.
 */

@Dependent
public class InterfaceFactory {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(InterfaceFactory.class);

	/** Attribute that determine PLUGIN_CONFIGURATION_REMOTE. */
	public static String PROFILE_MONITORING_REMOTE = "java:global/Profile/ServiceProfile/ProfileMonitoring!hn.com.tigo.josm.common.jmx.ProfileMonitoringRemote";

	/** Attribute that determine PLUGIN_CONFIGURATION_REMOTE. */
	public static String COMMON_CONFIGURATION_REMOTE = "java:global.Common-ConfigurationEAR.Common-Configuration.ConfigurationJosm!hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote";

	/** Attribute that determine PLUGIN_CONFIGURATION_MONITORING. */
	public static String PLUGIN_CONFIGURATION_MONITORING_REMOTE = "java:global/PluginConfiguration-ear/PluginConfiguration/PluginConfigurationMonitoring!hn.com.tigo.josm.common.jmx.PluginConfigurationMonitoringRemote";

	/** Attribute that determine PLUGIN_CONFIGURATION_REMOTE. */
	public static String PLUGIN_CONFIGURATION_REMOTE = "java:global.PluginConfigurationEAR.PluginConfiguration.PluginConfiguration!hn.com.tigo.josm.common.interfaces.PluginConfigurationRemote";

	/** Attribute that determine CRUD_SERVICE_REMOTE. */
	public static String CRUD_SERVICE_REMOTE = "java:global.JOSM.DataServices.CrudService!hn.com.tigo.josm.common.interfaces.CrudServiceRemote";

	/** Attribute that determine MONITORING_MANAGER_REMOTE. */
	public static String MONITORING_MANAGER_REMOTE = "java:global.MonitoringManagerEAR.MonitoringManager.MonitoringManagerExternal!hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote";
	
	/** Attribute that determine GATEWAY_REMOTE. */
	public static String GATEWAY_REMOTE = "java:global.JOSM.Gateway.Gateway!hn.com.tigo.josm.common.interfaces.GatewayRemote";

	/** The profile remote. */
	public static String PROFILE_REMOTE = "java:global.JOSM.Profile.SubscriptionService!hn.com.tigo.josm.common.interfaces.Profile";

	/** The subscriber profile remote. */
	public static String SUBSCRIBER_PROFILE_REMOTE = "java:global.MasterStatus.MasterStatusBusiness.SubscriberProfileService!hn.com.tigo.josm.common.masterstatus.SubscriberProfileRemote";
	
	/** Attribute that determine CRUD_SERVICE_ASYNC_LOCAL. */
	public static String CRUD_SERVICE_ASYNC_LOCAL = "java:global.JOSM.DataServices.CrudServiceLogger!hn.com.tigo.josm.common.interfaces.CrudServiceAsyncLocal";
	
	/** Attribute that determine CRUD_SERVICE_LOCAL. */
	public static String CRUD_SERVICE_LOCAL = "java:global/JOSM/DataServices/CrudService!hn.com.tigo.josm.common.interfaces.CrudServiceLocal";
	
	/** The kannel adapter remote. */
	public static String KANNEL_ADAPTER_REMOTE = "KannelSendSMSTask#hn.com.tigo.josm.common.adapter.task.Task";
	
	/** Attribute that determine PLUGIN_CONFIGURATION_REMOTE. */
	public static String CACHE_MANAGER_REMOTE = "java:global.Common-ConfigurationEAR.Common-Configuration.CacheManager!hn.com.tigo.josm.common.interfaces.CacheManagerRemote";
	
	/** Attribute that determine AS400_ADAPTER_PERSISTENCE_REMOTE. */
	public static String AS400_ADAPTER_PERSISTENCE_REMOTE = "java:global/AS400AdapterEAR/Persistence/ServiceSession!hn.com.tigo.josm.persistence.core.ServiceSession";
	
	/** The A s400_ adapte r_ ge t_ subscribe r_ inf o_ task. */
	public static String AS400_ADAPTER_GET_SUBSCRIBER_INFO_TASK = "java:global.AS400AdapterEAR.AS400Adapter.AS400GetSubscriberBasicInfoTask!hn.com.tigo.josm.common.adapter.task.Task";

	/** The PlatformMapping adapter remote. */
	public static String PLATFORM_MAPPING_ADAPTER_REMOTE = "PlatformMappingGetAttributesTask#hn.com.tigo.josm.common.adapter.task.Task";

	


	/**
	 * Gets the plugin configuration.
	 * 
	 * @return the plugin configuration
	 */
	@Produces
	public ConfigurationJosmRemote getCommonConfiguration() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.COMMON_CONFIGURATION_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the plugin configuration.
	 * 
	 * @return the plugin configuration
	 */
	@Produces
	public PluginConfigurationRemote getPluginConfiguration() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.PLUGIN_CONFIGURATION_REMOTE);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Gets the profile monitoring remote.
	 * 
	 * @return the profile monitoring remote
	 */
	@Produces
	public ProfileMonitoringRemote getProfileMonitoringRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.PROFILE_MONITORING_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the plugin configuration monitoring remote.
	 * 
	 * @return the plugin configuration monitoring remote
	 */
	@Produces
	public PluginConfigurationMonitoringRemote getPluginConfigurationMonitoringRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.PLUGIN_CONFIGURATION_MONITORING_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the crud service remote.
	 * 
	 * @return the crud service remote
	 */
	@Produces
	public CrudServiceRemote getCrudServiceRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.CRUD_SERVICE_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the monitoring manager remote.
	 * 
	 * @return the monitoring manager remote
	 */
	@Produces
	public MonitoringManagerRemote getMonitoringManagerRemote() {

		try {
			LOGGER.info(InterfaceFactory.MONITORING_MANAGER_REMOTE);
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.MONITORING_MANAGER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	
	/**
	 * Gets the crud service async local.
	 *
	 * @return the crud service async local
	 */
	@Produces
	public CrudServiceAsyncLocal getCrudServiceAsyncLocal() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.CRUD_SERVICE_ASYNC_LOCAL);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	

	/**
	 * Gets the crud service local.
	 *
	 * @return the crud service local
	 */
	@Produces
	public CrudServiceLocal getCrudServiceLocal() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.CRUD_SERVICE_LOCAL);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	

	/**
	 * Gets the kannel adapter.
	 *
	 * @return the kannel adapter
	 */
	@Produces
	public Task getKannelAdapter() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.KANNEL_ADAPTER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	
	/**
	 * Gets the as400 gest subscriber info task.
	 *
	 * @return the as400 gest subscriber info task
	 */
	@Produces
	public Task getAs400GestSubscriberInfoTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.AS400_ADAPTER_GET_SUBSCRIBER_INFO_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	/**
	 * Gets the cache manager remote.
	 *
	 * @return the cache manager remote
	 */
	@Produces
	public CrudServiceLocal getCacheManagerRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.CACHE_MANAGER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	/**
	 * Gets the platform mapping adapter.
	 *
	 * @return the platform mapping adapter
	 */
	@Produces
	public Task getPlatformMappingAdapter() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.PLATFORM_MAPPING_ADAPTER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	
	/**
	 * Gets the gateway remote.
	 *
	 * @return the gateway remote
	 */
	@Produces
	public GatewayRemote getGatewayRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.GATEWAY_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	
	

}
