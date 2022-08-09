package hn.com.tigo.josm.common.jmx;

import java.util.concurrent.atomic.AtomicLong;

public class DriverMonitoring extends JOSMMonitoring implements DriverMonitoringMXBean {

	private final AtomicLong _totalDrivers;
	private final AtomicLong _idleDrivers;
	private final AtomicLong _insuficientDrivers;
	private final AtomicLong _connectionRefused;
	private final AtomicLong _lastEndpointTimeMillis;		
	private final AtomicLong _maxUsedDrivers;
	
	
	public DriverMonitoring(){
		_totalDrivers = new AtomicLong(INIT_VALUE);
		_idleDrivers = new AtomicLong(INIT_VALUE);
		_insuficientDrivers = new AtomicLong(INIT_VALUE);
		_connectionRefused =  new AtomicLong(INIT_VALUE);
		_lastEndpointTimeMillis = new AtomicLong(INIT_VALUE);
		_maxUsedDrivers = new AtomicLong(INIT_VALUE);	
	}

	
	@Override
	public long getTotalDrivers() {
		return _totalDrivers.longValue();
	}

	@Override
	public long getIdleDrivers() {
		return _idleDrivers.longValue();
	}


	@Override
	public void setTotalDrivers(final long total) {
		_totalDrivers.set(total);		
	}


	@Override
	public void setIdleDrivers(long idles) {
		_idleDrivers.set(idles);
		if(this._totalDrivers.longValue() - this._idleDrivers.longValue() > this._maxUsedDrivers.longValue()){
			this._maxUsedDrivers.set(this._totalDrivers.longValue() - this._idleDrivers.longValue());
		}
	}
	
	

	@Override
	public void incrementInsuficientDrivers() {
		this._insuficientDrivers.getAndIncrement();
		
	}
	
	
	@Override
	public long getInsuficientDrivers() {
		return _insuficientDrivers.longValue();
	}


	@Override
	public void incrementConnectionRefused() {
		this._connectionRefused.getAndIncrement();		
	}


	@Override
	public long getConnectionRefused() {
		return _connectionRefused.longValue();
	}

	
	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.JOSMMonitoringMXBean#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		_insuficientDrivers.set(INIT_VALUE);
		_connectionRefused.set(INIT_VALUE);
		_maxUsedDrivers.set(INIT_VALUE);
		_lastEndpointTimeMillis.set(INIT_VALUE);;
	}


	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.jmx.DriverMonitoringMXBean#getMaxUsedDrivers()
	 */
	@Override
	public long getMaxUsedDrivers() {
		return _maxUsedDrivers.longValue();
	}

	@Override
	public long getLastEndpointTimeMillis() {
		return _lastEndpointTimeMillis.longValue();
	}


	@Override
	public void setLastEndpointTimeMillis(long lastEndpoint) {
		_lastEndpointTimeMillis.set(lastEndpoint);
	}	

}
