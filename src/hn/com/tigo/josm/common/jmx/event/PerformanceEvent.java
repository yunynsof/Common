package hn.com.tigo.josm.common.jmx.event;

import hn.com.tigo.josm.common.dto.JOSMEvent;

import java.io.Serializable;

/**
 * PerformanceEvent.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 8/05/2015 06:01:36 PM 2015
 */
public class PerformanceEvent extends JOSMEvent implements Serializable {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 95424239562783130L;

	/** Attribute that stores the flag sucess event. */
	private boolean _sucess;

	/** Attribute that stores the _transactionInMillis. */
	private long _transactionInMillis;
	
	
	/**
	 * Instantiates a new performance event.
	 */
	public PerformanceEvent(){
		super(MonitoringEventType.PERFORMANCE);
	}
	
	
	/**
	 * Instantiates a new performance event.
	 *
	 * @param mxBeanType the mx bean type
	 */
	public PerformanceEvent(final MXBeanType mxBeanType){
		super(MonitoringEventType.PERFORMANCE, mxBeanType);
	}
	
	
	
	
	/**
	 * Sets the result of the event.
	 *
	 * @param sucess the sucess
	 * @param transactionInMillis the transaction in millis
	 */
	public void setResult(final boolean sucess, final long transactionInMillis){
		this.setSucess(sucess);
		this.setTransactionInMillis(transactionInMillis);
	}
	
	/**
	 * Gets the transaction in millis.
	 *
	 * @return the transaction in millis
	 */
	public long getTransactionInMillis() {
		return _transactionInMillis;
	}

	/**
	 * Sets the transaction in millis.
	 *
	 * @param transactionInMillis the new transaction in millis
	 */
	public void setTransactionInMillis(final long transactionInMillis) {
		this._transactionInMillis = transactionInMillis;
	}

	/**
	 * Checks if is sucess.
	 *
	 * @return true, if is sucess
	 */
	public boolean isSucess() {
		return _sucess;
	}

	/**
	 * Sets the sucess.
	 *
	 * @param sucess the new sucess
	 */
	public void setSucess(final boolean sucess) {
		this._sucess = sucess;
	}

}
