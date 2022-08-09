package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.GatewayException;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.order.OrderResponse;


/**
 * AbstractGatewayExecutorOrderResponse.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @param <T> the generic type
 * @param <W> the generic type
 * @since 07-09-2015 07:07:24 PM 2015
 */
public abstract class AbstractGatewayExecutorOrderResponse<T, W> {


	/**
	 * Instantiates a new abstract gateway request executor.
	 * 
	 * @param jndiGateway
	 *            the jndi gateway
	 */
	public AbstractGatewayExecutorOrderResponse() {
	}

	
	/**
	 * Execute gateway.
	 *
	 * @param request the request
	 * @param proxyGenericRequest the proxy generic request
	 * @return the order response
	 * @throws GatewayException the gateway exception
	 * @throws AdapterException 
	 */
	public OrderResponse executeGateway(final W request, final T proxyGenericRequest) throws GatewayException, AdapterException {
		return executeRequest(request, proxyGenericRequest);
	}

	/**
	 * Execute request for Gateway by EJB service.
	 *
	 * @param request            the request is a http context to get the user and ip address
	 *            as input parameters to build the metaOrderRequest.
	 * @param proxyGenericRequest            the proxy as400 request type
	 * @return the response is an Http response, it could be Http 500 or 200.
	 * @throws GatewayException the gateway exception
	 * @throws AdapterException 
	 */

	private OrderResponse executeRequest(final W request, final T proxyGenericRequest) throws GatewayException, AdapterException {

		OrderResponse ordResponse = new OrderResponse();
		final MetaOrderRequest metaOrderRequest = buildMetaOrderRequest(request, proxyGenericRequest);
		final InterfaceFactory interfaceFactory = new InterfaceFactory();
		final GatewayRemote gatewayRemote = interfaceFactory.getGatewayRemote();
		ordResponse = gatewayRemote.executeOrder(metaOrderRequest);
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
	 * @throws AdapterException 
	 */
	public abstract MetaOrderRequest buildMetaOrderRequest(final W request, final T proxyGenericRequest) throws AdapterException;

}
