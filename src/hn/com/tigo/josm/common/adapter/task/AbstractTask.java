/**
 * AbstractTask.java
 * LTE-EJB
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.adapter.task;

import hn.com.tigo.josm.common.adapter.AbstractAdapter;
import hn.com.tigo.josm.common.adapter.AdapterConstants;
import hn.com.tigo.josm.common.adapter.AdapterValidationType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.configuration.dto.AdapterConfigType;
import hn.com.tigo.josm.common.configuration.dto.TaskMockDelayType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.common.interfaces.Closeable;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote;
import hn.com.tigo.josm.common.jmx.event.CreateDriverEvent;
import hn.com.tigo.josm.common.jmx.event.PerformanceEvent;
import hn.com.tigo.josm.common.jmx.event.UseDriverEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;

/**
 * AbstractTask. General class for all adapter tasks
 *
 * @author Camilo Gutierrez <mailto:cgutierrez@stefanini.com />
 * @version
 * @param <T>
 *            Generic type that represents the drivers method request type.
 * @param <D>
 *            Gewneric type that represents the driver's instance.
 * @see
 * @since 06-oct-2014 15:30:40 2014
 */
public abstract class AbstractTask<T, D> {

	/** Attribute that determine log. */
	private final transient Logger LOGGER = Logger.getLogger(this.getClass());
	
	/** Attribute that determine _monitoringManager. */
	@Inject
	private MonitoringManagerRemote _monitoringManager;
	

	/** The WebService context useful to retrieve the client IP. */
	@Resource
	protected WebServiceContext _wsContext;

	/** Attribute that determine the instance driver. */
	protected D _driver;

	/** Attribute that determine the instance type request. */
	protected T _request;
	
	/** The _current exception. */
	protected AdapterException _currentException;

	/** The _flag remove driver. */
	protected Boolean _flagRemoveDriver;
	
	/** Attribute that determine className. */
	private String _adapterName;


	/**
	 * Instantiates a new abstract task.
	 */
	public AbstractTask() {

	}


	/**
	 * Method responsible for obtaining singleton instance that manages the
	 * adapter.
	 * 
	 * @return the singleton adapter
	 */
	protected abstract AbstractAdapter<D> getSingletonAdapter();

	/**
	 * Execute task.
	 *
	 * @param taskType            the task type
	 * @param singletonAdapter            the singleton adapter
	 * @return the task response type
	 * @throws AdapterException             the adapter exception
	 */
	@WebMethod
	public TaskResponseType executeTask(final TaskRequestType taskType)
			throws AdapterException {
		boolean result = true;
		final AbstractAdapter<D> singletonAdapter = getSingletonAdapter();
		final ExecutorService executor = Executors.newSingleThreadExecutor();
		final long initTransaction = System.currentTimeMillis();
		TaskResponseType response = null;
		Future<TaskResponseType> future = null;
		
		_adapterName = singletonAdapter.getClass().getSimpleName();
		
		final PerformanceEvent event = new PerformanceEvent();
		event.setComponent(_adapterName);
		event.setObjectName(_adapterName);
		
		singletonAdapter.getProperties();
		final String msg = validateThroughput(taskType, singletonAdapter);
		LOGGER.info(msg);
		_request = createRequest(taskType);
		_driver = singletonAdapter.getDriver();
		_flagRemoveDriver = Boolean.FALSE;
		try {
			 
			registerDriverEvent(singletonAdapter.getDriversPoolSize());
			registerUseDrivers(singletonAdapter.getPoolDriversFreeListSize());
			
			final TaskExecutor<T, D> taskExecutor = new TaskExecutor<T, D>(this);
			future = executor.submit(taskExecutor);
			executor.shutdown();
			LOGGER.info("Request timeout set: "+singletonAdapter.getRequestTimeout());
			final long timeOut = singletonAdapter.getRequestTimeout();
			if (!executor.awaitTermination(timeOut, TimeUnit.MILLISECONDS)) {
				result = false;
				future.cancel(Boolean.TRUE);
				LOGGER.error("Request timeout executing driver task ".concat(_adapterName) );
				throw new AdapterException(AdapterErrorCode.TIMEOUT_CONNECTION_ERROR.getError(),
						AdapterErrorCode.TIMEOUT_CONNECTION_ERROR.getMessage());
			}
			
			response = future.get();
			if(response == null && _currentException != null){
				result = false;
				LOGGER.error("executeDriverTask Error retrieved: "+_currentException.getMessage());
				throw _currentException;
			}
			LOGGER.info("End Task: " + this.toString());

		} catch (InterruptedException | ExecutionException e) {
			result = false;
			LOGGER.error("Thread execution exception "+ e.getMessage());
			throw new AdapterException(AdapterErrorCode.INTERNAL_EXECUTOR_ERROR, e.getMessage(), e);
		} finally {
			if (!_flagRemoveDriver) {
				LOGGER.info("Driver added to Free Pool");
				singletonAdapter.freeDriver(_driver);
			} else {
				LOGGER.error("Driver Not added to Free Pool due a failure");
				singletonAdapter.removeDriverPool(_driver);
			}
			event.setResult(result, System.currentTimeMillis() - initTransaction);
			_monitoringManager.receiveEvent(event);
			executor.shutdownNow();
		}
		LOGGER.info(response.getResponseDescription());
		return response;
	}

