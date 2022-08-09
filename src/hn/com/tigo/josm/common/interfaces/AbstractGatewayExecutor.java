package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.MetaOrderRequest;
import hn.com.tigo.josm.common.exceptions.GatewayException;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;
import hn.com.tigo.josm.common.order.OrderResponse;
import hn.com.tigo.josm.common.order.OrderResponseDetail;
import hn.com.tigo.josm.common.order.ParameterType;
import hn.com.tigo.josm.common.util.ProxyUtil;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * The Class AbstractGatewayRequestExecutor.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version
 * @param <T> the generic type
 * @param <W> the generic type
 * @since 24-nov-2014 14:48:20 2014
 */
public abstract class AbstractGatewayExecutor<T,W> {

	/** Attribute that determine log. */
	private static final transient Logger LOGGER = Logger.getLogger(AbstractGatewayExecutor.class);


	/** The Constant BPMN_RESPONSE_MESSAGE. */
	private static final String BPMN_RESPONSE_MESSAGE = "BPMN_RESPONSE_MESSAGE"; 
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

		Response currentResponse = ProxyUtil.createResponse(RESPONSE_CODE_OK, "");
		final MetaOrderRequest metaOrderRequest = buildMetaOrderRequest(request, proxyGenericRequest);

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			final GatewayRemote gatewayRemote  = serviceLocator.getService(InterfaceFactory.GATEWAY_REMOTE);
			final OrderResponse orderResponse = gatewayRemote.executeOrder(metaOrderRequest);
			currentResponse = createProxyResponse(orderResponse);
		} catch (GatewayException | ServiceLocatorException e) {
			final String message = e.getMessage() == null ? "" : e.getMessage();
			currentResponse = ProxyUtil.createResponse(RESPONSE_CODE_ERROR,message);
		} 

		return currentResponse;

	}


	/**
	 * Creates the proxy response.
	 *
	 * @param orderResponse the order response
	 * @return the response
	 */
	private Response createProxyResponse(final OrderResponse orderResponse) {
		Response currentResponse;
		currentResponse = ProxyUtil.createResponse(RESPONSE_CODE_OK,orderResponse.getMessage());
		final List<OrderResponseDetail> orderResponseDetailList = orderResponse.getOrderResponseDetail();
		if(orderResponseDetailList.size()>0){
			final List<ParameterType> paraArray = orderResponseDetailList.get(0).getParameters().getParameter();
			for(ParameterType paType : paraArray){
				if(paType.getName().equals(BPMN_RESPONSE_MESSAGE)){
					 currentResponse = ProxyUtil.createResponse(RESPONSE_CODE_OK,paType.getValue().toString());
					 break;
				}
			}
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
