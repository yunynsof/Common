/**
 * BrokerLocal.java
 * Broker
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.BrokerException;
import hn.com.tigo.josm.common.order.OrderResponse;

import javax.ejb.Local;

/**
 * BrokerLocal.
 * Broker interface for local access
 * @author Juan Pablo Gomez<mailto:jgomezg@stefaninicolombia.com />
 * @version 1.0
 * @since 21/10/2014 04:52:16 PM 2014
 */
@Local
public interface BrokerLocal {

	/**
	 * Executes a broker order.
	 * This method will process a orderRequest applying  broker's logic
	 * @param orderRequest The value of the order request
	 * @return the product The product response value
	 * @throws BrokerException Throws broker exception when broker's logic validations fail
	 */
	OrderResponse executeOrder(
		MetaOrderRequest orderRequest) throws BrokerException;

}
