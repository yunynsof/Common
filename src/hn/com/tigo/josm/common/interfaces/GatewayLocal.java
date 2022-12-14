/**
 * GatewayLocal.java
 * Gateway
 * Copyright (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.GatewayException;
import hn.com.tigo.josm.common.order.OrderResponse;
import hn.com.tigo.josm.component.dto.JOSMResponse;

import javax.ejb.Local;

/**
 * GatewayLocal.
 * 
 * Remote interface that exposes the methods for session bean implementation
 * Gateway.
 * 
 * @author Jose David Martinez Rico
 * @version 1.0
 * @since 21/10/2014 11:04:01 AM
 */
@Local
public interface GatewayLocal {

	/**
	 * This method that execute any order of the Gateway and is it the
	 * responsible of validate the plugins associated.
	 * 
	 * @param gatewayRequest
	 *            The value of the order request
	 * @return the order response from the gateway
	 * @throws GatewayException
	 *             Throws broker exception when broker's logic validations fail
	 */
	OrderResponse executeOrder(MetaOrderRequest gatewayRequest) throws GatewayException;
	
	/**
	 * Method that compiles a bpmn xml string and returns weather it was successful or failed.
	 *
	 * @param productFamilyId the product family id
	 * @param orderType the order type
	 * @return the JOSM response
	 */
	JOSMResponse compileBpmn(final Long productFamilyId, final String orderType) throws GatewayException;

}
