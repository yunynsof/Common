package hn.com.tigo.josm.common.util;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;

import java.util.HashMap;
import java.util.Map;

/**
 * TaskRequestMapper.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 08-11-2015 08:36:16 AM 2015
 */
public class TaskRequestMapper {
	
	/** Attribute that determine a Constant of RESPONSE_OK. */
	private static final String RESPONSE_OK = "Operation successful.";
	
	/**
	 * Request to map.
	 *
	 * @param taskType the task type
	 * @return the map
	 */
	public static Map<String, String> requestToMap(final TaskRequestType taskType){
		final Map<String, String> map = new HashMap<String, String>();
		
		if(taskType.isSetParameters()){
			final ParameterArray parameterArray = taskType.getParameters();
			for(ParameterType parameter : parameterArray.getParameter()){
				map.put(parameter.getName(), parameter.getValue());
			}
		}
		
		return map;
	}
	
	
	/**
	 * Method responsible to creates a parameter object.
	 *
	 * @param name the name
	 * @param value the valueco
	 * @return the parameter type
	 */
	public static ParameterType createParameter(final String name, final Object value){
		final ParameterType param = new ParameterType();
		param.setName(name);
		param.setValue((value!= null) ? value.toString() : "");
		return param;
	}
	
	/**
	 *  Creates the response is an utilitary method to build TaskResponseType.
	 *
	 * @param parameterArray the parameter array
	 * @return the task response type
	 */
	public static TaskResponseType createResponse(final ParameterArray parameterArray) {
		final TaskResponseType response = new TaskResponseType();
		response.setResponseCode(0);
		response.setResponseDescription(RESPONSE_OK);
		response.setParameters(parameterArray);
		
		return response;
	}

}
