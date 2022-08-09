/**
 * ServiceTask.java
 * BPMNCompiler
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.broker.compiler.task;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.adapter.task.Task;
import hn.com.tigo.josm.common.broker.compiler.data.DataParameter;
import hn.com.tigo.josm.common.broker.compiler.data.ExpressionType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.BPMNExecutionException;
import hn.com.tigo.josm.common.exceptions.enumerators.EnumValidateResponse;
import hn.com.tigo.josm.common.exceptions.enumerators.OrchestratorErrorCode;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.log4j.Logger;

/**
 * ServiceTask.
 *
 * @author Alexis Berrio
 * @version 1.0
 * @since 20/01/2015 10:32:24 AM 2015
 */
public class ServiceTask extends AbstractElement {
	
	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** This attribute contains an instance of log4j logger for  Engine.  */
	private static final transient Logger LOGGER = Logger.getLogger(ServiceTask.class);

	/** The Constant TRANSACTION_ID. */
	private static final String TRANSACTION_ID = "transactionId";
	
	/** Attribute that determine the constant invalid parameter message. */
	private static final String MSG_ERROR_EVAL_EXPRESSION = "<%s> : Error getting from context <%s>  result  <%s>";
	
	/** Attribute that determine the Constant RESPONSE_DESCRIPTION. */
	private static final String RESPONSE_DESCRIPTION = "responseDescription";
	
	/** The Constant PARAMETER_ERROR. */
	private static final String PARAMETER_ERROR = "Parameter defined in input definition not found in context in ServiceTask: <%s>  on variable: <%s>  on Expression: <%s>";
	
	/** The Constant PARAMETER_EXPRESSION_NULL_ERROR. */
	private static final String PARAMETER_EXPRESSION_NULL_ERROR = "Expression is null for ServiceTask : <%s> on parameter : <%s> "; 

	/** The Constant PARAMETER_EXPRESSION_SERVICE_TASK. */
	private static final String PARAMETER_EXPRESSION_SERVICE_TASK = "Service Task ( %s ) failed: %s  platformError: %s"; 

	/** Attribute that determine the Constant RESPONSE_CODE. */
	private static final String RESPONSE_CODE = "responseCode";
	
	/** Attribute that determine the Constant RESPONSE_DESCRIPTION. */
	private static final String PLATFORM_ERROR_DESCRIPTION = "platformErrorDescription";

	/** Attribute that determine the Constant RESPONSE_CODE. */
	private static final String PLATFORM_ERROR_CODE = "platformErrorCode";
	
	/** Attribute that determine jndjndiName. */
	private String jndiName;

	/** Attribute that determine _inputData. */
	private Map<String, DataParameter> _inputData;

	/** Attribute that determine _outputData. */
	private Map<String, DataParameter> _outputData;

	/** The _implementation name. */
	private String _implementationName;
	/**
	 * Instantiates a new service task.
	 */
	private ServiceTask(){
		this.setType(TaskType.SERVICE);
	}
	
	/**
	 * Instantiates a new service task.
	 *
	 * @param jndiName            the jndi name
	 */
	public ServiceTask(final String jndiName) {
		this();
		this.jndiName = jndiName;
		_inputData = new HashMap<String, DataParameter>();
		_outputData = new HashMap<String, DataParameter>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hn.com.tigo.josm.broker.compiler.task.AbstractElement#execute(javax.script
	 * .ScriptEngine)
	 */
	/**
	 * Execute.
	 *
	 * @param engine the engine
	 * @return the list
	 * @throws BPMNExecutionException the bpmn exception
	 */
	@Override
	public LinkedList<AbstractElement> execute(final ScriptEngine engine) throws BPMNExecutionException {

		final ScriptContext context = engine.getContext();
		Task taskInterface = null;
		final TaskRequestType taskRequestType = createRequest(engine);
		TaskResponseType taskResponse  = new TaskResponseType();
		
		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			taskInterface = serviceLocator.getService(jndiName);
			taskResponse = taskInterface.executeTask(taskRequestType);
		} catch (AdapterException e) {
			final String platformError  = e.getPlatformError() != null ? e.getPlatformError() : "";
			saveResponse(context, PLATFORM_ERROR_CODE, PLATFORM_ERROR_DESCRIPTION, e.getPlatformError(),
					e.getMessage(),null);
			final String message = String.format(PARAMETER_EXPRESSION_SERVICE_TASK, _name,e.getMessage(),platformError);
			LOGGER.error(message);
			throw new BPMNExecutionException(e.getErrorCode(), e.getMessage(), e.getPlatformError(), e);
		} catch (ServiceLocatorException e) {
			final String message = "Service Task ( %s ) failed: %s";
			LOGGER.error(String.format(message, _name,e.getMessage()),e);
			throw new BPMNExecutionException(EnumValidateResponse.JNDI_NAME_NOT_FOUND.getCode(),
					e.getMessage(), e);
		}

		saveResponse(context, RESPONSE_CODE, RESPONSE_DESCRIPTION, taskResponse.getResponseCode(),
				taskResponse.getResponseDescription(),taskResponse);

