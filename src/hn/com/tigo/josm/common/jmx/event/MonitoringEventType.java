package hn.com.tigo.josm.common.jmx.event;

/**
 * MonitoringEventType. 
 * Event type to registering in JMX
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 8/07/2015 03:34:14 PM 2015
 */
public enum MonitoringEventType {
	
	/** Attribute that determine PERFORMANCE. */
	PERFORMANCE,
	
	/** Attribute that determine CREATE_DRIVER. */
	CREATE_DRIVER,
	
	/** Attribute that determine USE_DRIVER. */
	USE_DRIVER,
	
	/** Attribute that determine RELEASE_DRIVER. */
	RELEASE_DRIVER,
	
	/** Attribute that determine CONNECTION_REFUSED_DRIVER. */
	CONNECTION_REFUSED_DRIVER,
	
	ENDPOINT;
	
}
