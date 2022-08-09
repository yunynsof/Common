/**
 * HssSession.java
 * LTE-EJB
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.adapter;

import java.util.Date;


/**
 * AdapterSession.
 * General class that defines session parameters
 *
 * @author Andres Hinestroza <afhinestroza@stefanini.com>
 * @version 
 * @see 
 * @since 08-oct-2014 17:16:14 2014
 */
public abstract class AdapterSession {
	
	/** The _last exec. */
	protected Date _lastExec;
	
	/** Attribute that determine _sessionId. */
	protected String _sessionId; 
	
	/**
	 * Gets the _last exec.
	 *
	 * @return the _last exec
	 */
	public Date getLastExec() {
		return _lastExec;
	}

	/**
	 * Sets the _last exec.
	 *
	 * @param lastExec the new _last exec
	 */
	public void setLastExec(final Date lastExec) {
		this._lastExec = lastExec;
	}
	
	/**
	 * Gets the session id.
	 *
	 * @return the session id
	 */
	public String getSessionId() {
		return _sessionId;
	}

	/**
	 * Sets the session id.
	 *
	 * @param sessionId the new session id
	 */
	public void setSessionId(final String sessionId) {
		this._sessionId = sessionId;
	}
	
	/**
	 * Method that reserve the session.
	 */
	public synchronized void updateLastExec() {
		this.setLastExec(new Date());
	}
	
	
}
