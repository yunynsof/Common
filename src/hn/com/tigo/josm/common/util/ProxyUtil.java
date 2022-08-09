package hn.com.tigo.josm.common.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * The Class ProxyUtil.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version
 * @since 24-nov-2014 14:48:20 2014
 */
public class ProxyUtil {

	/**
	 * Instantiates a new proxy util.
	 */
	public ProxyUtil() {

	}

	/**
	 * Creates the Http response. It would be and HttpResponse 500 or 200 with
	 * an inner message.
	 * 
	 * @param responseCode
	 *            the response code could be Http 200 or Http 500
	 * @param message
	 *            the message is the response description.
	 * @return the response is a Http response it could be 500 or 200 with an
	 *         inner message.
	 */
	public static Response createResponse(final int responseCode, final String message) {
		ResponseBuilder responseBuilder = Response.status(responseCode);
		responseBuilder = responseBuilder.entity(message);
		return responseBuilder.build();
	}

}