	/**
	 * Responsible method of executing a specific task through the driver
	 * instance.
	 *
	 * @return the task response type
	 * @throws AdapterException             the adapter exception
	 */
	protected abstract TaskResponseType executeDriverTask() throws AdapterException;

	/**
	 * Method responsible for creating the request for the execution of the task
	 * as its input parameters.
	 * 
	 * @param taskType
	 *            the task type
	 * @return the s
	 * @throws AdapterException
	 *             the adapter exception
	 */
	protected abstract T createRequest(TaskRequestType taskType) throws AdapterException;


	/**
	 * Method responsible to get the client IP from context.
	 *
	 * @param wsContext
	 *            the ws context
	 * @return the client ip
	 */
	protected String getClientIp() {
		String clientIp = "Unknown ip address";

		try {
			if (_wsContext != null) {
				final MessageContext mc = _wsContext.getMessageContext();
				final HttpServletRequest req = (HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST);
				clientIp = req.getRemoteAddr();
			}
		} catch (IllegalStateException e) {
			LOGGER.info("Could not retrieve requester IP: " + e.getMessage());
		}

		return clientIp;
	}

	/**
	 * Method responsible to call and validate throughput.
	 *
	 * @param taskType
	 *            the task type
	 * @param singleton
	 *            the singleton
	 * @return the string
	 * @throws AdapterException
	 *             the adapter exception
	 */
	protected String validateThroughput(final TaskRequestType taskType, final AbstractAdapter<D> singleton)
			throws AdapterException {
		String initLogMsg = "Init Task %s TransactionId: %s Client IP: %s";
		initLogMsg = String.format(initLogMsg, this.getClass().getSimpleName(), taskType.getTransactionId(),
				getClientIp());
		final long tps = _monitoringManager.getTPS(_adapterName, _adapterName);
		if (tps >= singleton.getMaxThroughput()) {
			LOGGER.error(AdapterErrorCode.MAX_THROUGHPUT_ERROR.getMessage().concat("  ").concat(_adapterName));
			throw new AdapterException(AdapterErrorCode.MAX_THROUGHPUT_ERROR,
					AdapterErrorCode.MAX_THROUGHPUT_ERROR.getMessage());
		}
		return initLogMsg;
	}

