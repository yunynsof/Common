package hn.com.tigo.josm.common.spr;

import java.util.concurrent.TimeUnit;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.log4j.Logger;

/**
 * IdleConnectionMonitorThread.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 19/11/2015 04:52:02 PM 2015
 */
public class IdleConnectionMonitorThread extends Thread {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IdleConnectionMonitorThread.class);
	
	/** The Constant WAIT_TIME. */
	private static final int WAIT_TIME = 5000;
	
	/** The Constant CLOSE_IDLE_TIME. */
	private static final int CLOSE_IDLE_TIME = 20;

	/** The conn mgr. */
	private final HttpClientConnectionManager _connMgr;
	
	/** The shutdown. */
	private volatile boolean shutdown;

	/**
	 * Instantiates a new idle connection monitor thread.
	 *
	 * @param connMgr the conn mgr
	 */
	public IdleConnectionMonitorThread(final HttpClientConnectionManager connMgr) {
		super();
		_connMgr = connMgr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			while (!shutdown) {
					Thread.sleep(WAIT_TIME);
					_connMgr.closeExpiredConnections();
					_connMgr.closeIdleConnections(CLOSE_IDLE_TIME, TimeUnit.SECONDS);
			}
		} catch (InterruptedException ex) {
			LOGGER.error(ex.getMessage(),ex);
		}
	}

	/**
	 * Shutdown.
	 */
	public void shutdown() {
		shutdown = true;
		synchronized (this) {
			notifyAll();
		}
	}
	
}
