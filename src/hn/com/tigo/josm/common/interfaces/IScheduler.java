/**
 * IScheduler.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.scheduler.orders.RescheduleRequest;
import hn.com.tigo.josm.scheduler.orders.RmvScheduleRequest;
import hn.com.tigo.josm.scheduler.orders.ScheduleComplexRequest;
import hn.com.tigo.josm.scheduler.orders.ScheduleExecuteRequest;
import hn.com.tigo.josm.scheduler.orders.ScheduleRequest;
import hn.com.tigo.josm.scheduler.orders.ScheduleResponse;
import hn.com.tigo.josm.scheduler.orders.ScheduleSimpleRequest;
import hn.com.tigo.josm.scheduler.orders.ScheduleTypeRequest;
import hn.com.tigo.josm.scheduler.orders.ScheduleWithOutScheduleTypeList;
import hn.com.tigo.josm.scheduler.orders.ServiceRequest;
import hn.com.tigo.josm.scheduler.orders.TaskRequest;
import hn.com.tigo.josm.scheduler.orders.UpdateCronExpressionRequest;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * IScheduler.
 *
 * @author hnolasco
 */
@Remote
@WebService(name = "IScheduler", targetNamespace = "http://tigo.com.hn/josm/common/interfaces/Scheduler/V1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface IScheduler {

	/**
	 * WebMethod that is responsible of creating a new schedule task with a
	 * simple order request.
	 *
	 * @param scheduleSimpleRequest the schedule simple request
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse addScheduleSimpleTask(ScheduleSimpleRequest scheduleSimpleRequest);

	/**
	 * WebMethod that is responsible of creating a new schedule task.
	 * 
	 * @param request
	 *            object ScheduleRequest that contains the properties necessary
	 *            to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse addScheduleComplexTask(ScheduleComplexRequest request);

	/**
	 * WebMethod that is responsible of removing a particular scheduled task or
	 * a set of them.
	 * 
	 * @param request
	 *            object RmvScheduleRequest that contains the properties
	 *            necessary to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse removeScheduleTask(RmvScheduleRequest request);

	/**
	 * WebMethod that is responsible of rescheduling a previous created set of
	 * schedules.
	 * 
	 * @param request
	 *            object RescheduleRequest that contains the properties
	 *            necessary to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse reScheduleTask(RescheduleRequest request);

	/**
	 * WebMethod that is responsible of creating a new task that will eventually
	 * be scheduled to be executed.
	 * 
	 * @param request
	 *            object TaskRequest that contains the properties necessary to
	 *            execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse addTask(TaskRequest request);

	/**
	 * WebMethod that is responsible of creating a new type of schedule.
	 * 
	 * @param request
	 *            object ScheduleTypeRequest that contains the properties
	 *            necessary to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse addScheduleType(ScheduleTypeRequest request);

	/**
	 * WebMethod that is responsible of creating the configuration of the
	 * services to be executed by the scheduler.
	 * 
	 * @param request
	 *            object ServiceRequest that contains the properties necessary
	 *            to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse addService(ServiceRequest request);

	/**
	 * WebMethod that is responsible of obtain the scheduled date for a specific
	 * task.
	 * 
	 * @param request
	 *            object ScheduleTypeRequest that contains the properties
	 *            necessary to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse getNextExecution(ScheduleExecuteRequest request);

	/**
	 * WebMethod in charge of pushing the task for the next run according to the
	 * configured cron expression.
	 * 
	 * @param request
	 *            object ScheduleTypeRequest that contains the properties
	 *            necessary to execute the method.
	 * @return ScheduleResponse is an object of the response that contains code,
	 *         description and return value attributes.
	 */
	ScheduleResponse pushNextExecution(ScheduleExecuteRequest request);

	/**
	 * Checks for queue tasks.
	 *
	 * @param request the request
	 * @return the schedule response
	 */
	ScheduleResponse hasQueueTasks(ScheduleRequest request);

	/**
	 * WebMethod that is responsible of get the pending scheduled tasks by type.
	 *
	 * @param subscriberId
	 *            the subscriber id
	 * @param scheduleType
	 *            the schedule type
	 * @return the schedule by type
	 */
	@WebMethod(operationName = "getScheduleByType")
	ScheduleWithOutScheduleTypeList getScheduleByType(@WebParam(name = "subscriberId") String subscriberId,
			@WebParam(name = "scheduleType") long scheduleType);

	/**
	 * WebMethod that is responsible of execute the next task by subscriber id
	 * and schedule type.
	 *
	 * @param subscriberId
	 *            the subscriber id
	 * @param scheduleType
	 *            the schedule type
	 *            
	 * @return the schedule response
	 */
	@WebMethod(operationName = "executeNextTask")
	ScheduleResponse executeNextTask(@WebParam(name = "subscriberId") String subscriberId,
			@WebParam(name = "scheduleType") long scheduleType);

	/**
	 * WebMethod that is responsible of change the subscriber number.
	 *
	 * @param currentSubscriber
	 *            the current subscriber
	 * @param newSubscriber
	 *            the new subscriber
	 * @return the schedule response
	 */
	@WebMethod(operationName = "changeNumberSubscriber")
	ScheduleResponse changeNumberSubscriber(@WebParam(name = "currentSubscriber") String currentSubscriber,
			@WebParam(name = "newSubscriber") String newSubscriber);

	/**
	 * that is responsible of update the cron expression.
	 *
	 * @param scheduleId
	 *            the schedule id
	 * @param subscriberId
	 *            the subscriber id
	 * @param cronExpression
	 *            the cron expression
	 * @return the schedule response
	 */
	@WebMethod(operationName = "updateCronExpression")
	public ScheduleResponse updateCronExpression(final UpdateCronExpressionRequest request);
	
	/**
	 * This web operation gets all pending task from a client of a schedule type.
	 * 
	 * @param subscriberId represents the ID of a subscriber.
	 * @param scheduleType represents the type of a schedule.
	 * @return a JSON list of all pending task of that subscriber and that type of schedule.
	 */
	@WebMethod(operationName = "getScheduleByTypeJson")
	ScheduleResponse getScheduleByTypeJson(@WebParam(name = "subscriberId") String subscriberId,
			@WebParam(name = "scheduleType") long scheduleType);

}
