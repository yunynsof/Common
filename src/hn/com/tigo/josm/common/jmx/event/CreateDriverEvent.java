package hn.com.tigo.josm.common.jmx.event;

import hn.com.tigo.josm.common.dto.JOSMEvent;

import java.io.Serializable;

/**
 * CreateDriverEvent.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 8/05/2015 06:01:50 PM 2015
 */
public class CreateDriverEvent extends JOSMEvent implements Serializable {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = -2486655466811100673L;
	
	
	/** Attribute that stores the _transactionInMillis. */
	private long _totalDriver;
	
	public CreateDriverEvent(){
		super(MonitoringEventType.CREATE_DRIVER);
	}


	/**
	 * Gets the total driver.
	 *
	 * @return the total driver
	 */
	public long getTotalDriver() {
		return _totalDriver;
	}


	/**
	 * Sets the total driver.
	 *
	 * @param totalDriver the new total driver
	 */
	public void setTotalDriver(long totalDriver) {
		this._totalDriver = totalDriver;
	}
	
}
