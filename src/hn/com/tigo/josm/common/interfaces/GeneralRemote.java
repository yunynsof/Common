/**
 * GeneralRemote.java
 * Broker
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import javax.ejb.Remote;

/**
 * GeneralRemote.
 *  General interfaces exposed for remote use.
 * @author Harold Castillo <mailto:hjobando@stefanini.com />
 * @version 1.0
 * @since 10/11/2014 04:23:44 PM 2014
 */
@Remote
public interface GeneralRemote {

	/**
	 * Initialize a instance of a entity.
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the t
	 */
	<T> T initialize(final T entity);

}
