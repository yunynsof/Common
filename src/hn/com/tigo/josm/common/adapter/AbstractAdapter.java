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
import hn.com.tigo.josm.common.interfaces.MonitoringManagerLocal;
import hn.com.tigo.josm.common.jmx.event.ConnectionRefusedEvent;
import hn.com.tigo.josm.common.jmx.event.ConnectionRefusedEventType;
import hn.com.tigo.josm.common.jmx.event.CreateDriverEvent;
import hn.com.tigo.josm.common.jmx.event.UseDriverEvent;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.io.Closeable;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
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
public abstract class AbstractAdapter <S> implements AbstractAdapterMXBean{
	
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

	/** Stores the collection of active drivers in a map. */
	private LinkedList<DriverReference<S>> _driversPoolFreeList;
	
	/** Attribute that determine the _bdo adapter config field. */
	protected AdapterConfigType _adapterConfig;
	
	
	/** This attribute contains an instance of log4j logger for  AbstractAdapter.  */
	private final transient Logger LOGGER = Logger.getLogger(this.getClass());
	
	/** Attribute that determine platformMBeanServer. */
	private MBeanServer _platformMBeanServer;
	
	/** Attribute that determine base name for jmx beans. */
	private final String _jmxConfigBase = "hn.com.tigo.josm.orchestrator.adapter:type=%s";
	
	/** Attribute that determine base name for monitoring beans. */
	private final String _jmxMetricsBase = "hn.tigo.com.josm.{0}:type={1}";
	
	/** Attribute that determine the _bdo adapter config field. */
	private ConfigurationType _configurationType;

	/**
	 * Attribute that determine the last time configuration date was loaded.
	 */
	private Date _configDate;
	
	/** Attribute that determine the _configuration josm field. */
	private ConfigurationJosmRemote _configurationJosm;
	
	/** Attribute that determine _monitoringManager. */
	@EJB
	private MonitoringManagerLocal _monitoringManager;
	
	/** The _adapter name. */
	private String _adapterName;
	
	/** The _adapter simple name. */
	private String _adapterSimpleName;
	
	
	/** The _restart pool. */
	private boolean _restartPool = false;
	
	/** The _driver pool lock. */
	private Lock _driverPoolLock;
	
	/** The _driver version. */
	private long _driverVersion;
	
	/** The _jmx object. */
	private ObjectName _jmxObject;

	/**
	 * Instantiates a new abstract adapter.
	 */
	public AbstractAdapter(){
		_username = "";
		_password = "";

		_adapterName = parseName(this.getClass().getCanonicalName());
		_adapterSimpleName = parseName(this.getClass().getSimpleName());
		_driversPoolFreeList = new LinkedList<DriverReference<S>>();
		_driverPoolLock =  new ReentrantLock();
		_restartPool = true;
		
		try {
			final String name = String.format(_jmxConfigBase, _adapterSimpleName);
			_jmxObject = new ObjectName(name);
		} catch (MalformedObjectNameException e) {
			LOGGER.warn("The JMX ObjectName not has been created: ", e);
		}
		
	}
	
