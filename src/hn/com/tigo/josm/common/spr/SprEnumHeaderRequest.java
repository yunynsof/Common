package hn.com.tigo.josm.common.spr;


/**
 * SprEnumHeaderRequest.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 26/11/2015 08:33:02 AM 2015
 */
public enum SprEnumHeaderRequest {

	/** Constant that defines P_JOSM_JPA. */
	CONTEN_TYPE_TEXT("Content-Type", "text/xml; charset=utf-8"),
	
	/** The conten type camiant. */
	CONTEN_TYPE_CAMIANT("Content-Type", "application/camiant-msr-v1+xml"),
	
	/** The soap action empty. */
	SOAP_ACTION_EMPTY("SOAPAction", ""),
	
	/** The content type. */
	CONTENT_TYPE("Content-Type", "text/xml; charset=utf-8"),
	
	/** The connection keep alive. */
	CONNECTION_KEEP_ALIVE("Connection", "keep-alive"),
	
	/** The conten length. */
	CONTEN_LENGTH("Content-Length", ""),
	
	/** The accep encoding. */
	ACCEP_ENCODING("Accept-Encoding", "gzip,deflate"),
	
	/** The user agent. */
	USER_AGENT("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)"),
	
	/** The host. */
	HOST("Host", "");
	
	
	/* /** Attribute that determine action. */
	/** Attribute that determine _key. */
	private String _key;

	/* /** Attribute that determine action. */

	/** Attribute that determine _value. */
	private String _value;

	
	/**
	 * Instantiates a new enum action.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private SprEnumHeaderRequest(final String key, final String value) {
		this._key = key;
		this._value = value;
	}

	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public String getKey() {
		return this._key;
	}

	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public String getValue() {
		return this._value;
	}

}
