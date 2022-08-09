/**
 * ScheduleCacheException.java
 * SchedulerThread
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.exceptions;

/**
 * ScheduleCacheException.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 11/08/2015 09:52:17 AM 2015
 */
public class ScheduleCacheException extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 5945805063972080007L;

	/**
	 * Instantiates a new schedule cache exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ScheduleCacheException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new schedule cache exception.
	 *
	 * @param message the message
	 */
	public ScheduleCacheException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new schedule cache exception.
	 *
	 * @param cause the cause
	 */
	public ScheduleCacheException(final Throwable cause) {
		super(cause);
	}

}
