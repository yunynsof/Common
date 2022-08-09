package hn.com.tigo.josm.common.interfaces;

/**
 * Interface used by the rule engine session factory.
 * @author Saul Villasenor
 * @version 1.0
 * @since10/19/2016 2:08:29 PM
 */
public interface RuleCacheManagerMXBean {

	/**
	 * Reset the values in the cache.
	 */
	void resetCache();
	
	/**
	 * Removes a KSession from the map to re-compile the rule from database.
	 */
	void resetKSessionCache(final String ksession);
}