	/**
	 * Prints a TaskRequestType parameter value.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	protected void printParameterValue(final String key, final String value) {
		final String paramsLogBase = "Parameter <%s, %s>";
		String paramsListMsg = paramsLogBase;
		paramsListMsg = String.format(paramsLogBase, key, value);
		LOGGER.info(paramsListMsg);
	}

	/**
	 * Method responsible to validate parameters name and value.
	 *
	 * @param <A>
	 *            the generic type
	 * @param paramName
	 *            the param name
	 * @param paramValue
	 *            the param value
	 * @param validationType
	 *            the validation type
	 * @param required
	 *            the required
	 * @throws AdapterException
	 *             the adapter exception
	 */
	protected <A extends AbstractAdapter<?>> void validateParameter(final String paramName,
			final String paramValue, final AdapterValidationType validationType, final boolean required)
			throws AdapterException {

		if (required && paramValue == null) {
			LOGGER.error(String.format(AdapterConstants.MSG_MISSING_PARAMETER, paramName));
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, String.format(
					AdapterConstants.MSG_MISSING_PARAMETER, paramName));
		}

		if (required && paramValue.isEmpty()) {
			LOGGER.error(String.format(AdapterConstants.MSG_INVALID_PARAMETER, paramName));
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, String.format(
					AdapterConstants.MSG_INVALID_PARAMETER, paramName));
		}

		if (paramValue != null && !paramValue.matches(validationType.getValidationExpression())) {
			LOGGER.error(String.format(AdapterConstants.MSG_INVALID_PARAMETER, paramName));
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, String.format(
					AdapterConstants.MSG_INVALID_PARAMETER, paramName));
		}
	}

	/**
	 * Method responsible to validate parameter length.
	 *
	 * @param paramName the param name
	 * @param paramValue the param value
	 * @param paramSize the param size
	 * @throws AdapterException the adapter exception
	 */
	protected void validateParameterLength(final String paramName, final String paramValue,
			final int paramSize) throws AdapterException {
		if (paramValue.length() > paramSize) {
			final String msg = String.format(AdapterConstants.MSG_INVALID_PARAMETER_LENGTH, paramSize,
					paramName);
			LOGGER.error(msg);
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, msg);
		}
	}
	
	/**
	 * Method responsible to validate parameter length.
	 *
	 * @param paramName            the param name
	 * @param paramValue            the param value
	 * @param paramSizeBegin the param size begin
	 * @param paramSizeEnd the param size end
	 * @throws AdapterException             the adapter exception
	 */
	protected void validateParameterLengthBetween(final String paramName, final String paramValue, final int paramSizeBegin,
			final int paramSizeEnd) throws AdapterException {
		if (paramValue.length() > paramSizeEnd || paramValue.length() < paramSizeBegin) {
			final String msg = String
					.format(AdapterConstants.MSG_INVALID_PARAMETER_LENGTH_BETWEEN, paramSizeBegin, paramSizeEnd, paramName);
			LOGGER.error(msg);
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, msg);
		}
	}
	
	/**
	 * Validate date time value.
	 *
	 * @param paramName the param name
	 * @param date the date
	 * @param pattern the pattern
	 * @return the date
	 * @throws AdapterException the adapter exception
	 */
	protected Date validateDateTimeValue(final String paramName, final String date, final String pattern) throws AdapterException {
		
		if(date == null){
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, String.format(
					AdapterConstants.MSG_MISSING_PARAMETER, paramName));
		}
		
		final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		final Date dateTime;
		sdf.setLenient(false);
		try {
			dateTime = sdf.parse(date);
		} catch (ParseException e) {
			final String msg = String.format(AdapterConstants.MSG_INVALID_PARAMETER, paramName);
			LOGGER.error(msg, e);
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, msg);
		}
		
		return dateTime;
	}
	
	/**
	 * Validate xml date time.
	 *
	 * @param paramName the param name
	 * @param date the date
	 * @param pattern the pattern
	 * @return the XML gregorian calendar
	 * @throws AdapterException the adapter exception
	 */
	protected XMLGregorianCalendar validateXMLDateTime(final String paramName, final String date, final String pattern) throws AdapterException {
		final Date dateTime = validateDateTimeValue(paramName, date, pattern);
		final GregorianCalendar  dateGC = new GregorianCalendar();
		dateGC.setTime(dateTime);
		try {
			final XMLGregorianCalendar dateXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateGC);
			return dateXml;

		} catch (DatatypeConfigurationException e) {
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, String.format(
					AdapterConstants.MSG_INVALID_PARAMETER, paramName));
		}
		
	}
	
	/**
	 * Compare dates.
	 *
	 * @param endDateParam the end date param
	 * @param endDate the end date
	 * @param pattern the pattern
	 * @return the XML gregorian calendar
	 * @throws AdapterException the adapter exception
	 */
	protected XMLGregorianCalendar compareDates(final String endDateParam,final String endDate, final String pattern) throws AdapterException {
		printParameterValue(endDate, endDateParam);
		validateParameter(endDate, endDateParam, AdapterValidationType.ALFANUMERIC_EXTENDED, true);

		if (!endDateParam.matches(pattern)) {
			final String error = String.format(AdapterConstants.MSG_INVALID_PARAMETER, endDate);
			LOGGER.error(error);
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, error);

		}


		final XMLGregorianCalendar endDateXml = validateXMLDateTime(endDate, endDateParam, AdapterConstants.XML_DATE_PATTERN);
		

		final Calendar startDateXml = GregorianCalendar.getInstance();
		final int result = startDateXml.compareTo(endDateXml.toGregorianCalendar());

		if (result > 0) {
			final String errorDate = String.format(AdapterConstants.MSG_INVALID_PARAMETER_COMPARE_DATE, "ACTUAL DATE",
					endDate);
			LOGGER.error(errorDate);
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, errorDate);
		}
		return endDateXml;
	}

	
	
	/**
	 * Find by task name.
	 *
	 * @param taskName the task name
	 * @return the task mock delay type
	 */
	protected TaskMockDelayType findByTaskName(final String taskName){
		final AdapterConfigType config = getSingletonAdapter().getAdapterConfig();
		if(config != null){
			for(TaskMockDelayType d : config.getTaskMockDelayList().getTaskList()){
				if(d.getTaskName().equals(taskName)) {
					return d;
				}
			}
		}
		return null;
	}

	/**
	 * Method responsible to validate parameter type.
	 * 
	 * @param paramName
	 *            the param name
	 * @param paramValue
	 *            the param value
	 * @param type
	 *            the type
	 * @throws AdapterException
	 *             the adapter exception
	 */
	protected void validateParameterType(final String paramName, final String paramValue, final String type)
			throws AdapterException {
		if (!paramValue.matches(type)) {
			final String message = String.format(AdapterConstants.MSG_INVALID_PARAMETER, paramName);
			LOGGER.error(message);
			throw new AdapterException(AdapterErrorCode.PARAMETERS_ERROR, message);
		}
	}
	
	/**
	 * Method responsible to register total drivers on JMX event monitor.
	 *
	 * @param driversPoolSize the drivers pool size
	 */
	private void registerDriverEvent(final int driversPoolSize){
		final CreateDriverEvent event = new CreateDriverEvent();
		event.setComponent(_adapterName);
		event.setObjectName(_adapterName);
		event.setTotalDriver(driversPoolSize);
		_monitoringManager.receiveEvent(event);
	}
	
	
	/**
	 * Method responsible to register use drivers in JMX monitoring.
	 *
	 * @param idlesDrivers the idles drivers
	 */
	private void registerUseDrivers(final long idlesDrivers){
		final UseDriverEvent event = new UseDriverEvent();
		event.setComponent(_adapterName);
		event.setObjectName(_adapterName);
		event.setIdlesDrivers(idlesDrivers);
		_monitoringManager.receiveEvent(event);
	}
	
}