package hn.com.tigo.josm.common.jmx.event;

import hn.com.tigo.josm.common.dto.JOSMEvent;

import java.io.Serializable;

public class EndpointEvent extends JOSMEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Attribute that stores the _transactionInMillis. */
	private long _lastEndpointTransactionInMillis;

	public EndpointEvent() {
		super(MonitoringEventType.ENDPOINT, MXBeanType.DRIVER);
	}

	public long get_lastEndpointTransactionInMillis() {
		return _lastEndpointTransactionInMillis;
	}

	public void set_lastEndpointTransactionInMillis(
			long _lastEndpointTransactionInMillis) {
		this._lastEndpointTransactionInMillis = _lastEndpointTransactionInMillis;
	}	

}
