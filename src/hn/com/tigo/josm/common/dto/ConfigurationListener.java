package hn.com.tigo.josm.common.dto;

import hn.com.tigo.josm.common.jmx.NotificationConstant;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Configuration.
 *
 * @author harold.castillo
 * @version 1.0
 * @since Oct 18, 2016 09:50:21 AM
 */
public class ConfigurationListener {

	private AtomicLong counter;

	private Date lastExecution;

	private long threshold;

	private int deltaTimeMillis;

	private long productId;
	
	private String orderType;

	public ConfigurationListener(final long threshold, final int deltaTimeMillis,
			final long productId, final String orderType) {
		this.threshold = threshold;
		this.deltaTimeMillis = deltaTimeMillis;
		this.productId = productId;
		this.counter = new AtomicLong(NotificationConstant.INITIAL_VALUE);
		this.lastExecution = Calendar.getInstance().getTime();
		this.orderType = orderType;
	}

	public long getThreshold() {
		return this.threshold;
	}

	public int getDeltaTimeMillis() {
		return this.deltaTimeMillis;
	}

	public long getProductId() {
		return this.productId;
	}

	public AtomicLong getCounter() {
		return this.counter;
	}

	public Date getLastExecution() {
		return this.lastExecution;
	}

	public void resetLastExecution() {
		this.lastExecution = Calendar.getInstance().getTime();
	}

	public String getOrderType() {
		return orderType;
	}

	public void reset() {
		this.counter.set(NotificationConstant.INITIAL_VALUE);
		this.lastExecution = Calendar.getInstance().getTime();
	}
}
