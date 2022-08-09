/**
 * EnumStatus.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * EnumStatus.
 *
 * @author Alexis Berrio
 * @version 1.0
 * @since 28/01/2015 09:26:02 AM 2015
 */
public enum EnumStatus {
	
	
	/** Attribute that determine PENDING. */
	PENDING("PENDING"), 
	
	/** Attribute that determine EXECUTION. */
	EXECUTION("EXECUTION"),
	
	/** Attribute that determine SUCCESSFUL. */
	SUCCESSFUL("SUCCESSFUL"),
	
	/** Attribute that determine FAILED. */
	FAILED("FAILED"),
	
	/** Attribute that determine RESCHEDULED. */
	RESCHEDULED("RESCHEDULED");
	
	/** Attribute that determine name. */
	private String name;

	/**
	 * Instantiates a new enum status.
	 *
	 * @param name the name
	 */
	private EnumStatus(final String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
