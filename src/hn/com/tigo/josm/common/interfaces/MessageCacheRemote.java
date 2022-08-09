package hn.com.tigo.josm.common.interfaces;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface MessageCacheRemote extends Resetable{

	/**
	 * Method responsible to reset message cache by productId and errorCode.
	 *
	 * @param productId the product id
	 * @param errorCode the error code
	 */
	void resetCacheByProductAndError(final long productId, final int errorCode);
	
	/**
	 * Method responsible to gets the message cache expiration.
	 *
	 * @param productId the product id
	 * @param errorCode the error code
	 * @return the message cache expiration
	 */
	Date getMessageCacheExpiration(final long productId, final int errorCode);
}
