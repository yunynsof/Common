/**
 * Closeable.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

/**
 * Closeable.
 * 
 * Interface that allows implements a close connection method.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 18/06/2015 15:02:56
 */
public interface Closeable {
	
	/**
	 * Close connection.
	 *
	 * @return true, if successful
	 */
	boolean closeConnection();

}
