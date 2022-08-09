package hn.com.tigo.josm.common.interfaces;

import java.util.Date;

import hn.com.tigo.josm.common.order.EnumOrderType;

/**
 * CacheManagerMXBean.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0
 * @since 4/06/2015 06:22:16 PM 2015
 */
public interface CacheManagerMXBean {

	
	/**
	 * Method responsible to reset bpm version cache.
	 */
	void resetBpmVersionCache();
	
	/**
	 * Method responsible to reset BPMN cache by productFamilyid and OrderType.
	 *
	 * @param productFamilyId the product family id
	 * @param orderType the order type
	 */
	void resetBpmCacheByProductFamilyAndOrder(final Long productFamilyId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to gets the bpmn version cache date expiration.
	 *
	 * @param productFamilyId the product family id
	 * @param orderType the order type
	 * @return the bpmn version cache date expiration
	 */
	Date getBpmnVersionCacheExpiration(final Long productFamilyId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to reset parameter cache.
	 */
	void resetParameterCache();
	
	/**
	 * Method responsible to reset parameter cache by product and order.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 */
	void resetParameterCacheByProductAndOrder(final Long productId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to gets the parameter cache expiration.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 * @return the produc cache expiration
	 */
	Date getParameterCacheExpiration(final Long productId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to reset product cache.
	 */
	void resetProductCache();
	
	/**
	 * Method responsible to reset product cache by id.
	 *
	 * @param productId the product id
	 */
	void resetProductCacheById(final Long productId, final EnumOrderType orderType);
	
	
	/**
	 * Method responsible to gets the product cache expiration.
	 *
	 * @param productId the product id
	 * @return the product cache expiration
	 */
	Date getProductCacheExpiration(final Long productId, final EnumOrderType orderType);
	
	
	/**
	 * Method responsible of changing the state of a product in the cache.
	 * @param productId
	 * 	the id of the product
	 * @param enable
	 * 	the new state (true|false)
	 * @return
	 * 	the message
	 */
	String changeStatusProduct(final Long productId, final EnumOrderType orderType, final Boolean enable);
}
