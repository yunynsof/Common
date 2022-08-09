/**
 * InterfaceFactory.java
 * Common
 * Copyright (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.interfaces.producer;

import hn.com.tigo.josm.common.adapter.task.Task;
import hn.com.tigo.josm.common.interfaces.BrokerRemote;
import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;
import hn.com.tigo.josm.common.interfaces.CrudServiceAsyncLocal;
import hn.com.tigo.josm.common.interfaces.CrudServiceLocal;
import hn.com.tigo.josm.common.interfaces.CrudServicePlatformMappingRemote;
import hn.com.tigo.josm.common.interfaces.CrudServiceRemote;
import hn.com.tigo.josm.common.interfaces.GatewayRemote;
import hn.com.tigo.josm.common.interfaces.IPromotion;
import hn.com.tigo.josm.common.interfaces.IScheduler;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerLocal;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote;
import hn.com.tigo.josm.common.interfaces.PluginConfigurationRemote;
import hn.com.tigo.josm.common.interfaces.RuleEngineRemote;
import hn.com.tigo.josm.common.interfaces.SubscriptionRemote;
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

	/** The crud service platform mapping remote. */
	public static String CRUD_SERVICE_PLATFORM_MAPPING_REMOTE = "CrudServicePlatformMapping#hn.com.tigo.josm.common.interfaces.CrudServicePlatformMappingRemote";

	/** Attribute that determine MONITORING_MANAGER_REMOTE. */
	public static String MONITORING_MANAGER_REMOTE = "java:global.MonitoringManagerEAR.MonitoringManager.MonitoringManagerExternal!hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote";

	public static String MONITORING_MANAGER_LOCAL = "java:global.MonitoringManagerEAR.MonitoringManager.MonitoringManagerExternal!hn.com.tigo.josm.common.interfaces.MonitoringManagerLocal";

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

	/** Attribute that determine ADAPTER_MOCK_PERSISTENCE_REMOTE. */
	public static String ADAPTER_MOCK_PERSISTENCE_REMOTE = "java:global.AdapterMockEAR.Persistence.ServiceSession!hn.com.tigo.josm.persistence.core.ServiceSession";

	/** The A s400_ adapte r_ ge t_ subscribe r_ inf o_ task. */
	public static String AS400_ADAPTER_GET_SUBSCRIBER_INFO_TASK = "java:global.AS400AdapterEAR.AS400Adapter.AS400GetSubscriberBasicInfoTask!hn.com.tigo.josm.common.adapter.task.Task";

	/** The PlatformMapping adapter remote. */
	public static String PLATFORM_MAPPING_ADAPTER_REMOTE = "PlatformMappingGetAttributesTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The Constant CCWS_ADAPTER_REMOTE. */
	public static String CCWS_RETRIEVE_SUBSCRIBER_TASK_ADAPTER_REMOTE = "CcwsRetrieveSubscriberWithIdendityNoHistoryTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** Attribute that determine SUBSCRIBER_ACL_ADAPTER_PERSISTENCE_REMOTE. */
	public static String SUBSCRIBER_ACL_ADAPTER_PERSISTENCE_REMOTE = "java:global/SubscriberACLAdapterEAR/Persistence/ServiceSession!hn.com.tigo.josm.persistence.core.ServiceSession";

	/** Attribute that determine RULE_ENGINE_REMOTE. */
	public static String RULE_ENGINE_REMOTE = "java:global/RuleEngineEAR/RuleEngine/RuleEngineImp!hn.com.tigo.josm.common.interfaces.RuleEngineRemote";

	/** Attribute that determine SUBSCRIPTION_REMOTE. */
	public static String SUBSCRIPTION_REMOTE = "java:global/SubscriptionEAR/Subscription/SubscriptionImpl!hn.com.tigo.josm.common.interfaces.SubscriptionRemote";

	/** The spr query task. */
	public static String SPR_QUERY_TASK = "SprQueryTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The master status get subscriber profile. */
	public static String MASTER_STATUS_GET_SUBSCRIBER_PROFILE_TASK = "MasterStatusGetSubscriberProfileTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The cbs subscriber info by identity task. */
	public static String CBS_SUBSCRIBER_INFO_BY_IDENTITY_TASK = "SubscriberInfoByIdentityTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The scheduler remote. */
	public static String SCHEDULER_REMOTE = "java:global/SchedulerEAR/Scheduler/Scheduler!hn.com.tigo.josm.common.interfaces.IScheduler";

	/** The promotion remote. */
	public static String PROMOTION_REMOTE = "java:global/PromotionEAR/Promotion/PromotionComponent!hn.com.tigo.josm.common.interfaces.IPromotion";

	/** The promotion engine remote. */
	public static String PROMOTION_ENGINE_REMOTE = "java:global/PromotionEngineEAR/PromotionEngine/PromotionEngineComponent!hn.com.tigo.josm.promotion.engine.services.impl.IPromotionEngine";

	/** The schedule task. */
	public static String SCHEDULE_TASK = "ScheduleTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The FEEDEDUCTION task. */
	public static String FEEDEDUCTION_TASK = "FeeDeductionTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The GETTOTALDEBT task. */
	public static String GETTOTALDEBT_TASK = "ZeroBalancePlatformGetTotalDebtTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The GETALLSCORING task. */
	public static String GETALLSCORING_TASK = "ZeroBalancePlatformGetAllScoringTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The CHECKDEFAULT task. */
	public static String CHECKDEFAULT_TASK = "ZeroBalancePlatformCheckDefaultTask#hn.com.tigo.josm.common.adapter.task.Task";

	/** The spr adapter persistence remote. */
	public static String SPR_ADAPTER_PERSISTENCE_REMOTE = "java:global/SPRAdapter-EAR/Persistence/ServiceSession!hn.com.tigo.josm.persistence.core.ServiceSession";

	/** The rule engine jndi. */
	public static String RULE_ENGINE_JNDI = "java:global.RuleEngineAdapterEAR.RuleEngineAdapter.RuleEngineTask!hn.com.tigo.josm.common.adapter.task.Task";

	/** The NOTIFY ADAPTER jndi. */
	public static String NOTIFY_ADAPTER_JNDI = "java:global.NotifyAdapterEAR.NotifyAdapter.NotifyTriggerTask!hn.com.tigo.josm.common.adapter.task.Task";

	/** Attribute that determine the {@link BrokerRemote} reference JNDI . */
	public static String BROKER_REMOTE_JNDI = "java:global.JOSM.Broker.Broker!hn.com.tigo.josm.common.interfaces.BrokerRemote";
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(InterfaceFactory.class);
	
	/**
	 * Gets the broker remote instance.
	 *
	 * @return the broker remote
	 */
	@Produces
	public BrokerRemote getBrokerRemote() {

		BrokerRemote brokerRemote = null;

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			brokerRemote = serviceLocator.getService(InterfaceFactory.BROKER_REMOTE_JNDI);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}

		return brokerRemote;
	}

	/**
	 * Gets the plugin configuration.
	 * 
	 * @return the plugin configuration
	 */
	@Produces
	public ConfigurationJosmRemote getCommonConfiguration() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.COMMON_CONFIGURATION_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.PLUGIN_CONFIGURATION_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.PROFILE_MONITORING_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.PLUGIN_CONFIGURATION_MONITORING_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.CRUD_SERVICE_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the crud service platform mapping remote.
	 * 
	 * @return the crud service platform mapping remote
	 */
	@Produces
	public CrudServicePlatformMappingRemote getCrudServicePlatformMappingRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.CRUD_SERVICE_PLATFORM_MAPPING_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.MONITORING_MANAGER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	@Produces
	public MonitoringManagerLocal getMonitoringManagerLocal() {

		try {
			LOGGER.info(InterfaceFactory.MONITORING_MANAGER_LOCAL);
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.MONITORING_MANAGER_LOCAL);
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
			return serviceLocator
					.getService(InterfaceFactory.CRUD_SERVICE_ASYNC_LOCAL);
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
			return serviceLocator
					.getService(InterfaceFactory.CRUD_SERVICE_LOCAL);
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
			return serviceLocator
					.getService(InterfaceFactory.KANNEL_ADAPTER_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.AS400_ADAPTER_GET_SUBSCRIBER_INFO_TASK);
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
			return serviceLocator
					.getService(InterfaceFactory.CACHE_MANAGER_REMOTE);
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
			return serviceLocator
					.getService(InterfaceFactory.PLATFORM_MAPPING_ADAPTER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the ccws retrieve subscriber with idendity no history task.
	 * 
	 * @return the ccws retrieve subscriber with idendity no history task
	 */
	@Produces
	public Task getCcwsRetrieveSubscriberWithIdendityNoHistoryTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.CCWS_RETRIEVE_SUBSCRIBER_TASK_ADAPTER_REMOTE);
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

	/**
	 * Gets the rule engine.
	 * 
	 * @return the rule engine
	 */
	@Produces
	public RuleEngineRemote getRuleEngine() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.RULE_ENGINE_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the subscription remote.
	 * 
	 * @return the subscription remote
	 */
	@Produces
	public SubscriptionRemote getSubscriptionRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.SUBSCRIPTION_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the spr query task.
	 * 
	 * @return the spr query task
	 */
	@Produces
	public Task getMasterStatusGetSubscriberProfileTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.MASTER_STATUS_GET_SUBSCRIBER_PROFILE_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the spr query task.
	 * 
	 * @return the spr query task
	 */
	@Produces
	public Task getSprQueryTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.SPR_QUERY_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the schedule task.
	 * 
	 * @return the schedule task
	 */
	@Produces
	public Task getScheduleTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.SCHEDULE_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the FeeDeduction task.
	 * 
	 * @return the FeeDeduction task
	 */
	@Produces
	public Task getFeeDeductionTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.FEEDEDUCTION_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the ZeroBalancePlatformGetTotalDebtTask.
	 * 
	 * @return the ZeroBalancePlatformGetTotalDebtTask
	 */
	@Produces
	public Task getZeroBalancePlatformGetTotalDebtTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.GETTOTALDEBT_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;
	}

	/**
	 * Gets the ZeroBalancePlatformGetAllScoringTask.
	 * 
	 * @return the ZeroBalancePlatformGetAllScoringTask
	 */
	@Produces
	public Task getZeroBalancePlatformGetAllScoringTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.GETALLSCORING_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;
	}

	/**
	 * Gets the ZeroBalancePlatformCheckDefaultTask.
	 * 
	 * @return the ZeroBalancePlatformCheckDefaultTask
	 */
	@Produces
	public Task getZeroBalancePlatformCheckDefaultTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator
					.getService(InterfaceFactory.CHECKDEFAULT_TASK);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;
	}

	/**
	 * Gets the scheduler remote.
	 * 
	 * @return the scheduler remote
	 */
	@Produces
	public IScheduler getSchedulerRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			return serviceLocator.getService(InterfaceFactory.SCHEDULER_REMOTE);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the promotion remote.
	 * 
	 * @return the promotion remote
	 */
	@Produces
	public IPromotion getPromotionRemote() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			IPromotion promotion = serviceLocator
					.getService(InterfaceFactory.PROMOTION_REMOTE);
			return promotion;
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

	/**
	 * Gets the rule engine task.
	 * 
	 * @return the rule engine task
	 */
	public Task getRuleEngineTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			Task ruleEngine = serviceLocator
					.getService(InterfaceFactory.RULE_ENGINE_JNDI);
			return ruleEngine;
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}
	
	/**
	 * Gets the rule engine task.
	 * 
	 * @return the rule engine task
	 */
	public Task getNotifyAdapterTask() {

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			Task notifyAdapter = serviceLocator
					.getService(InterfaceFactory.NOTIFY_ADAPTER_JNDI);
			return notifyAdapter;
		} catch (ServiceLocatorException e) {
			LOGGER.error(e);
		}
		return null;

	}

}
