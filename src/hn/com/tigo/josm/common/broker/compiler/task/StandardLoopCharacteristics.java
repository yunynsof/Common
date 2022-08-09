/**
 * StandardLoopCharacteristics.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.broker.compiler.task;


/**
 * StandardLoopCharacteristics. 
 * This class defines the task loop characteristics.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 19/03/2015 06:02:13 PM 2015
 */
public class StandardLoopCharacteristics {
	
	/** Attribute that determine _loopCondition. */
	private String _loopCondition;
	
	/** Attribute that determine _testBefore. */
	private boolean _testBefore;
	
	/** Attribute that determine _loopMaximum. */
	private long _loopMaximum;
    
    /**
     * Instantiates a new standard loop characteristics.
     */
    public StandardLoopCharacteristics(){
    	
    }
    
	/**
	 * Gets the loop condition.
	 *
	 * @return the loop condition
	 */
	public String getLoopCondition() {
		return _loopCondition;
	}
	
	/**
	 * Sets the loop condition.
	 *
	 * @param loopCondition the new loop condition
	 */
	public void setLoopCondition(String loopCondition) {
		this._loopCondition = loopCondition;
	}
	
	/**
	 * Checks if is test before.
	 *
	 * @return true, if is test before
	 */
	public boolean isTestBefore() {
		return _testBefore;
	}
	
	/**
	 * Sets the test before.
	 *
	 * @param testBefore the new test before
	 */
	public void setTestBefore(boolean testBefore) {
		this._testBefore = testBefore;
	}
	
	/**
	 * Gets the loop maximum.
	 *
	 * @return the loop maximum
	 */
	public long getLoopMaximum() {
		return _loopMaximum;
	}
	
	/**
	 * Sets the loop maximum.
	 *
	 * @param loopMaximum the new loop maximum
	 */
	public void setLoopMaximum(long loopMaximum) {
		this._loopMaximum = loopMaximum;
	}
    
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("loopCondition: "+ _loopCondition);
		s.append("\ntestBefore: "+ _testBefore);
		s.append("\nloopMaximum: "+ _loopMaximum);
		
		return s.toString();
	}

    

}
