package hn.com.tigo.josm.common.interfaces;

import java.util.List;

/**
 * The ServiceLocatorCacheMXBean interface exposes the methods that will be used in JMX.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0.0
 * @since 24/08/2016 03:54:41 PM
 */
public interface ServiceLocatorCacheMXBean extends Resetable{

	/**
	 * Method responsible to gets the JNDI cache.
	 *
	 * @return the JNDI cache
	 */
	List<String> viewJNDICache();
	
	/**
	 * Reset cache by jndi name.
	 *
	 * @return the string
	 */
	String resetCacheByJNDIName(final String jndiName);
	
	
}
