package hn.com.tigo.josm.common.adapter;

import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.configuration.dto.AdapterConfigType;
import hn.com.tigo.josm.common.configuration.dto.ConfigurationType;
import hn.com.tigo.josm.common.configuration.dto.ResponseJOSM;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

/**
 * The AbstractAdapter represents the basic common behavior for all adapters.
 *
 * @author Camilo Gutierrez <mailto:cgutierrez@stefanini.com />
 * @version 
 * @param <S> the generic type
 * @see 
 * @since 07/10/2014 17:53:31 2014
 */
public abstract class AbstractAdapter <S> implements Adapter{
	
	/** This attribute contains an instance of log4j logger for  AbstractAdapter.  */
	private final transient Logger LOGGER = Logger.getLogger(this.getClass());
	
	/** Attribute that determine the configuration cache timeout. */
	protected Long _configExpiration;

	/**
	 * Attribute that defines pool size. 
	 */
	protected int _driverPoolSize;
	
	/**
	 * Attribute that defines the maximum throughput for an adapter.
	 */
	protected int _maxThroughput;
	
	/** Attribute that determine the endpoint, this adapter will connect. */
	protected String _endpoint;
	
	/** Attribute that determine the _username field. */
	protected String _username;
	
	/** Attribute that determine the _password field. */
	protected String _password;
	
	/**
	 * Attribute that defines the maximum throughput for an adapter.
	 */
	protected long _connectTimeout;
	
	/**
	 * Attribute that defines the maximum throughput for an adapter.
	 */
	protected long _requestTimeout;

	/** Stores the collection synchronized of active drivers in a map. */
	protected Map<String, S> _driversPoolMap = new Hashtable<String, S>();

	/** Stores the collection of active drivers in a map. */
	protected List<S> _driversPoolFreeList = Collections.synchronizedList(new ArrayList<S>());
	
	/** Attribute that determine the _bdo adapter config field. */
	private ConfigurationType _configurationType;
	
	/** Attribute that determine the _bdo adapter config field. */
	protected AdapterConfigType _adapterConfig;
	
	/**
	 * Attribute that determine the last time configuration date was loaded.
	 */
	private Date _configDate;
	
	/** Attribute that determine the _configuration josm field. */
	private ConfigurationJosmRemote _configurationJosm;
	
	/**
	 * Instantiates a new abstract adapter.
	 */
	protected AbstractAdapter(){
		_username = "";
		_password = "";
		loadProperties();
		initDriver();
	}
	
	/**
	 * Method responsible to set the adapter configuration properties loaded
	 * from XML file.
	 * 
	 * @param adapterConfig
	 *            the new adapter properties
	 */
	public abstract void setAdapterProperties(final AdapterConfigType adapterConfig);
	
	/**
	 * Method responsible to set the adapter configuration properties loaded
	 * from constants file.
	 */
	public abstract void setConstantProperties();
	
	/**
	 * Method responsible to set the adapter configuration general properties loaded
	 * from XML file.
	 *
	 * @param config the new properties
	 */
	public synchronized void setProperties(final ConfigurationType config) {
		_adapterConfig = config.getAdapterConfig().getValue();
		_configExpiration = config.getConfigExpiration();
		_maxThroughput = _adapterConfig.getMaxThroughput();
		_driverPoolSize = _adapterConfig.getDriverPoolSize();
		_endpoint = _adapterConfig.getDriverConfig().getEndPoint();
		_username = _adapterConfig.getDriverConfig().getUser();
		_password = _adapterConfig.getDriverConfig().getPassword();
		_requestTimeout = _adapterConfig.getDriverConfig().getRequestTimeOut();
		_connectTimeout = _adapterConfig.getDriverConfig().getConectTimeOut();

		final StringBuilder message = new StringBuilder();
		message.append(this.getClass().getName());
		message.append(" basic properties loaded: \n");
		message.append("MaxThrougput: " + _maxThroughput
				+ AdapterConstants.NEW_LINE);
		message.append("Config expiration: " + _configExpiration
				+ AdapterConstants.NEW_LINE);
		message.append("DriverPoolSize: " + _driverPoolSize);
		
		LOGGER.info(message.toString());
		
		setAdapterProperties(_adapterConfig);

	}
	
