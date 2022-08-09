package hn.com.tigo.josm.common.data;

import hn.com.tigo.josm.common.interfaces.CrudServiceLocal;
import hn.com.tigo.josm.common.interfaces.CrudServiceRemote;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * The AbstractCrudService class is responsible to transfer data between application and data base.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0
 * @since 5/05/2015 05:41:08 PM 2015
 */
public abstract class AbstractCrudService implements CrudServiceLocal, CrudServiceRemote{


	/**
	 * Method responsible to persist the entity into database.
	 *
	 * @param <T> the generic type
	 * @param t the t
	 * @return the t
	 */
	public <T> T create(final T t) {
		final EntityManager em = getEntityManager(); 
		em.persist(t);
		em.flush();
		return t;
	}

	/**
	 * Method responsible to find the entity into database.
	 *
	 * @param <T> the generic type
	 * @param id the id
	 * @param type the type
	 * @return the t
	 */
	public <T, S> T find(final S id, final Class<T> type) {
		return (T) getEntityManager().find(type, id);
	}

	/**
	 * Method responsible to delete the entity into database.
	 *
	 * @param <T> the generic type
	 * @param id the id
	 * @param type the type
	 */
	public <T, S> void delete(final S id, final Class<T> type) {
		final Object reference = getEntityManager().getReference(type, id);
		getEntityManager().remove(reference);
	}

	/**
	 * Method responsible to update the entity into database.
	 *
	 * @param <T> the generic type
	 * @param t the t
	 * @return the t
	 */
	public <T> T update(final T t) {
		return (T) getEntityManager().merge(t);
	}

	/**
	 * Find by named query.
	 *
	 * @param namedQueryName the named query name
	 * @return the list
	 */
	public List findByNamedQuery(final String namedQueryName) {
		return getEntityManager().createNamedQuery(namedQueryName).getResultList();
	}

	/**
	 * Find by named query.
	 *
	 * @param namedQueryName the named query name
	 * @param parameters the parameters
	 * @return the list
	 */
	public List findByNamedQuery(final String namedQueryName, final Map<String, Object> parameters) {
		return findByNamedQuery(namedQueryName, parameters, 0);
	}

	/**
	 * Find by named query.
	 *
	 * @param namedQueryName the named query name
	 * @param resultLimit the result limit
	 * @return the list
	 */
	public List findByNamedQuery(final String namedQueryName, final int resultLimit) {
		return getEntityManager().createNamedQuery(namedQueryName).setMaxResults(resultLimit).getResultList();
	}

	/**
	 * Find by named query.
	 *
	 * @param namedQueryName the named query name
	 * @param parameters the parameters
	 * @param resultLimit the result limit
	 * @return the list
	 */
	public List findByNamedQuery(final String namedQueryName, final Map<String, Object> parameters,
			final int resultLimit) {
		final Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = getEntityManager().createNamedQuery(namedQueryName);
		if (resultLimit > 0) {
			query.setMaxResults(resultLimit);
		}
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	/**
	 * Method that creates the query.
	 *
	 * @param namedQueryName the named query name
	 * @param parameters the parameters
	 * @param resultLimit the result limit
	 * @return the list
	 */
	public List<Object> createQuery(final String namedQueryName, final Map<String, Object> parameters,
			final int resultLimit) {

		final Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = getEntityManager().createQuery(namedQueryName);
		if (resultLimit > 0) {
			query.setMaxResults(resultLimit);
		}
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	/**
	 * Method responsible to count entities by named query.
	 *
	 * @param namedQueryName the named query name
	 * @return the long
	 */
	public long countByNamedQuery(final String namedQueryName) {
		return ((Long) getEntityManager().createNamedQuery(namedQueryName).getSingleResult()).longValue();
	}

	
	/**
	 * Method responsible to count entities by named query.
	 *
	 * @param namedQueryName the named query name
	 * @param parameters the parameters
	 * @return the long
	 */
	public long countByNamedQuery(final String namedQueryName, final Map<String, Object> parameters) {
		final Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = getEntityManager().createNamedQuery(namedQueryName);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return ((Long) query.getSingleResult()).longValue();
	}

	/**
	 * Method responsible to creates the native query.
	 *
	 * @param nativeQueryName the native query name
	 */
	public void createNativeQuery(final String nativeQueryName) {
		try {
			final EntityManager em = getEntityManager();
			em.createNativeQuery(nativeQueryName).executeUpdate();
			em.flush();
		} catch (PersistenceException e) {

		}
	}
	
	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public abstract EntityManager getEntityManager();
}
