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
public interface GatewayCacheManagerMXBean {

	/**
	 * Method responsible to reset message cache.
	 */
	void resetMessageCache();
	
	/**
	 * Method responsible to reset message cache by productId and errorCode.
	 *
	 * @param productId the product id
	 * @param errorCode the error code
	 */
	void resetMessageCacheByProductAndError(final Long productId, final Integer errorCode);
	
	/**
	 * Method responsible to gets the message cache expiration.
	 *
	 * @param productId the product id
	 * @param errorCode the error code
	 * @return the message cache expiration
	 */
	Date getMessageCacheExpiration(final Long productId, final Integer errorCode);
	
	/**
	 * Method responsible to reset policy cache.
	 */
	void resetPolicyCache();
	
	/**
	 * Method responsible to reset cache by productId and orderType.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 */
	void resetPolicyCacheByProductAndOrder(final Long productId, final EnumOrderType orderType);
	
	/**
	 * Method responsible to gets the policy cache expiration.
	 *
	 * @param productId the product id
	 * @param orderType the order type
	 * @return the policy cache expiration
	 */
	Date getPolicyCacheExpiration(final Long productId, final EnumOrderType orderType);
	
}