		return null;
	}
	
	/**
	 * Creates the request.
	 *
	 * @param engine the engine
	 * @return the task request type
	 * @throws BPMNExecutionException the bpmn exception
	 */
	private TaskRequestType createRequest(final ScriptEngine engine) throws BPMNExecutionException{
		
		LOGGER.info("Printing context parameters for Service Task: "+_name);
		final ScriptContext context = engine.getContext();
		
		final Set<String> key = _inputData.keySet();
		DataParameter from;
		Object contextValue;
		String paramName;
		ParameterType pt;
		
		final ParameterArray parameterArray = new ParameterArray();
		for(String to: key){
			from = _inputData.get(to);
			final String expression = from.getExpression();
			
			if(expression == null){
				final String errorMessage = String.format(PARAMETER_EXPRESSION_NULL_ERROR, _name,to);
				LOGGER.error(errorMessage);
				throw new BPMNExecutionException(
						OrchestratorErrorCode.BPMN_ERROR.getError(),errorMessage);
			}
			
			if(from.getType().equals(ExpressionType.VARIABLE_NAME)){
				contextValue = context.getAttribute(expression).toString();
				paramName = expression;
			}else{
				try {
					contextValue = engine.eval(expression);
					paramName = to;
				}
				catch (ScriptException e) {
					final String errorMessage = String.format(MSG_ERROR_EVAL_EXPRESSION,_name, expression, e.getMessage());
					LOGGER.error(errorMessage);
					throw new BPMNExecutionException(
							OrchestratorErrorCode.BPMN_ERROR.getError(),errorMessage, e);
				}
			}

			if(contextValue == null){
				final String errorMessage = String.format(PARAMETER_ERROR, _name,to,expression); 
				LOGGER.error(errorMessage);
				throw new BPMNExecutionException(
						OrchestratorErrorCode.BPMN_ERROR.getError(),errorMessage);
			}
			
			pt = new ParameterType();
			pt.setName(to);
			pt.setValue(contextValue.toString());
			parameterArray.getParameter().add(pt);
			
		}
		
		final TaskRequestType req = new TaskRequestType();
		req.setTransactionId(context.getAttribute(TRANSACTION_ID).toString());
		req.setParameters(parameterArray);
		
		
		return req;
	}
	
	
	
	/**
	 * Save response.
	 *
	 * @param context the context
	 * @param responseCode the response code
	 * @param responseDescription the response description
	 * @param codeValue the code value
	 * @param descriptionValue the description value
	 * @param taskresponse the taskresponse
	 */
	private void saveResponse(final ScriptContext context, final String responseCode,
			final String responseDescription, final Object codeValue, final String descriptionValue,final TaskResponseType taskresponse) {

		final String varName = "%s__%s";
		final String resCode = String.format(varName, this._name, responseCode);
		context.setAttribute(resCode, codeValue, ScriptContext.ENGINE_SCOPE);
		final String resDesc = String.format(varName, this._name, responseDescription);
		context.setAttribute(resDesc, descriptionValue, ScriptContext.ENGINE_SCOPE);

		if(taskresponse != null){
			final ParameterArray parameterArray = taskresponse.getParameters();
			if (parameterArray != null) {

				final Map<String, String> response = createMap(parameterArray);
				final Set<String> keys = _outputData.keySet();
				for (String to : keys) {
					final DataParameter from = _outputData.get(to);
					final String contextValue = response.get(from.getExpression());
					if (contextValue != null) {
						context.setAttribute(to, contextValue, ScriptContext.ENGINE_SCOPE);
					}

				}

			}
		}

	}
	
	
	/**
	 * Utility Method that creates a map from parameter array.
	 *
	 * @param parameterArray the parameter array
	 * @return the map
	 */
	private Map<String, String> createMap(final ParameterArray parameterArray){
		
		final HashMap<String, String> map = new HashMap<String, String>();
		
		for(ParameterType param : parameterArray.getParameter()){
			map.put(param.getName(), param.getValue());
			LOGGER.info("Printing parameters ServiceTask name: " + param.getName() + " value: " + param.getValue());

		}
		
		return map;
		
		
	}



	/**
	 * Gets the jndi name.
	 *
	 * @return the jndi name
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * Sets the jndi name.
	 *
	 * @param jndiName
	 *            the new jndi name
	 */
	public void setJndiName(final String jndiName) {
		this.jndiName = jndiName;
	}

	/**
	 * Gets the _input data.
	 *
	 * @return the _input data
	 */
	public Map<String, DataParameter> getInputData() {
		return _inputData;
	}



	/**
	 * Gets the _output data.
	 *
	 * @return the _output data
	 */
	public Map<String, DataParameter> getOutputData() {
		return _outputData;
	}

	/**
	 * Gets the _implementation name.
	 * 
	 * @return the _implementation name
	 */
	public String getImplementationName() {
		return _implementationName;
	}

	/**
	 * Sets the _implementation name.
	 * 
	 * @param _implementationName
	 *            the new _implementation name
	 */
	public void setImplementationName(final String _implementationName) {
		this._implementationName = _implementationName;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		final Set<String> inputKey = _inputData.keySet();
		for(String param :inputKey){
			strBuilder.append("[ "+param+", "+ _inputData.get(param)+"]");
			strBuilder.append(", ");
			
		}
		strBuilder.append("##");
		final String input = strBuilder.toString().replaceFirst(", ##", "");
		strBuilder = new StringBuilder();
		 
		final Set<String> outputKey = _outputData.keySet();
		for(String param :outputKey){
			strBuilder.append("[ "+param+", "+ _outputData.get(param)+"]");
			strBuilder.append(", ");
		}
		strBuilder.append("##");
		final String output = strBuilder.toString().replaceFirst(", ##", "");
		return "ServiceTask [jndiName=" + jndiName + ", _inputData=<" + input + ">, _outputData=<"
				+ output + ">]";
	}
}
