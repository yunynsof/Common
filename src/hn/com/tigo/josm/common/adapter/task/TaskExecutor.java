package hn.com.tigo.josm.common.adapter.task;

import hn.com.tigo.josm.common.adapter.AbstractAdapter;
import hn.com.tigo.josm.common.adapter.DriverReference;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.interfaces.Closeable;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerLocal;
import hn.com.tigo.josm.common.jmx.event.EndpointEvent;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

/**
 * TaskExecutor.
 * 
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @param <T>
 *            the generic type
 * @param <D>
 *            the generic type
 * @see
 * @since 8/07/2015 03:52:05 PM 2015
 */
public class TaskExecutor<T, D> implements Callable<TaskResponseType> {

	/** Attribute that determine LOGGER. */
	private final transient Logger LOGGER = Logger
			.getLogger(TaskExecutor.class);

	/** Attribute that determine _task. */
	private final AbstractTask<T, D> _task;

	/** Attribute that determine _monitoringManager. */
	private MonitoringManagerLocal _monitoringManager;

	/**
	 * Instantiates a new task executor.
	 * 
	 * @param task
	 *            the task
	 */
	public TaskExecutor(final AbstractTask<T, D> task, final MonitoringManagerLocal _monitoringManager) {
		this._task = task;
		this._monitoringManager = _monitoringManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public TaskResponseType call() throws AdapterException {

		TaskResponseType resp = null;
		final AbstractAdapter<D> singletonAdapter = _task.getSingletonAdapter();
		DriverReference<D> driverReference = null;
		D driver = null;
		EndpointEvent event = null;
		long initialTime = 0L;
		try {
			driverReference = singletonAdapter.getDriver();
			driver = driverReference.getDriver();
			event = new EndpointEvent();
			event.setComponent(singletonAdapter.getAdapterSimpleName());
			event.setObjectName(singletonAdapter.getAdapterSimpleName());
			initialTime = System.currentTimeMillis();
			resp = _task.executeDriverTask(driver);
			
		}  finally {
			LOGGER.info("Closing connection from call");
			if (driverReference != null) {
				
				if(event != null) {
					event.set_lastEndpointTransactionInMillis(System
							.currentTimeMillis() - initialTime);
					_monitoringManager.receiveEvent(event);
				}
				
				if (driver != null && driver instanceof Closeable) {
					((Closeable) driver).closeConnection();
				}

				if (_task._flagRemoveDriver) {
					driverReference.clearDriver();
				}

				singletonAdapter.freeDriver(driverReference);
			}
		}

		return resp;
	}

}
