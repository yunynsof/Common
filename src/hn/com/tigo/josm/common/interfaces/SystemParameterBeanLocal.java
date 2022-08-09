package hn.com.tigo.josm.common.interfaces;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface SystemParameterBeanLocal {

	/**
	 * Method that allows to obtain the parameters of the system stored in the
	 * database.
	 *
	 * @return the a map of system parameters
	 */
	Map<String, String> getSystemParameters();

}
