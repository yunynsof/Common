/**
 * JOSMMonitoring.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.jmx;

import java.util.concurrent.atomic.AtomicLong;


/**
 * JOSMMonitoring. This class exposes monitoring methods using MBeanServer
 * methods for do monitoring.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @see
 * @since 24/02/2015 02:48:19 PM 2015
 */
public class JOSMMonitoring implements JOSMMonitoringMXBean {
	
	/** Attribute that determine a Constant of INIT_VALUE. */
	protected static final long INIT_VALUE = 0L; 
	
	/** Contains inboundMessages metric value. */
	private final AtomicLong _inboundMessages;

	/** Contains lastInboundMessages metric value. */
	private final AtomicLong _lastInboundMessages;

	/** Contains failedMessages metric value. */
	private final AtomicLong _failedMessages;

	/** Contains lastTransactionTimeMillis metric value. */
	private final AtomicLong _lastTransactionTimeMillis;
	
	/** Contains tps metric value. */
	private AtomicLong _tps;
	
	
	/**
	 * Instantiates a new JOSM monitoring.
	 */
	public JOSMMonitoring(){
		_inboundMessages = new AtomicLong(INIT_VALUE);
		_failedMessages = new AtomicLong(INIT_VALUE);
		_lastTransactionTimeMillis = new AtomicLong(INIT_VALUE);
		_lastInboundMessages = new AtomicLong(INIT_VALUE);
		_tps = new AtomicLong(INIT_VALUE);
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getInboundMessages()
	 */
	@Override
	public long getInboundMessages() {
		return _inboundMessages.longValue();
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getFailedMessages()
	 */
	@Override
	public long getFailedMessages() {
		return _failedMessages.longValue();
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getSucessMessages()
	 */
	@Override
	public long getSucessMessages() {
		return _inboundMessages.longValue()
				- _failedMessages.longValue();
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#incrementInboundMessages()
	 */
	@Override
	public void incrementInboundMessages() {
		this._inboundMessages.getAndIncrement();
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#incrementFailedMessages()
	 */
	@Override
	public void incrementFailedMessages() {
		this._failedMessages.getAndIncrement();
		this._inboundMessages.getAndIncrement();
		
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getLastTransactionTimeMillis()
	 */
	@Override
	public long getLastTransactionTimeMillis() {
		return _lastTransactionTimeMillis.longValue();
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#setLastTransactionTimeMillis(long)
	 */
	@Override
	public void setLastTransactionTimeMillis(long lastTransactionTimeMillis) {
		this._lastTransactionTimeMillis.set(lastTransactionTimeMillis);
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getTPS()
	 */
	@Override
	public long getTPS() {
		return _tps.longValue();
	}
	
	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#calculateTPS()
	 */
	@Override
	public void calculateTPS() {
		_tps.set(_inboundMessages.longValue()
				- _lastInboundMessages.longValue());
		_lastInboundMessages.set(_inboundMessages.intValue());
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#reset()
	 */
	@Override
	public void reset() {
		_inboundMessages.set(INIT_VALUE);
		_failedMessages.set(INIT_VALUE);
		_lastTransactionTimeMillis.set(INIT_VALUE);
		_lastInboundMessages.set(INIT_VALUE);
		_tps.set(INIT_VALUE);
	}

	
}
