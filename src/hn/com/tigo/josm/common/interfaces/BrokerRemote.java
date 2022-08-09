/**
 * BrokerRemote.java
 * Broker
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.BrokerException;
import hn.com.tigo.josm.common.order.OrderResponse;

import javax.ejb.Remote;

/**
 * BrokerRemote.
 * 
 * Broker interface for remote  access
 * 
 * @author Juan Pablo Gomez <mailto:jgomezg@stefaninicolombia.com />
 * @version 1.0
 * @since 21/10/2014 04:51:59 PM 2014
 */
@Remote
public interface BrokerRemote {

	/**
	 * Executes a broker order.
	 * This method will process a orderRequest applying  broker's logic
	 * @param orderRequest The value of the order request
	 * @return the product response order
	 * @throws BrokerException the broker exception
	 */
	OrderResponse executeOrder(
		final MetaOrderRequest orderRequest) throws BrokerException;

}
