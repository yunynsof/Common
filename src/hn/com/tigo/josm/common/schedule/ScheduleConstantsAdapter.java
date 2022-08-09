/**
 * ScheduleConstantsAdapter.java
 * ScheduleAdapter
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.schedule;

/**
 * Interface that contains the constants of the adapter for the component
 * ScheduleAdapter.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 1/09/2015 11:51:01 AM 2015
 */
public interface ScheduleConstantsAdapter {

	String ATTRIBUTE_MSISDN = "MSISDN";

	String ATTRIBUTE_TASKID = "TASKID";

	String ATTRIBUTE_SCHEDULETYPE = "SCHEDULETYPE";

	String ATTRIBUTE_SCHEDULEDATE = "SCHEDULEDATE";

	String ATTRIBUTE_RECURRENT = "RECURRENT";

	String ATTRIBUTE_CRONEXPR = "CRONEXPR";

	String ATTRIBUTE_CHANNELID = "CHANNELID";

	String ATTRIBUTE_SUBSCRIBERID = "SUBSCRIBERID";

	String ATTRIBUTE_PRODUCTID = "PRODUCTID";

	String ATTRIBUTE_QUANTITY = "QUANTITY";

	String ATTRIBUTE_EXTERNALTRANSACTIONID = "EXTERNALTRANSACTIONID";

	String ATTRIBUTE_COMMENT = "COMMENT";

	String ATTRIBUTE_NEWSCHEDULEDATE = "NEWSCHEDULEDATE";

	String ATTRIBUTE_SCHEDULEID = "SCHEDULEID";

	String ATTRIBUTE_WIPEOUT = "WIPEOUT";

	String ATTRIBUTE_NAME = "NAME";

	String ATTRIBUTE_DESCRIPTION = "DESCRIPTION";

	String ATTRIBUTE_WSDL = "WSDL";

	String ATTRIBUTE_OPERATIONID = "OPERATIONID";

	String ATTRIBUTE_THRESHOLD = "THRESHOLD";

	String ATTRIBUTE_RETURN_VALUE = "RETURN_VALUE";
	
	String ATTRIBUTE_STATE = "STATE";
	
	String ATTRIBUTE_CREATIONDATE = "CREATION_DATE";
	
	/**
	 * The Constant that determine the JNDI of the scheduler service.
	 */
	String SCHEDULER_JNDI = "java:global.SchedulerEAR.Scheduler.Scheduler!hn.com.tigo.josm.common.interfaces.IScheduler";
	
	String UNDERSCORE = "_";
	
	String ADICIONAL = "ADICIONAL";
	
	String META = "META_";

	String DEACTIVE = "0";

	String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";

	String ERRORS_ALLOW = "ERRORS_ALLOW";

}
