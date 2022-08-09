/**
 * SystemParameterBeanRemote.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import java.util.Map;

import javax.ejb.Remote;

/**
 * 
 * SystemParameterBeanRemote.
 * Interface for SystemParameterBean for remote access.
 *
 * @author Harold Castillo <mailto:hjobando@stefanini.com />
 * @version 
 * @see 
 * @since 27/10/2014 10:50:47 AM 2014
 */
@Remote
public interface SystemParameterBeanRemote {

	/**
	 * Method that allows to obtain the parameters of the system stored in the
	 * database.
	 *
	 * @return the a map of system parameters
	 */
	Map<String, String> getSystemParameters();

}
