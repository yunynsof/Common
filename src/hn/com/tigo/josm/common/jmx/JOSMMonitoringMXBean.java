/**
 * JOSMMonitoringMXBean.java
 * Common
 * Copyright (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.jmx;


/**
 * JOSMMonitoringMXBean. Interface for monitoring bean's.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @see
 * @since 24/02/2015 02:45:23 PM 2015
 */
public interface JOSMMonitoringMXBean {

	/**
	 * Gets the inbound messages.
	 *
	 * @return the inbound messages
	 */
	long getInboundMessages();

	/**
	 * Gets the failed messages.
	 *
	 * @return the failed messages
	 */
	long getFailedMessages();

	/**
	 * Gets the sucess messages.
	 *
	 * @return the sucess messages
	 */
	long getSucessMessages();

	/**
	 * Increment inbound messages.
	 */
	void incrementInboundMessages();

	/**
	 * Increment failed messages.
	 */
	void incrementFailedMessages();

	/**
	 * Gets the last transaction time millis.
	 *
	 * @return the last transaction time millis
	 */
	long getLastTransactionTimeMillis();

	/**
	 * Sets the last transaction time millis.
	 *
	 * @param lastTransactionTimeMillis
	 *            the new last transaction time millis
	 */
	void setLastTransactionTimeMillis(long lastTransactionTimeMillis);

	/**
	 * Gets the tps.
	 *
	 * @return the tps
	 */
	long getTPS();

	/**
	 * Calculate tps.
	 */
	void calculateTPS();
	
	/**
	 * Reset monitoring variables for JMX service.
	 */
	void reset();
	
	
	


}
