package hn.com.tigo.josm.common.interfaces;

import javax.ejb.Local;

/**
 * CrudServiceAsyncLocal.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 8/05/2015 11:58:02 AM 2015
 */
@Local
public interface CrudServiceAsyncLocal {
	
	/**
	 * Asynchronous creates a entity.
	 *
	 * @param <T> the generic type
	 * @param t the t
	 */
	public <T> void createAsync(final T t);

	/**
	 * Creates the async header.
	 *
	 * @param <T> the generic type
	 * @param t the t
	 */
	public  <T> void createAsyncHeader(T t);
		
}
