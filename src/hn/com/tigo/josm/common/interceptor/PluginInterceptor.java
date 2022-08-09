/**
 * PluginInterceptor.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.interceptor;

import hn.com.tigo.josm.common.exceptions.GatewayPolicyException;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.jmx.event.PerformanceEvent;
import hn.com.tigo.josm.common.order.PluginRequest;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

/**
 * PluginInterceptor.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 12/02/2015 02:17:46 PM 2015
 */
@PluginInterceptorBinding
@Interceptor
public class PluginInterceptor {
	
	/** Attribute that determine a Constant of LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(PluginInterceptor.class);
	
	/** Attribute that determine ifactory. */
	final InterfaceFactory ifactory;
	
	/**
     * Default constructor. 
     */
    public PluginInterceptor() {
    	 ifactory = new InterfaceFactory();
    }
	
	/**
	 * Validate.
	 *
	 * @param ctx the ctx
	 * @return the object
	 * @throws Exception the exception
	 */
	@AroundInvoke
    public Object validate(final InvocationContext ctx) throws Exception{
		
		final MonitoringManagerRemote monitoringManager = ifactory.getMonitoringManagerRemote();
		final long timeInit = System.currentTimeMillis();
		Class<?> target = ctx.getMethod().getDeclaringClass();
		
		
		final PluginRequest pluginRequest = (PluginRequest)ctx.getParameters()[0];
		LOGGER.info("Interceptor "+pluginRequest.getPolicy()+";"+pluginRequest.getInstance());
		
		final PerformanceEvent event = new PerformanceEvent();
		event.setComponent("policy.plugin");
		event.setObjectName(target.getSimpleName());
		
		
		Object object = null;
		
		
		try{
			object = ctx.proceed();
			event.setResult(true, System.currentTimeMillis() - timeInit);
			monitoringManager.receiveEvent(event);
		}catch(GatewayPolicyException e){
			event.setResult(false, System.currentTimeMillis() - timeInit);
			monitoringManager.receiveEvent(event);
			throw e;
		}
    	 
    	return object;
    }

}