	/**
	 * Method in charge of get the configuration properties from
	 * ConfigurationJosm.
	 *
	 * @param requestConfig the request config
	 * @throws NamingException the naming exception
	 * @throws JAXBException the JAXB exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void loadConfiguration(final String requestConfig)
			throws NamingException, JAXBException, IOException {
		
		_configDate = new Date();
		if(_configurationJosm==null){
			final Context context = new InitialContext();
			_configurationJosm = (ConfigurationJosmRemote) context.lookup(AdapterConstants.CONFIGURATION_JDNI);
		}
		final ResponseJOSM response = _configurationJosm.getConfiguration(requestConfig);
		
		_configurationType = response.getConfigurations();
	}
	
	/**
	 * Method responsible to load properties configuration.
	 */
	protected void loadProperties(){
		try {
			loadConfiguration(this.getClass().getCanonicalName());
			setProperties(_configurationType);
		} catch (NamingException | JAXBException | IOException e) {
			LOGGER.error("Constant parameters will be loaded due to the error: " + e.getMessage());
		}
	}
	
	/**
	 * Gets the configuration properties. Checks if configuration cache has
	 * expired to reload it otherwise retrieves the cached one.
	 *
	 * @return the properties object is an AdapterConfig instance that contains
	 *         parameters like configTimeOut or maxThroghput.
	 */
	public ConfigurationType getProperties(){
		if ((_configExpiration == null) || ((new Date().getTime() - _configDate.getTime()) >= _configExpiration)) {
			loadProperties();
		}
		return _configurationType;
	}

	/**
	 * Method that shuts down monitoring threads execution.
	 */
	public abstract void shutdown();

	/**
	 * Method that generalizes the driver retrieval logic.
	 *
	 * @return Returns an adapter's driver
	 * @throws AdapterException the adapter exception
	 */
	public S getDriver() throws AdapterException {
		S sessionObject = null;
		if (!_driversPoolFreeList.isEmpty()) {
			sessionObject = _driversPoolFreeList.get(0);
			_driversPoolFreeList.remove(sessionObject);
			LOGGER.info("Assign existing session");
		} else if (_driversPoolMap.size() >= _driverPoolSize) {
			throw new AdapterException(AdapterErrorCode.MAX_SESSION_ERROR.getError(), "No available drivers");
		} else {
			sessionObject = createDriver();
			_driversPoolMap.put(String.valueOf(sessionObject.hashCode()), sessionObject);
			LOGGER.info("It has created new " + sessionObject.getClass().getSimpleName());
		}

		return sessionObject;
	}
	
	/**
	 * Creates a new adapter driver instance.
	 *
	 * @return the driver
	 * @throws AdapterException the adapter exception
	 */
	protected abstract S createDriver() throws AdapterException;

	
	/**
	 * Gets the pool drivers free list size.
	 *
	 * @return the pool drivers free list size
	 */
	@Override
	public int getPoolDriversFreeListSize(){
		return _driversPoolFreeList.size();
	}
	
	/**
	 * Gets the pool driver free list size.
	 *
	 * @return the pool driver free list size
	 */
	@Override
	public int getDriversPoolSize(){
		return _driversPoolMap.size();
	}
	
	/**
	 * Tells the adapter this driver is free now.
	 *
	 * @param driverObject the driver object
	 */
	public void freeDriver(final S driverObject){
		if(!_driversPoolFreeList.contains(driverObject)){
			_driversPoolFreeList.add(driverObject);
		}
	}
	
	/**
	 * Reserves a driver for exclusive use.
	 *
	 * @param driverObject the driver object
	 */
	public void reserveDriver(final S driverObject) {
		_driversPoolFreeList.remove(driverObject);
	}
	
	/**
	 * Removes the driver pool.
	 *
	 * @param driver the driver
	 */
	public void removeDriverPool(final S driver){
		_driversPoolMap.remove(String.valueOf(driver.hashCode()));
	}

	/**
	 * Checks if a driver is free.
	 *
	 * @param driverObject the driver object
	 * @return true, if is driver free
	 */
	public boolean isDriverFree(final S driverObject){
		return _driversPoolFreeList.contains(driverObject);
	}
	
