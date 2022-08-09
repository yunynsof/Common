/**
 * CrudServiceRemote.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

/**
 * MasterStatusDataRemote.
 * 
 * @author Harold Castillo
 * @version 1.0
 * @since 23/04/2015 16:42:02
 */
@Remote
public interface MasterStatusDataRemote {

	/**
	 * Method that allow creates a record.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param t
	 *            the generic entity
	 * @return the the generic type
	 */
	<T> T create(T entity);

	/**
	 * Method that allow updates a record..
	 * 
	 * @param <T>
	 *            the generic type
	 * @param t
	 *            the t
	 * @return the t
	 */
	<T> T update(T t);

	/**
	 * Find a record of a entity by id.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param id
	 *            the id of the entity
	 * @param type
	 *            the entity
	 * @return the t
	 */
	<T> T find(Object id, Class<T> type);

	/**
	 * Find by named query.
	 * 
	 * @param namedQueryName
	 *            the named query name
	 * @param parameters
	 *            the parameters
	 * @return the list
	 */
	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters);

	/**
	 * Find by named query with a result limit.
	 * 
	 * @param namedQueryName
	 *            the named query name
	 * @param parameters
	 *            the parameters
	 * @param resultLimit
	 *            the result limit
	 * @return the list
	 */
	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit);

	/**
	 * Find native query.
	 * 
	 * @param namedQueryName
	 *            the named query name
	 * @param parameters
	 *            the parameters
	 * @param resultLimit
	 *            the result limit
	 * @return the list
	 */
	@SuppressWarnings("rawtypes")
	List findByNativeQuery(String namedQueryName, Map<String, Object> parameters);

}
