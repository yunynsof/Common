package hn.com.tigo.josm.common.cache;

import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.io.IOException;
import java.util.Calendar;

import javax.xml.bind.JAXBException;

/**
 * Class that allows to manage the cache of generic types objects.
 *
 * @author Harold Castillo
 * @version 1.1
 * @param <T> the generic type object.
 * @param <E> the element type exception.
 * @since 12/02/2016 10:11:40 AM
 */
public abstract class Cache<T, E extends Exception> {
	
	/** The cache expiration. */
	protected Calendar cacheExpiration;
	
	/** The file path. */
	protected String path;
	
	/** The expiration time. */
	protected int expiration;
	
	/** The data response. */
	protected T data;
	
	/**
	 * Instantiates a new cache.
	 */
	protected Cache() {
		
	}
	
	/**
	 * Instantiates a new cache.
	 *
	 * @param path the path
	 */
	protected Cache(final String path) {
		this.path = path;
	}

	/**
	 * Instantiates a new cache.
	 *
	 * @param expiration the expiration
	 * @param path the path
	 */
	protected Cache(final int expiration, final String path) {
		this.path = path;
		this.expiration = expiration;
	}

	/**
	 * Loads the data of the current cache.
	 *
	 * @return the t
	 * @throws E the e
	 */
	protected abstract T loadData() throws E;

	/**
	 * Retrieve configuration type cache.
	 *
	 * @return the update data type
	 * @throws E the generic exception
	 */
	public T retrieve() throws E {
		
		if (this.cacheExpiration == null
				|| this.cacheExpiration.before(Calendar.getInstance())) {
			this.data = loadData();
			this.cacheExpiration = Calendar.getInstance();
			this.cacheExpiration.add(Calendar.MILLISECOND, this.expiration);
		}
		
		return data;
	}

	/**
	 * Gets the configuration.
	 *
	 * @return the remote bean configuration
	 * @throws ServiceLocatorException the service locator exception
	 * @throws JAXBException the JAXB exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected ConfigurationJosmRemote getConfiguration() throws ServiceLocatorException,
			JAXBException, IOException {

		final InterfaceFactory interfaceFactory = new InterfaceFactory();
		final ConfigurationJosmRemote configurationJosmRemote = interfaceFactory.getCommonConfiguration();

		return configurationJosmRemote;
	}

	/**
	 * Checks if is expired.
	 *
	 * @return true, if is expired
	 */
	public boolean isExpired() {

		boolean state = false;

		if (this.cacheExpiration == null
				|| this.cacheExpiration.before(Calendar.getInstance())) {
			this.cacheExpiration = Calendar.getInstance();
			this.cacheExpiration.add(Calendar.MILLISECOND, this.expiration);

			state = true;
		}

		return state;
	}

	/**
	 * Reset the cache configuration time.
	 */
	public void reset() {
		this.cacheExpiration = Calendar.getInstance();
	}

	/**
	 * Gets the cache expiration.
	 *
	 * @return the cache expiration
	 */
	public Calendar getCacheExpiration() {
		return this.cacheExpiration;
	}

}
