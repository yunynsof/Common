package hn.com.tigo.josm.common.util;

/**
 * The Enum EnumResponseDmsAdapter.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version
 * @since 3/03/2015 05:24:39 PM 2015
 */
public enum EnumResponseXpathAdapter {

	/** The RESPONS e_0. */
	RESPONSE_SUCCESS(0, "Success"),

	/** The RESPONS e_1. */
	RESPONSE_NO_DATA(1, "No data"),

	/** The RESPONS e_1. */
	RESPONSE_NO_RESPONSE(2, "There is not response tag");

	/** The _key. */
	private int _key;

	/** The _value. */
	private String _value;

	/**
	 * Instantiates a new enum action.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private EnumResponseXpathAdapter(final int key, final String value) {
		this._key = key;
		this._value = value;
	}

	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public int getKey() {
		return this._key;
	}

	/**
	 * Gets the values.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return this._value;
	}

}
