package hn.com.tigo.josm.common.adapter.task;

import java.util.concurrent.ThreadFactory;

/**
 * A factory for creating TaskThread objects.
 */
public class TaskThreadFactory implements ThreadFactory {

	/** Attribute that determine _adapterName. */
	private String _adapterName;
	
	/** Attribute that determine _version. */
	private long _version;
	
	/**
	 * Instantiates a new task thread factory.
	 *
	 * @param adapterName the adapter name
	 */
	public TaskThreadFactory(final String adapterName){
		this._adapterName = adapterName;
		this._version = System.currentTimeMillis();
		
		
	}
	
	
	/**
	 * New thread.
	 *
	 * @param runnable the runnable
	 * @return the thread
	 */
	@Override
	public Thread newThread(final Runnable runnable) {
		
		final Thread thread = new Thread(runnable, "ThreadExecutor_"+_adapterName+"v"+_version); 
		return thread;
	}

}
