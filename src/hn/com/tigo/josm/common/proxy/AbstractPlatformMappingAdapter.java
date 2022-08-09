package hn.com.tigo.josm.common.proxy;

import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.adapter.task.Task;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;
import hn.com.tigo.josm.common.util.ProxyUtil;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * AbstractPlatformMappingAdapter.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @param <S> the generic type
 * @since 06-04-2015 11:05:48 AM 2015
 */
public abstract class AbstractPlatformMappingAdapter<S> {

	
	/** Attribute which determine the Constant of the class log. */
	private static final Logger LOGGER = Logger.getLogger(AbstractPlatformMappingAdapter.class);

	/** The _proxy  request type. */
	protected S _proxyRequestType;

	/** The _task response type. */
	protected TaskResponseType _taskResponseType;

	/**
	 * Instantiates a new platform mapping adapter manager.
	 * 
	 * @param jndiPlatformMapping
	 *            the jndi product equivalence adapter
	 */
	public AbstractPlatformMappingAdapter(final String jndiPlatformMapping) {
	}

	/**
	 * Execute and populate request gateway parameter list with the values from
	 * attributes in the xml request and search the equivalent value for
	 * productId platform..
	 * 
	 * @param proxyRequestType
	 *            the proxy general request type is an object with Proxygeneral xml
	 *            resquest values.
	 * @return the response
	 * @throws AdapterException 
	 */
	public Response execute(final S proxyRequestType) throws AdapterException {

		Response currentResponse = ProxyUtil.createResponse(ProxyConstants.RESPONSE_CODE_ERROR,
				"Failed to get Platform Mapping Attributes");
		_proxyRequestType = proxyRequestType;
		try {
			final TaskRequestType taskRequestType = buildTaskRequestType();
			currentResponse = getPlatformMappingValues(taskRequestType);
		} catch (ServiceLocatorException e) {
			LOGGER.error(e.getMessage().toString(), e);
			throw new AdapterException(AdapterErrorCode.SERVICE_NOT_FOUND,e.getMessage());
		}

		return currentResponse;

	}
	
	
	/**
	 * Gets the product equivalence value contained in TaskResponse properties
	 * named PRODUCT_ID_PLATFORM, Inside this service receives two parameters,
	 * the first parameter is productId and second parameter is a platform key.
	 *
	 * @param taskRequestType the task request type
	 * @return the product equivalence value is the platform product id.
	 * @throws ServiceLocatorException 
	 * @throws AdapterException 
	 */
	private Response getPlatformMappingValues(final TaskRequestType taskRequestType) throws ServiceLocatorException, AdapterException {

		Response currentResponse = ProxyUtil.createResponse(ProxyConstants.RESPONSE_CODE_ERROR,
				"Failed to get mapping values");

		_taskResponseType = null;
		
		LOGGER.info("Init  getPlatformMappingValues");
		
		final ServiceLocator serviceLocator = ServiceLocator.getInstance();
		final Task productPlatformMapping = serviceLocator.getService(InterfaceFactory.PLATFORM_MAPPING_ADAPTER_REMOTE);
		
		if (productPlatformMapping != null) {
				final TaskResponseType taskResponseType = productPlatformMapping
						.executeTask(taskRequestType);
				if (ProxyConstants.RESPONSE_CODE_OK_ADAPTER.equals(String.valueOf(taskResponseType
						.getResponseCode()))) {
					_taskResponseType = taskResponseType;
					buildTaskResponseType();
					currentResponse = ProxyConstants.OK_RESPONSE;
				}
			
		}
		LOGGER.info("End  getPlatformMappingValues");

		return currentResponse;

	}
	
	/**
	 * Builds the task request type.
	 *
	 * @return the task request type
	 */
	protected abstract TaskRequestType buildTaskRequestType();
	
	
	/**
	 * Builds the task response type.
	 *
	 * @return the task request type
	 */
	protected abstract TaskResponseType buildTaskResponseType();
	
	

	/**
	 * Gets the _proxy request type.
	 *
	 * @return the _proxy request type
	 */
	public S getProxyRequestType() {
		return _proxyRequestType;
	}

	
	/**
	 * Sets the proxy request type.
	 *
	 * @param proxyRequestType the new proxy request type
	 */
	public void setProxyRequestType(final S proxyRequestType) {
		this._proxyRequestType = proxyRequestType;
	}

	/**
	 * Gets the _task response type.
	 *
	 * @return the _task response type
	 */
	public TaskResponseType getTaskResponseType() {
		return _taskResponseType;
	}

	
	/**
	 * Sets the task response type.
	 *
	 * @param taskResponseType the new task response type
	 */
	public void setTaskResponseType(final TaskResponseType taskResponseType) {
		this._taskResponseType = taskResponseType;
	}
	
	/**
	 * Gets the parameter value according to specific parameter request.
	 * 
	 * @param parameterName
	 *            the parameter name
	 * @param taskReq
	 *            the task req
	 * @return the parameter value
	 */
	protected static synchronized String getParameterValue(final String parameterName,
			final TaskResponseType taskReq) {
		String ret = null;
		for (ParameterType param : taskReq.getParameters().getParameter()) {
			if (param.getName().equals(parameterName)) {
				ret = param.getValue();
				break;
			}
		}
		return ret;
	}

	
	
}
