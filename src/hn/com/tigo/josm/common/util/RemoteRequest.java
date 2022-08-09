/**
 * RemoteRequest.java
 * Gateway
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


/**
 * RemoteRequest.
 * This class allows to get a request's metadata from the webservice context
 *
 * @author Jhon Cortes <mailto:lordkortex@gmail.com />
 * @version 
 * @since 24/11/2014 02:46:16 PM 2014
 */
public class RemoteRequest {
	
	/**
	 * Gets the http servlet request.
	 * This method will get the message context from webservice context 
	 * @param wsContext the ws context
	 * @return the http servlet request
	 */
	public HttpServletRequest getHttpServletRequest(WebServiceContext wsContext) {
		final MessageContext messageContext = wsContext.getMessageContext();
		return (HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST);
	}

	/**
	 *  This method will get the remote user from webservice context.
	 * @param wsContext the ws context
	 * @return the remote user
	 */
	public String getRemoteUser(WebServiceContext wsContext) {
		if (wsContext != null && wsContext.getUserPrincipal() != null) {
			return wsContext.getUserPrincipal().getName();
		}

		return "unknown-user";
	}
	
	
	/**
	 *  This method will get the remote ip user from webservice context.
	 * @param wsContext the ws context
	 * @return the remote user
	 */
	public String getRemoteUserIp(WebServiceContext wsContext) throws IllegalStateException {
		String clientIp = "";
		if (wsContext != null) {
			final MessageContext mc = wsContext.getMessageContext();
			final HttpServletRequest req = (HttpServletRequest) mc
					.get(MessageContext.SERVLET_REQUEST);
			clientIp = req.getRemoteAddr();
		}
		return clientIp;
	}
	
	

}
