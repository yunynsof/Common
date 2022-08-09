package hn.com.tigo.josm.common.jmx;

import java.util.concurrent.atomic.AtomicLong;

public class DriverMonitoring extends JOSMMonitoring implements DriverMonitoringMXBean {

	private final AtomicLong _totalDrivers;
	private final AtomicLong _idleDrivers;
	
	
	public DriverMonitoring(){
		_totalDrivers = new AtomicLong(INIT_VALUE);
		_idleDrivers = new AtomicLong(INIT_VALUE);
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
	}	

}
