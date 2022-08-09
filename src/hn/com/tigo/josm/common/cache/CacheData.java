package hn.com.tigo.josm.common.cache;

import java.util.Calendar;

/**
 * CacheData.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @param <T> the generic type
 * @since 06-01-2015 09:41:57 AM 2015
 */
public class CacheData<T> {
	
	/** The _data. */
	private T _data;
	
	/** The _expiration date time. */
	private Calendar _expirationDateTime;
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return _data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(final T data) {
		this._data = data;
	}
	
	/**
	 * Gets the expiration date time.
	 *
	 * @return the expiration date time
	 */
	public Calendar getExpirationDateTime() {
		return _expirationDateTime;
	}
	
	/**
	 * Sets the expiration date time.
	 *
	 * @param _expirationDateTime the new expiration date time
	 */
	public void setExpirationDateTime(final Calendar _expirationDateTime) {
		this._expirationDateTime = _expirationDateTime;
	}


}
