/**
 * JOSMMonitoring.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.jmx;

import java.util.concurrent.atomic.AtomicLong;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.monitor.MonitorNotification;


/**
 * JOSMMonitoring. This class exposes monitoring methods using MBeanServer
 * methods for do monitoring.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @see
 * @since 24/02/2015 02:48:19 PM 2015
 */
public class JOSMMonitoring extends NotificationBroadcasterSupport implements JOSMMonitoringMXBean {
	
	/** Attribute that determine a Constant of INIT_VALUE. */
	protected static final long INIT_VALUE = 0L; 
	
	/** Contains inboundMessages metric value. */
	private final AtomicLong _inboundMessages;

	/** Contains lastInboundMessages metric value. */
	private final AtomicLong _lastInboundMessages;

	/** Contains failedMessages metric value. */
	private final AtomicLong _failedMessages;
	
	private final AtomicLong _successMessages;

	/** Contains lastTransactionTimeMillis metric value. */
	private final AtomicLong _lastTransactionTimeMillis;
	
	/** Contains tps metric value. */
	private AtomicLong _tps;
	
	/** Contains max tps metric value. */
	private AtomicLong _maxTps;
	
	/** Contains max lastTransactionTimeMillis metric value. */
	private AtomicLong _maxTransactionTimeMillis;
	
	/**
	 * Instantiates a new JOSM monitoring.
	 */
	public JOSMMonitoring(){
		_successMessages = new AtomicLong(INIT_VALUE);
		_inboundMessages = new AtomicLong(INIT_VALUE);
		_failedMessages = new AtomicLong(INIT_VALUE);
		_lastTransactionTimeMillis = new AtomicLong(INIT_VALUE);
		_lastInboundMessages = new AtomicLong(INIT_VALUE);
		_tps = new AtomicLong(INIT_VALUE);		
		_maxTransactionTimeMillis = new AtomicLong(INIT_VALUE);
		_maxTps = new AtomicLong(INIT_VALUE);
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
		_inboundMessages.getAndIncrement();
		final Notification notification = new AttributeChangeNotification(this,
				_inboundMessages.get(), System.currentTimeMillis(),
				"Failed messages", NotificationConstant.FAILED, Long.class.getCanonicalName(), _failedMessages.get(),
				_failedMessages.incrementAndGet());
		super.sendNotification(notification);
	}

	@Override
	public void incrementSuccessMessages() {
		_inboundMessages.getAndIncrement();
		final Notification notification = new AttributeChangeNotification(this,
				_inboundMessages.get(), System.currentTimeMillis(),
				"Success messages", NotificationConstant.SUCCESS, Long.class.getCanonicalName(), _successMessages.get(),
				_successMessages.incrementAndGet());
		super.sendNotification(notification);
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
		
		if(this._lastTransactionTimeMillis.longValue()>this._maxTransactionTimeMillis.longValue()){
			this._maxTransactionTimeMillis.set(this._lastTransactionTimeMillis.longValue());
		}
		
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
		if(this._tps.longValue()>this._maxTps.longValue()){
			this._maxTps.set(this._tps.longValue());
		}
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
		_maxTransactionTimeMillis = new AtomicLong(INIT_VALUE);
		_maxTps = new AtomicLong(INIT_VALUE);
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getMaxTPS()
	 */
	@Override
	public long getMaxTPS() {
		return this._maxTps.longValue();
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#getMaxLastTransactionTimeMillis()
	 */
	@Override
	public long getMaxLastTransactionTimeMillis() {
		return _maxTransactionTimeMillis.longValue();
	}

	/* (non-Javadoc)
	 * @see javax.management.NotificationBroadcasterSupport#getNotificationInfo()
	 */
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		final String[] types = new String[] { MonitorNotification.THRESHOLD_HIGH_VALUE_EXCEEDED };
		final String description = "CPE notification listener - Breaker product";
		final MBeanNotificationInfo info = new MBeanNotificationInfo(types, AttributeChangeNotification.class.getName(), description);

		return new MBeanNotificationInfo[] { info };
	}

}
