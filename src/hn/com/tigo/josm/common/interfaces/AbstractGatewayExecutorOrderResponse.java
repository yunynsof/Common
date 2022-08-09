package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.GatewayException;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;
import hn.com.tigo.josm.common.order.OrderResponse;

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
public abstract class AbstractGatewayExecutorOrderResponse<T,W> {

	/** Attribute that determine log. */
	private static final transient Logger LOGGER = Logger.getLogger(AbstractGatewayExecutorOrderResponse.class);

	/** The _jndi gateway. */
	private static String _jndiGateway;


	/**
	 * Instantiates a new abstract gateway request executor.
	 *
	 * @param jndiGateway the jndi gateway
	 */
	public AbstractGatewayExecutorOrderResponse(final String jndiGateway) {
		_jndiGateway = jndiGateway;
	}

	
	/**
	 * Execute gateway.
	 *
	 * @param request the request
	 * @param proxyGenericRequest the proxy generic request
	 * @return the response
	 */
	public OrderResponse executeGateway(final W request, final T proxyGenericRequest) throws GatewayException {
		return executeRequest(request, proxyGenericRequest);
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

	private OrderResponse executeRequest(final W request, final T proxyGenericRequest)  throws GatewayException{

		OrderResponse ordResponse = new OrderResponse();
		final MetaOrderRequest metaOrderRequest = buildMetaOrderRequest(request, proxyGenericRequest);

		try {

			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			final GatewayRemote gatewayRemote = serviceLocator.getService(_jndiGateway);
			ordResponse = gatewayRemote.executeOrder(metaOrderRequest);

		} catch (ServiceLocatorException e) {
			LOGGER.error(e.getMessage().toString(), e);
		}
		return ordResponse;

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
