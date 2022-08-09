/**
 * Task.java
 * LTE-EJB
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.adapter.task;

import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;

import javax.ejb.Remote;
import javax.jws.WebParam;

/**
 * Task.
 * Remote interface of task,defines signatures of executeTask method 
 *
 * @author Jimmy Muchachasoy <mailto:jamuchavisoy@stefanini.com />
 * @version 
 * @see 
 * @since 06-oct-2014 15:47:00 2014
 */
@Remote
public interface Task {

	/**
	 * Execute task metho, executes the operation defined on the adapters
	 * 
	 * @param taskType
	 *            Type of task to run
	 * @return Type of response type
	 * @throws AdapterException
	 *             thrown when task's logic validations doesn't pass
	 */
	TaskResponseType executeTask(TaskRequestType taskType)
			throws AdapterException;

}