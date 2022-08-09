/**
 * AdapterBpmFileVersion.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * AdapterBpmFileVersion.
 *
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version 
 * @since 22-dic-2014 17:49:17 2014
 */
public class AdapterBpmFileVersion {
	
	/** Attribute that determine key. */
	private long _key ;
	
	/** Attribute that determine sKey. */
	private String _sKey;
	
	/** Attribute that determine value. */
	private String _value;
	
	/** The name. */
	private String _name;

	/**
	 * Instantiates a new adapter bpm file version.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public AdapterBpmFileVersion(final long key, final String value,final String name) {
		super();
		this._key = key;
		this._value = value.toString();
		this._sKey = String.valueOf(key);
		this._name = name;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public long getKey() {
		return _key;
	}
	
	/**
	 * Gets the s key.
	 *
	 * @return the s key
	 */
	public String getsKey() {
		return _sKey;
	}


	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return _value;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this._name = name;
	}

}
