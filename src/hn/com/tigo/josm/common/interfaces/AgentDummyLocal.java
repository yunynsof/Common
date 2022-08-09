/**
 * AgentDummyLocal.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import javax.ejb.Local;


/**
 * AgentDummyLocal.
 * Local interfaces for an agent dummy
 *
 * @author Juan Pablo Gomez<mailto:jgomezg@stefaninicolombia.com />
 * @version 
 * @since 25/11/2014 12:19:46 PM 2014
 */
@Local
public interface AgentDummyLocal {
	
	/**
	 * Agent execution.
	 *
	 * @return the code of the agent execution
	 */
	public int agentExecution();

}
