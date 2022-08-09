package hn.com.tigo.josm.common.interfaces;

import java.util.Date;

import hn.com.tigo.josm.common.order.EnumOrderType;

import javax.ejb.Remote;

@Remote
public interface BrokerCacheRemote extends Resetable{

	/**
	 * Method responsible to reset BPMN cache by productFamilyid and OrderType
	 *
	 * @param productFamilyId the product family id
	 * @param orderType the order type
	 */
	void resetCacheByBpmn(final Long productFamilyId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to gets the cache expiration.
	 *
	 * @param productFamilyId the product family id
	 * @param orderType the order type
	 * @return the cache expiration
	 */
	Date getCacheExpiration(final Long productFamilyId, final EnumOrderType orderType);
}
