package hn.com.tigo.josm.common.jmx.event;

import hn.com.tigo.josm.common.dto.JOSMEvent;

import java.io.Serializable;

/**
 * UseDriverEvent.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 8/05/2015 06:03:20 PM 2015
 */
/**
 * @author Administrador
 *
 */
public class UseDriverEvent extends JOSMEvent implements Serializable  {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 8560965433804507528L;
	
	/** Attribute that determine _idlesDrivers. */
	private long _idlesDrivers;
	
	/**
	 * Instantiates a new use driver event.
	 */
	public UseDriverEvent(){
		super(MonitoringEventType.USE_DRIVER, MXBeanType.DRIVER);
	}
	
	/**
	 * Gets the idles drivers.
	 *
	 * @return the idles drivers
	 */
	public long getIdlesDrivers() {
		return _idlesDrivers;
	}

	/**
	 * Sets the idles drivers.
	 *
	 * @param idlesDrivers the new idles drivers
	 */
	public void setIdlesDrivers(final long idlesDrivers){
		this._idlesDrivers = idlesDrivers;
	}
	
}
