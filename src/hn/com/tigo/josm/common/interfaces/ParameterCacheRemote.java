package hn.com.tigo.josm.common.interfaces;

import java.util.Date;

import hn.com.tigo.josm.common.order.EnumOrderType;

import javax.ejb.Remote;

@Remote
public interface ParameterCacheRemote extends Resetable{

	/**
	 * Method responsible to reset parameter cache by product and order.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 */
	void resetCacheByProductAndOrder(final long productId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to gets the produc cache expiration.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 * @return the produc cache expiration
	 */
	Date getProducCacheExpiration(final long productId, final EnumOrderType orderType);
}
