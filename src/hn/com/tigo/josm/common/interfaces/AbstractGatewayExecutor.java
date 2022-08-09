package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.GatewayException;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.util.ProxyUtil;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * The Class AbstractGatewayRequestExecutor.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version
 * @param <T>
 *            the generic type
 * @since 24-nov-2014 14:48:20 2014
 */
public abstract class AbstractGatewayExecutor<T,W> {

	/** Attribute that determine log. */
	private static final transient Logger LOGGER = Logger.getLogger(AbstractGatewayExecutor.class);

	/** The _jndi gateway. */
	private static String _jndiGateway;

	/**
	 * The Constant RESPONSE_ERROR.
	 */
	private static final int RESPONSE_CODE_ERROR = 500;

	/** The Constant RESPONSE_CODE_OK. */
	private static final int RESPONSE_CODE_OK = 200;

	/** The Constant OK_RESPONSE. */
	private static final Response OK_RESPONSE = ProxyUtil.createResponse(RESPONSE_CODE_OK, "Success.");

	/**
	 * Instantiates a new abstract gateway request executor.
	 *
	 * @param jndiGateway the jndi gateway
	 */
	public AbstractGatewayExecutor(final String jndiGateway) {
		_jndiGateway = jndiGateway;
	}

	
	/**
	 * Execute gateway.
	 *
	 * @param request the request
	 * @param proxyGenericRequest the proxy generic request
	 * @return the response
	 */
	public Response executeGateway(final W request, final T proxyGenericRequest) {
		Response currentResponse;
		currentResponse = executeRequest(request, proxyGenericRequest);
		LOGGER.info(currentResponse.getEntity().toString());
		return currentResponse;
	}


	/**
	 * Execute request for Gateway by EJB service.
	 * 
	 * @param request
	 *            the request is a http context to get the user and ip address
	 *            as input parameters to build the metaOrderRequest.
	 * @param proxyGenericRequest
	 *            the proxy as400 request type
	 * @return the response is an Http response, it could be Http 500 or 200.
	 */

	private Response executeRequest(final W request, final T proxyGenericRequest) {

		final String jdniMsg = "Failed to initialize the ejb jndi Gateway.";
		Response currentResponse = ProxyUtil.createResponse(RESPONSE_CODE_ERROR, jdniMsg);
		final MetaOrderRequest metaOrderRequest = buildMetaOrderRequest(request, proxyGenericRequest);

		try {
			InterfaceFactory interfaceFactory = new InterfaceFactory();
			final GatewayRemote gatewayRemote = interfaceFactory.getGatewayRemote();
			gatewayRemote.executeOrder(metaOrderRequest);
			currentResponse = OK_RESPONSE;

		} catch (GatewayException e) {
			String message = e.getMessage() == null ? "" : e.getMessage();
			LOGGER.error(message, e);
			currentResponse = ProxyUtil.createResponse(RESPONSE_CODE_ERROR,message);
		} 
		return currentResponse;

	}
	
	
	

	/**
	 * Builds the meta order request for input parameter to Gateway request.
	 * 
	 * @param request
	 *            the request is a http context to get the user and ip address
	 *            as input parameters to build the metaOrderRequest.
	 * @param proxyGenericRequest
	 *            the proxy as400 request type
	 * @return the meta order request object to Gateway execution.
	 */
	public abstract MetaOrderRequest buildMetaOrderRequest(final W request,
			final T proxyGenericRequest);
	

	
}
