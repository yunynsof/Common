package hn.com.tigo.josm.common.jmx.event;

import hn.com.tigo.josm.common.dto.JOSMEvent;

import java.io.Serializable;

/**
 * ConnectionRefusedEvent.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 8/09/2015 04:38:31 PM 2015
 */
public class ConnectionRefusedEvent extends JOSMEvent implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1960143654007685065L;
	
	
	
	/** The _error type. */
	final ConnectionRefusedEventType _errorType;

	/**
	 * Instantiates a new connection refused event.
	 *
	 * @param errorType the error type
	 */
	public ConnectionRefusedEvent(final ConnectionRefusedEventType errorType){
		super(MonitoringEventType.CONNECTION_REFUSED_DRIVER, MXBeanType.DRIVER);
		_errorType = errorType;
		
	}
	
	
	/**
	 * Gets the error type.
	 *
	 * @return the error type
	 */
	public ConnectionRefusedEventType getErrorType(){
		return _errorType;
	}
	

}
