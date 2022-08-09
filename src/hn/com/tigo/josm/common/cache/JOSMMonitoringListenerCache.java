package hn.com.tigo.josm.common.cache;

import hn.com.tigo.josm.common.data.JsonLoader;
import hn.com.tigo.josm.common.dto.ConfigurationListener;
import hn.com.tigo.josm.common.exceptions.ConfigurationException;

import java.util.Hashtable;
import java.util.Map;

import javax.json.JsonObject;

/**
 * ListenerCache.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since Oct 17, 2016 5:46:49 PM
 */
public final class JOSMMonitoringListenerCache {

	private static JOSMMonitoringListenerCache listenerCache = new JOSMMonitoringListenerCache();

	private final JsonLoader jsonLoader;

	private JsonObject config;
	
	private Map<String, ConfigurationListener> configurationMap;

	/**
	 * Instantiates a new listener cache.
	 * 
	 * @throws ConfigurationException
	 */
	private JOSMMonitoringListenerCache() {
		jsonLoader = new JsonLoader(84000000, "./properties/monitoring/listener.json");
		configurationMap = new Hashtable<>();
	}

	/**
	 * Gets the single instance of ListenerCache.
	 *
	 * @return single instance of ListenerCache
	 */
	public static JOSMMonitoringListenerCache getInstance() {
		return listenerCache;
	}

	public ConfigurationListener getConfiguration(final String objectName) throws ConfigurationException {

		config = jsonLoader.retrieve().getJsonObject("config");

		if (config.containsKey(objectName) && !configurationMap.containsKey(objectName)) {
			final JsonObject jsonConfig = config.getJsonObject(objectName);
			final ConfigurationListener configuration = new ConfigurationListener(
					jsonConfig.getJsonNumber("threshold").longValue(), 
					jsonConfig.getJsonNumber("deltaTimeMillis").intValue(), 
					jsonConfig.getJsonNumber("productId").longValue(), 
					jsonConfig.getJsonString("orderType").getString());
			configurationMap.put(objectName, configuration);
		}

		return configurationMap.get(objectName);
	}
	
	public void reset() {
		jsonLoader.reset();
		configurationMap = new Hashtable<String, ConfigurationListener>();
	}
	
	public void destroy(){
		listenerCache = null;
	}
	
}
