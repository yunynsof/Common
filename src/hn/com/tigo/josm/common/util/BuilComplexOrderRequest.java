/**
 * BuilComplexOrderRequest.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

import hn.com.tigo.josm.common.order.ComplexOrderRequest;
import hn.com.tigo.josm.common.order.EnumOrderType;
import hn.com.tigo.josm.common.order.OrderRequestDetail;


/**
 * BuilComplexOrderRequest.
 * This class factorizes a ComplexOrderRequest using it's params
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version 
 * @since 25/11/2014 03:08:12 PM 2014
 */
public class BuilComplexOrderRequest {

	/**
	 * Create Factory complex product request order.
	 *
	 * @param ipUser Ip user value
	 * @param subscriberId Subscriber id value
	 * @param keyWord Keyword value
	 * @param externalTransaction external transaction value
	 * @param user user value
	 * @param interfaceName intervface name value
	 * @param orderType order type value
	 * @param productId product id value
	 * @param quantity quantity value
	 * @param channelId channel id value
	 * @return tComplexOrderRequest value factorized
	 */
	public static  ComplexOrderRequest factoryComplexProductRequestOrder(
			final String ipUser, final String subscriberId,
			final String keyWord, final String externalTransaction,
			final String user, final String interfaceName,final EnumOrderType orderType,
			final long productId, final int quantity, final int channelId  ) {
		final ComplexOrderRequest complexProductRequestOrder = new ComplexOrderRequest();
		complexProductRequestOrder.setChannelId(channelId);
		complexProductRequestOrder.setComment(keyWord);
		complexProductRequestOrder.setExternalTransacionId(externalTransaction);
		complexProductRequestOrder.getOrderRequestDetail();
		
		OrderRequestDetail simpleProductRequestOrder = new OrderRequestDetail();
		simpleProductRequestOrder.setSubscriberId(subscriberId);
		simpleProductRequestOrder.setOrderType(orderType);
		simpleProductRequestOrder.setProductId(productId);
		simpleProductRequestOrder.setQuantity(quantity);
		
		complexProductRequestOrder.getOrderRequestDetail().add(simpleProductRequestOrder);
		return complexProductRequestOrder;
	}

}