	/**
	 * Parses the name.
	 *
	 * @param name the name
	 * @return the string
	 */
	private String parseName(String name){
		
		final int index = name.indexOf("_");
		if(index != -1){
			name = name.substring(0, index);
		}
		return name;
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
	protected void loadConfiguration(final String requestConfig) throws NamingException, JAXBException, IOException {

		_configDate = new Date();
		if (_configurationJosm == null) {
			try {
				ServiceLocator serviceLocator = ServiceLocator.getInstance();
				_configurationJosm = serviceLocator.getService(AdapterConstants.CONFIGURATION_JDNI);
			} catch (ServiceLocatorException e) {
				LOGGER.error("Error getting jndi service: " + e.getMessage());
			}
		}
		final ResponseJOSM response = _configurationJosm.getConfiguration(requestConfig);

		_configurationType = response.getConfigurations();
	}
	
	/**
	 * Method responsible to load properties configuration.
	 */
	protected void loadProperties(){
		try {
			loadConfiguration(_adapterName);
			setProperties(_configurationType);
		} catch (NamingException | JAXBException | IOException e) {
			LOGGER.error("Constant parameters will be loaded due to the error: " + e.getMessage(), e);
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
		
		if(_restartPool){
			initDriverPool();
		}
		return _configurationType;
	}
	
	

	/**
	 * Inits the driver pool.
	 */
	private void initDriverPool() {

		_driverPoolLock.lock();
			if (_restartPool) {
				
				closeDrivers();
				
				_driversPoolFreeList.clear();
				_driverVersion = System.currentTimeMillis();
			
				for (int i = 0; i < _driverPoolSize; i++) {
					_driversPoolFreeList.add(new DriverReference<S>(this, _driverVersion));
				}
			}
			_restartPool = false;
			_driverPoolLock.unlock();
			registerDriverEvent();
			registerUseDrivers();
			
		
	}
	
	
	
	/**
	 * Close drivers.
	 */
	public void closeDrivers() {

		try {
			for (DriverReference<S> ref : _driversPoolFreeList) {
				if (ref.getDriver() instanceof Closeable) {
					((Closeable) ref.getDriver()).close();
				}
			}
		} catch (AdapterException | IOException e) {
			LOGGER.error("Closing Drivers Failed: " + e.getMessage(), e);

		}
	}
	
	
	/**
	 * Method that generalizes the driver retrieval logic.
	 *
	 * @return Returns an adapter's driver
	 * @throws AdapterException the adapter exception
	 */
	public DriverReference<S> getDriver() throws AdapterException {
		
		
		DriverReference<S> sessionObject =  null;
		_driverPoolLock.lock();
		try{
			if(!_driversPoolFreeList.isEmpty()){
				sessionObject = _driversPoolFreeList.pop();
			}else{
				registerConnectionRefused(ConnectionRefusedEventType.DRIVER);
				throw new AdapterException(AdapterErrorCode.MAX_SESSION_ERROR.getError(),  "No available drivers on "+_adapterSimpleName);
			}
			
		} finally{
			_driverPoolLock.unlock();
			registerUseDrivers();
		}
		
	
		
		return sessionObject;
	}
	
	
	/**
	 * Tells the adapter this driver is free now.
	 *
	 * @param driverObject the driver object
	 */
	public void freeDriver(final DriverReference<S> driverObject) {
		
		_driverPoolLock.lock();
		try {
			final long freeVersion = driverObject.getVersion();
			if(_driverVersion == freeVersion){
				_driversPoolFreeList.push(driverObject);
			}else{
				LOGGER.warn("Reset driver pool event detected, discarding driver "+_adapterSimpleName);
			}
		} finally {
			_driverPoolLock.unlock();
			registerUseDrivers();
		}

		

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
	public int getPoolDriversFreeListSize(){
		return _driversPoolFreeList.size();
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
	
	
	
		
	 /**
     * Register in jmx. 
     * This method register a bean in the jmx server.
     */
	@PostConstruct
	public void registerInJMX() {
		
		try {
			_platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
			
			if(_platformMBeanServer.isRegistered(_jmxObject)){
				_platformMBeanServer.unregisterMBean(_jmxObject);
			}
			_platformMBeanServer.registerMBean(this, _jmxObject);
			
			getProperties();
			
		} catch (InstanceAlreadyExistsException	| MBeanRegistrationException | NotCompliantMBeanException | InstanceNotFoundException e) {
			LOGGER.error("Problem during registration of "+_adapterName+" into JMX:", e);
			throw new IllegalStateException("Problem during registration of "+_adapterSimpleName+" into JMX:" + e, e);
		}
		

	}

       
    
    /**
     * Unregister from jmx server.
     */
    @PreDestroy
    public void unregisterFromJMX() {
		try {
			final Set<ObjectName> objectNames = _platformMBeanServer.queryNames(_jmxObject, null);
			
			for(ObjectName obname : objectNames){
				if(obname == _jmxObject){
					_platformMBeanServer.unregisterMBean(_jmxObject);
					
					final String name = MessageFormat.format(_jmxMetricsBase, _adapterSimpleName, _adapterSimpleName);
					final ObjectName jmxMetricsObjet = new ObjectName(name);
					
					_platformMBeanServer.unregisterMBean(jmxMetricsObjet);
				}
			}

		} catch (MBeanRegistrationException | InstanceNotFoundException | MalformedObjectNameException e) {
			throw new IllegalStateException("Problem during unregistration of "	+ _adapterSimpleName + " into JMX:" + e, e);
		}

	}
    
    /**
     * Gets the adapter name.
     *
     * @return the adapter name
     */
    public String getAdapterName(){
    	return _adapterName;
    }
    
    /**
     * Gets the adapter simple name.
     *
     * @return the adapter simple name
     */
    public String getAdapterSimpleName(){
    	return _adapterSimpleName;
    }
    
    
    /* (non-Javadoc)
     * @see hn.com.tigo.josm.common.adapter.AbstractAdapterMXBean#resetConfiguration()
     */
    @Override
    public void resetConfiguration(){
    	_restartPool = true;
    	_configExpiration = null;
    	
    }
    
    
    /**
     * Method responsible to register total drivers on JMX event monitor.
     */
    public void registerDriverEvent(){
    	
		final CreateDriverEvent event = new CreateDriverEvent();
		event.setComponent(_adapterSimpleName);
		event.setObjectName(_adapterSimpleName);
		event.setTotalDriver(_driverPoolSize);
		_monitoringManager.receiveEvent(event);
	}
	
    
	/**
	 * Method responsible to register use drivers in JMX monitoring.
	 */
    public void registerUseDrivers(){
		final UseDriverEvent event = new UseDriverEvent();
		event.setComponent(_adapterSimpleName);
		event.setObjectName(_adapterSimpleName);
		event.setIdlesDrivers(getPoolDriversFreeListSize());
		_monitoringManager.receiveEvent(event);
	}
	
	
	
	/**
	 * Register connection refused.
	 *
	 * @param type the type
	 */
	public void registerConnectionRefused(final ConnectionRefusedEventType type){
		final ConnectionRefusedEvent event = new ConnectionRefusedEvent(type);
		event.setComponent(_adapterSimpleName);
		event.setObjectName(_adapterSimpleName);
		_monitoringManager.receiveEvent(event);
	}
	
}
