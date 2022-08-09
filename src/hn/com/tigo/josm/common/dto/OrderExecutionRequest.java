package hn.com.tigo.josm.common.dto;

import hn.com.tigo.josm.common.broker.compiler.task.AbstractElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderExecutionRequest.
 *
 * @author Camilo Gutierrez <mailto:cgutierrez@stefanini.com />
 * @version 
 * @since 13/02/2015 12:01:35 PM 2015
 */
public class OrderExecutionRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4595368614270492187L;
	
	

	/** The _meta order request. */
	private MetaOrderRequest _metaOrderRequest;

	/** The _order execution block. */
	private List<AbstractElement> _orderExecutionBlock;

	/**
	 * Instantiates a new order execution request.
	 */
	public OrderExecutionRequest() {
		_orderExecutionBlock = new ArrayList<AbstractElement>();
	}

	/**
	 * @return the metaOrderRequest
	 */
	public MetaOrderRequest getMetaOrderRequest() {
		return _metaOrderRequest;
	}

	/**
	 * @param metaOrderRequest the metaOrderRequest to set
	 */
	public void setMetaOrderRequest(final MetaOrderRequest metaOrderRequest) {
		this._metaOrderRequest = metaOrderRequest;
	}

	/**
	 * @return the orderExecutionBlock
	 */
	public List<AbstractElement> getOrderExecutionBlock() {
		return _orderExecutionBlock;
	}

	/**
	 * @param orderExecutionBlock the orderExecutionBlock to set
	 */
	public void setOrderExecutionBlock(final List<AbstractElement> orderExecutionBlock) {
		this._orderExecutionBlock = orderExecutionBlock;
	}

}
