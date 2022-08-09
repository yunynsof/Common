package hn.com.tigo.josm.common.driver;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;

/**
 * AbstractDriver.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @param <P> the generic type
 * @since 14/09/2015 04:42:24 PM 2015
 */
public abstract class AbstractDriver {

	/** The Constant LOGGER. */
	private static final transient Logger LOGGER = Logger.getLogger(AbstractDriver.class);
	
	/** The Constant REQUEST_TIMEOUT. */
	public static final String REQUEST_TIMEOUT = "com.sun.xml.ws.request.timeout";
												  
	
	/** The Constant CONNECT_TIMEOUT. */
	public static final String CONNECT_TIMEOUT = "com.sun.xml.ws.connect.timeout";
	
	/** The Constant CONNECTION. */
	public static final String CONNECTION = "Connection";
	
	/** The Constant TIME_OUT_DRIVER_DIFERENCE. */
	private static final int TIME_OUT_DRIVER_DIFERENCE = 300;
	
	/** The Constant TIME_OUT_DRIVER_DEFAULT. */
	private static final int TIME_OUT_DRIVER_DEFAULT = 10;

	/** The _request time out. */
	protected static int _requestTimeOut;
	
	/** The _conect time out. */
	protected static int _conectTimeOut;
	
	/** The _endpoint. */
	protected static String _endpoint;
	
	/**
	 * Attribute that determine the Id generated to identify every driver.
	 */
	private String _id;
	
	/** Attribute that determine the _username field. */
	public String _username;
	
	/** Attribute that determine the _password field. */
	public String _password;
	
	/**
	 * Instantiates a new abstract driver.
	 */
	public AbstractDriver(){
		_id = generateId();
	}
	
	/**
	 * Method responsible to generate sequence from date now.
	 * 
	 * @return Format String date now in "yyyyMMddhhmmssSSS" format.
	 */
	private String generateId(){
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		return sdf.format(new Date());
	}

	
	/**
	 * Method responsible to gets the _port.
	 *
	 * @return the _port
	 */
	public  void createPort( final BindingProvider binding , final Boolean isCloseConection ) {		
		
		final Map<String, Object> ctx = binding.getRequestContext();
		int requestTimeOut  =  _requestTimeOut - TIME_OUT_DRIVER_DIFERENCE ;
		int connectTimeOut  = _conectTimeOut - TIME_OUT_DRIVER_DIFERENCE ;
		
		requestTimeOut = requestTimeOut <= 0 ? TIME_OUT_DRIVER_DEFAULT :  requestTimeOut;
		connectTimeOut = connectTimeOut <= 0 ? TIME_OUT_DRIVER_DEFAULT :  connectTimeOut;
		
		ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, _endpoint);
		ctx.put(REQUEST_TIMEOUT, requestTimeOut);
		ctx.put(CONNECT_TIMEOUT, connectTimeOut);
		
		if(isCloseConection){
			final Map<String, List<String>> headerMap = new HashMap<String, List<String>>();
			headerMap.put(CONNECTION, Collections.singletonList("close"));
			ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headerMap);
		}
		LOGGER.info("Port generated successful");
		
	}
	
	/**
	 * Sets the request time out.
	 *
	 * @param requestTimeOut the new request time out
	 */
	public static void setRequestTimeOut(final int requestTimeOut) {
		_requestTimeOut = requestTimeOut;
	}

	/**
	 * Sets the conect time out.
	 *
	 * @param conectTimeOut the new conect time out
	 */
	public static void setConectTimeOut(final int conectTimeOut) {
		_conectTimeOut = conectTimeOut;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return _id;
	}
	

	/**
	 * Gets the endpoint.
	 *
	 * @return the endpoint
	 */
	public static String getEndpoint() {
		return _endpoint;
	}

	/**
	 * Sets the endpoint.
	 *
	 * @param endpoint the new endpoint
	 */
	public static void setEndpoint(final String endpoint) {
		_endpoint = endpoint;
	}

	/**
	 * Method responsible to gets the _username.
	 *
	 * @return the _username
	 */
	public String getUsername() {
		return _username;
	}

	/**
	 * Method responsible to gets the _password.
	 *
	 * @return the _password
	 */
	public String getPassword() {
		return _password;
	}
	
}
