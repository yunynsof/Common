/**
 * BpmVersionFileRemote.java
 * Broker
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.order.EnumOrderType;
import hn.com.tigo.josm.common.util.AdapterBpmFileVersion;

import javax.ejb.Remote;

/**
 * BpmVersionFileRemote.
 *
 * @author Jhon Cortes <mailto:lordkortex@gmail.com />
 * @version 
 * @since 22-dic-2014 16:28:23 2014
 */
@Remote
public interface BpmVersionFileRemote {

	/**
	 * Gets the actual bpm version product.
	 *
	 * @param productId
	 *            the product id
	 * @param orderType
	 *            the order type
	 * @return the actual bpm version product
	 */
	AdapterBpmFileVersion getActualBpmVersionProduct(final Long productId,
			EnumOrderType orderType);

}
