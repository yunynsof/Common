/**
 * EnumTest.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * EnumTest.
 * This enum defines the tests properties used by all JOSM tests
 * 
 * @author Juan Pablo Gomez<mailto:jgomezg@stefaninicolombia.com />
 * @version
 * @since 27/10/2014 09:25:02 AM 2014
 */
public enum EnumTest {

	/** Constant that defines P_JOSM_JPA. */
	P_JOSM_JPA("JOSM_DS", EnumTest.C_P_JOSM_JPA),

	/** Constant that defines P_JOSM_JPA_JTA_MANAGED. */
	P_JOSM_JPA_JTA_MANAGED("JOSM_DS.JtaManaged",
			EnumTest.C_P_JOSM_JPA_JTA_MANAGED),

	/** Constant that defines P_JOSM_JPA_USER_NAME. */
	P_JOSM_JPA_USER_NAME("JOSM_DS.UserName", EnumTest.C_P_JOSM_JPA_USER_NAME),

	/** Constant that defines P_JOSM_JPA_PASSWORD. */
	P_JOSM_JPA_PASSWORD("JOSM_DS.Password", EnumTest.C_P_JOSM_JPA_PASSWORD),

	/** Constant that defines P_JOSM_JPA_JDBC_URL. */
	P_JOSM_JPA_JDBC_URL("JOSM_DS.JdbcUrl", EnumTest.C_P_JOSM_JPA_JDBC_URL),

	/** Constant that defines P_JOSM_JPA_JDBC_DRIVER. */
	P_JOSM_JPA_JDBC_DRIVER("JOSM_DS.JdbcDriver",
			EnumTest.C_P_JOSM_JPA_JDBC_DRIVER),
			
	P_MS_JPA("MS_DS", "new://Resource?type=DataSource"),

	P_MS_JPA_JTA_MANAGED("MS_DS.JtaManaged",
			"true"),

	P_MS_JPA_USER_NAME("MS_DS.UserName", "MASTER_STATUS"),

	P_MS_JPA_PASSWORD("MS_DS.Password", "Tigo2015"),

	P_MS_JPA_JDBC_URL("MS_DS.JdbcUrl", "jdbc:oracle:thin:@192.168.159.52:1521/josmdb.celtel.net"),

	P_MS_JPA_JDBC_DRIVER("MS_DS.JdbcDriver", "oracle.jdbc.OracleDriver"),
			
	/** Attribute that determine P_OPENEJB_EMBEDDED_REMOTABLE. */
	P_OPENEJB_EMBEDDED_REMOTABLE("openejb.embedded.remotable", "true"),
	
	/** Attribute that determine P_OPENEJB_LOCALCOPY. */
	P_OPENEJB_LOCALCOPY("openejb.localcopy", "false");

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
	private static final String C_P_JOSM_JPA_USER_NAME = "josm";

	/** Constant that defines C_P_JOSM_JPA_PASSWORD. */
	private static final String C_P_JOSM_JPA_PASSWORD = "j0sM";

	/** Constant that defines C_P_JOSM_JPA_JDBC_URL. */
	private static final String C_P_JOSM_JPA_JDBC_URL ="jdbc:oracle:thin:@192.168.159.52:1521/josmdb.celtel.net"; //"jdbc:oracle:thin:@192.168.160.91:1503/cpe3dbSHARED.celtel.net";

	/** Constant that defines C_P_JOSM_JPA_JDBC_DRIVER. */
	private static final String C_P_JOSM_JPA_JDBC_DRIVER = "oracle.jdbc.OracleDriver";

	/**
	 * Instantiates a new enum action.
	 *
	 * @param key the key
	 * @param value the value
	 */
	private EnumTest(final String key, final String value) {
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
