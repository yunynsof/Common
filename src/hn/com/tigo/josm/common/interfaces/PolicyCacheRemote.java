package hn.com.tigo.josm.common.interfaces;

import java.util.Date;

import hn.com.tigo.josm.common.order.EnumOrderType;

import javax.ejb.Remote;

@Remote
public interface PolicyCacheRemote extends Resetable{

	/**
	 * Method responsible to reset cache by product and order.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 */
	public void resetCacheByProductAndOrder(final long productId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to gets the policy cache expiration.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 * @return the policy cache expiration
	 */
	Date getPolicyCacheExpiration(final long productId, final EnumOrderType orderType);
	
}
