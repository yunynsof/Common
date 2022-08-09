/**
 * ProfileMonitoringRemote.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.jmx;

import javax.ejb.Remote;

/**
 * ProfileMonitoringRemote.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 13/02/2015 16:22:34
 */
@Remote
public interface ProfileConfigurationMonitoringRemote {
	
	/**
	 * Method to remove all cached schemas.
	 */
	void resetProfile();

}
