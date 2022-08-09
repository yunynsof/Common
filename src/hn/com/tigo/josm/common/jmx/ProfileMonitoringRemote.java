/**
 * ProfileMonitoringRemote.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.jmx;

import javax.ejb.Remote;

/**
 * ProfileMonitoringRemote.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 13/02/2015 16:39:11
 */
@Remote
public interface ProfileMonitoringRemote {

	/**
	 * Gets the transaction failures number.
	 *
	 * @return the transaction failures number
	 */
	long getNumberSuccessfulTransactions();

	/**
	 * Gets the transaction success number.
	 *
	 * @return the transaction success number
	 */
	long getNumberFailedTransactions();

	/**
	 * Increment transaction success number.
	 */
	void incrementNumberSuccessfulTransactions();

	/**
	 * Increment transaction failures number.
	 */
	void incrementNumberFailedTransactions();

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
	 * Gets the profile tps.
	 *
	 * @return the profile tps
	 */
	long getProfileTps();

}
