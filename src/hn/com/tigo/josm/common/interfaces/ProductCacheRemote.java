package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.order.EnumOrderType;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface ProductCacheRemote extends Resetable{

	
	/**
	 * Method responsible to reset product cache by id.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 */
	void resetProductCacheById(final long productId, final EnumOrderType orderType);
	
	
	/**
	 * Method responsible to gets the product cache expiration.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 * @return the product cache expiration
	 */
	Date getProductCacheExpiration(final long productId, final EnumOrderType orderType);
	
	
	
	/**
	 * Method responsible of changing the state of a product in the cache.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 * @param enable the enable
	 * @return the string
	 */
	String changeStatusProduct(final Long productId, final EnumOrderType orderType, final Boolean enable);
}
