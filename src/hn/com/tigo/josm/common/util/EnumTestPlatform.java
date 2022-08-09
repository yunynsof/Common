package hn.com.tigo.josm.common.util;

public enum EnumTestPlatform {

	/** Constant that defines P_JOSM_JPA. */
	P_JOSM_JPA("PLATFORM_MAPPING_DS", EnumTestPlatform.C_P_JOSM_JPA),

	/** Constant that defines P_JOSM_JPA_JTA_MANAGED. */
	P_JOSM_JPA_JTA_MANAGED("PLATFORM_MAPPING_DS.JtaManaged", EnumTestPlatform.C_P_JOSM_JPA_JTA_MANAGED),

	/** Constant that defines P_JOSM_JPA_USER_NAME. */
	P_JOSM_JPA_USER_NAME("PLATFORM_MAPPING_DS.UserName", EnumTestPlatform.C_P_JOSM_JPA_USER_NAME),

	/** Constant that defines P_JOSM_JPA_PASSWORD. */
	P_JOSM_JPA_PASSWORD("PLATFORM_MAPPING_DS.Password", EnumTestPlatform.C_P_JOSM_JPA_PASSWORD),

	/** Constant that defines P_JOSM_JPA_JDBC_URL. */
	P_JOSM_JPA_JDBC_URL("PLATFORM_MAPPING_DS.JdbcUrl", EnumTestPlatform.C_P_JOSM_JPA_JDBC_URL),

	/** Constant that defines P_JOSM_JPA_JDBC_DRIVER. */
	P_JOSM_JPA_JDBC_DRIVER("PLATFORM_MAPPING_DS.JdbcDriver", EnumTestPlatform.C_P_JOSM_JPA_JDBC_DRIVER);

	/* /** Attribute that determine action. */
	/** Attribute that determine _key. */
	private String _key;

	/* /** Attribute that determine action. */

	/** Attribute that determine _value. */
	private String _value;

	/** Constant that defines C_P_JOSM_JPA. */
	private static final String C_P_JOSM_JPA = "new://Resource?type=DataSource";

	/** Constant that defines C_P_JOSM_JPA_JTA_MANAGED. */
	private static final String C_P_JOSM_JPA_JTA_MANAGED = "true";

	/** Constant that defines C_P_JOSM_JPA_USER_NAME. */
	private static final String C_P_JOSM_JPA_USER_NAME = "PlatformMapping";

	/** Constant that defines C_P_JOSM_JPA_PASSWORD. */
	private static final String C_P_JOSM_JPA_PASSWORD = "Tigo2014";

	/** Constant that defines C_P_JOSM_JPA_JDBC_URL. */
	private static final String C_P_JOSM_JPA_JDBC_URL = "jdbc:oracle:thin:@192.168.159.52:1521/josmdb.celtel.net";

	/** Constant that defines C_P_JOSM_JPA_JDBC_DRIVER. */
	private static final String C_P_JOSM_JPA_JDBC_DRIVER = "oracle.jdbc.OracleDriver";

	/**
	 * Instantiates a new enum action.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private EnumTestPlatform(final String key, final String value) {
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
