/**
 * OrchestratorLocal.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.dto.OrderExecutionRequest;
import hn.com.tigo.josm.common.exceptions.OrchestratorException;
import hn.com.tigo.josm.common.order.OrderResponse;

import javax.ejb.Local;

/**
 * Interface OrchestratorLocal.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 
 * @since 8/12/2014 04:10:28 PM 2014
 */
@Local
public interface OrderBootstrapperLocal {
	
	/**
	 * Execute order.
	 *
	 * @param request the request
	 * @return the order response
	 * @throws OrchestratorException the orchestrator exception
	 */
	OrderResponse executeOrder(final OrderExecutionRequest request) throws OrchestratorException;

}
