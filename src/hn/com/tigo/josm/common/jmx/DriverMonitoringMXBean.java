package hn.com.tigo.josm.common.jmx;

/**
 * DriverMonitoringMXBean. Interface for monitoring drivers bean's.
 * 
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @see
 * @since 8/05/2015 05:13:08 PM 2015
 */
public interface DriverMonitoringMXBean extends JOSMMonitoringMXBean {

	/**
	 * Gets the total drivers.
	 * 
	 * @return the total drivers
	 */
	long getTotalDrivers();

	/**
	 * Gets the idle drivers.
	 * 
	 * @return the idle drivers
	 */
	long getIdleDrivers();

	void setTotalDrivers(final long total);

	void setIdleDrivers(final long idles);
	
	void setLastEndpointTimeMillis(final long lastEndpoint);

	/**
	 * Increment inbound messages.
	 */
	void incrementInsuficientDrivers();

	long getInsuficientDrivers();

	void incrementConnectionRefused();

	long getConnectionRefused();

	long getMaxUsedDrivers();

	long getLastEndpointTimeMillis();

}
