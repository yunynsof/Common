package hn.com.tigo.josm.common.util;

import hn.com.tigo.josm.common.adapter.dto.ParameterType;

/**
 * TaskAdapterUtils.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0
 * @since 12/05/2015 04:18:39 PM 2015
 */
public class TaskAdapterUtils {
	
	/**
	 * Creates the parameter type.
	 *
	 * @param name the name
	 * @param value the value
	 * @return the parameter type
	 */
	public static ParameterType createParameterType(final String name, final String value){
		final ParameterType param = new ParameterType();
		param.setName(name);
		param.setValue(value);
		return param;
	}
}
