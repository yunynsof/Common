/**
 * AdpaterMonitorInterface.java
 * Orchestrator
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.adapter;

/**
 * The Interface AdpaterMonitorInterface.
 *
 * @author Jimmy Muchachasoy <mailto:jamuchavisoy@stefanini.com />
 * @version
 * @see
 * @since 10-oct-2014 10:43:56 2014
 */

public interface AdapterMonitorMXBean {

	/**
	 * Checks if the monitor is started on JMX service and return a Boolean response .
	 *
	 * @return true, if is started
	 */
	boolean isStarted();
	
	/**
	 * Start monitoring on Engine for MBean Server to JMX service.
	 */
	void init();

	/**
	 * Stop monitoring on Engine for MBean Server to JMX service.
	 */
	void stop();

	/**
	 * Shutdown the Engine Mbean instance for JMX service.
	 */
	void shutdown();

	/**
	 * Start the Engine Mbean instance for JMX service.
	 */
	void start();
	
	/**
	 * Reset monitoring variables for JMX service.
	 */
	void reset();

	/**
	 * Gets the adapter tps (transactions per second) instance.
	 *
	 * @return the adapter tps
	 */
	long getAdapterTPS();

	/**
	 * Gets the last transaction time millis, represented by the difference between the last transaction and the actual time.
	 *
	 * @return the last transaction time millis
	 */
	long getLastTransactionTimeMillis();
	
	
	/**
	 * Gets the active total drivers count in an specific time.
	 *
	 * @return the active drivers
	 */
	long getTotalDrivers();
	
	/**
	 * Gets the idle drivers count in an specific time.
	 *
	 * @return the idle drivers
	 */
	long getIdleDrivers();
	
	/**
	 * Gets the total transactions.
	 *
	 * @return the total transactions
	 */
	long getTotalTransactions();
	
	/**
	 * Gets the failed transactions.
	 *
	 * @return the failed transactions
	 */
	long getFailedTransactions();
	
}