	/**
	 * Gets a parameter value from a parameter name.
	 * 
	 * @param parameterName
	 *            The name of a  parameter
	 * @param taskReq
	 *            The type of task
	 * @return the value from the parameter
	 * @throws AdapterException
	 *             the adapter exception
	 */
	public static String getParameterValue(final String parameterName,
			final TaskRequestType taskReq) throws AdapterException {
		String ret = null;
		for (ParameterType param : taskReq.getParameters().getParameter()) {
			if (param.getName().equals(parameterName)) {
				ret = param.getValue();
				break;
			}
		}
		return ret;
	}
	
	
	/**
	 * Gets the parameter value.
	 *
	 * @param parameterName the parameter name
	 * @param taskRes the task res
	 * @return the parameter value
	 * @throws AdapterException the adapter exception
	 */
	public static String getParameterValue(final String parameterName,
			final TaskResponseType taskRes) throws AdapterException {
		String ret = null;
		for (ParameterType param : taskRes.getParameters().getParameter()) {
			if (param.getName().equals(parameterName)) {
				ret = param.getValue();
				break;
			}
		}
		return ret;
	}
	
	/**
	 * Gets the parameter value list from parameter name.
	 *
	 * @param parameterName the parameter name
	 * @param taskReq the task req
	 * @return the parameter value list
	 * @throws AdapterException the adapter exception
	 */
	public static List<String> getParameterValueList(final String parameterName,
			final TaskRequestType taskReq) throws AdapterException {
		final List<String> values = new ArrayList<String>();
		for (ParameterType param : taskReq.getParameters().getParameter()) {
			if (param.getName().equals(parameterName) && param.getValue() != null) {
				values.add(param.getValue());
			}
		}
		return values;
	}
	
	/**
	 * Method responsible to gets the parameters in a HashMap.
	 *
	 * @param parameterName the parameter name
	 * @param taskReq the task req
	 * @return the parameter map
	 * @throws AdapterException the adapter exception
	 */
	public static Map<String, String> getParameterMap(final String parameterName,
			final TaskRequestType taskReq) throws AdapterException {
		final Map<String, String> parametersMap = new HashMap<String, String>();
		for (ParameterType param : taskReq.getParameters().getParameter()) {
			if (param.getName().startsWith(parameterName) && param.getValue() != null) {
				parametersMap.put(param.getName(), param.getValue());
			}
		}
		return parametersMap;
	}

	/**
	 * Gets the parameter map.
	 *
	 * @param taskReq the task req
	 * @return the parameter map
	 */
	public static Map<String, String> getParameterMap(final TaskRequestType taskReq) {
		final Map<String, String> parametersMap = new HashMap<String, String>();
		for (ParameterType param : taskReq.getParameters().getParameter()) {
			parametersMap.put(param.getName(), param.getValue());
		}
		return parametersMap;
	}
	
	/**
	 * Method responsible to initialize the BDO drivers.
	 */
	protected void initDriver() {
		try {
			
			S sessionObject = createDriver(); 
			_driversPoolMap.put(String.valueOf(sessionObject.hashCode()), sessionObject);
			_driversPoolFreeList.add(sessionObject);
		} catch (AdapterException e) {
			LOGGER.error("Error in creating the BdoDriver instance");
		}
		
	}

	/**
	 * Method responsible to gets the config expiration.
	 *
	 * @return the _configExpiration
	 */
	public Long getConfigExpiration() {
		return _configExpiration;
	}

	/**
	 * Method responsible to gets the driver pool size.
	 *
	 * @return the _driverPoolSize
	 */
	public int getDriverPoolSize() {
		return _driverPoolSize;
	}

	/**
	 * Method responsible to gets the max throughput.
	 *
	 * @return the _maxThroughput
	 */
	public int getMaxThroughput() {
		return _maxThroughput;
	}

	/**
	 * Method responsible to gets the connect timeout.
	 *
	 * @return the _connectTimeout
	 */
	public long getConnectTimeout() {

		return _connectTimeout;
	}

	/**
	 * Method responsible to gets the request timeout.
	 *
	 * @return the _requestTimeout
	 */
	public long getRequestTimeout() {

		return _requestTimeout;
	}

	/**
	 * Method responsible to gets the adapter config.
	 *
	 * @return the _adapterConfig
	 */
	public AdapterConfigType getAdapterConfig() {
		return _adapterConfig;
	}

}
