package hn.com.tigo.josm.common.adapter.task;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.interfaces.Closeable;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

public class TaskExecutor<T,D > implements Callable<TaskResponseType> {
	
	private final transient Logger LOGGER = Logger.getLogger(TaskExecutor.class);
	
	private final AbstractTask<T, D> _task;
	
	public TaskExecutor(AbstractTask<T, D> task){
		this._task = task;
		
	}

	@Override
	public TaskResponseType call(){
		TaskResponseType resp = null;
		try {
			resp = _task.executeDriverTask();
		} catch (AdapterException e) {
			LOGGER.error("executeDriverTask Error thrown: "+e.getMessage());
			_task._currentException = e;
		} finally {
			LOGGER.info("Closing connection from call");
			if(_task._driver instanceof Closeable) {
				((Closeable) _task._driver).closeConnection();
			}
		}

		return resp;
	}

}
