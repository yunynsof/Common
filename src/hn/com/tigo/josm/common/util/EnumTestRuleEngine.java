package hn.com.tigo.josm.common.util;

/**
 * The EnumTestRuleEngine enumeration is a component responsible to set the
 * database connection parameters.
 * 
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0
 * @since 28/07/2015 02:45:55 PM 2015
 */
public enum EnumTestRuleEngine {
	/** Constant that defines P_JOSM_JPA. */
	P_JOSM_RULE_ENGINE_JPA("JOSM_RULE_ENGINE_DS", EnumTestRuleEngine.C_P_JOSM_RULE_ENGINE_JPA),

	/** Constant that defines P_JOSM_JPA_JTA_MANAGED. */
	P_JOSM_RULE_ENGINE_JPA_JTA_MANAGED("JOSM_RULE_ENGINE_DS.JtaManaged",
			EnumTestRuleEngine.C_P_JOSM_RULE_ENGINE_JPA_JTA_MANAGED),

	/** Constant that defines P_JOSM_JPA_USER_NAME. */
	P_JOSM_RULE_ENGINE_JPA_USER_NAME("JOSM_RULE_ENGINE_DS.UserName", EnumTestRuleEngine.C_P_JOSM_RULE_ENGINE_JPA_USER_NAME),

	/** Constant that defines P_JOSM_JPA_PASSWORD. */
	P_JOSM_RULE_ENGINE_JPA_PASSWORD("JOSM_RULE_ENGINE_DS.Password", EnumTestRuleEngine.C_P_JOSM_RULE_ENGINE_JPA_PASSWORD),

	/** Constant that defines P_JOSM_JPA_JDBC_URL. */
	P_JOSM_RULE_ENGINE_JPA_JDBC_URL("JOSM_RULE_ENGINE_DS.JdbcUrl", EnumTestRuleEngine.C_P_JOSM_RULE_ENGINE_JPA_JDBC_URL),

	/** Constant that defines P_JOSM_JPA_JDBC_DRIVER. */
	P_JOSM_RULE_ENGINE_JPA_JDBC_DRIVER("JOSM_RULE_ENGINE_DS.JdbcDriver",
			EnumTestRuleEngine.C_P_JOSM_RULE_ENGINE_JPA_JDBC_DRIVER),
			
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
	private static final String C_P_JOSM_RULE_ENGINE_JPA = "new://Resource?type=DataSource";

	/** Constant that defines C_P_JOSM_JPA_JTA_MANAGED. */
	private static final String C_P_JOSM_RULE_ENGINE_JPA_JTA_MANAGED = "true";

	/** Constant that defines C_P_JOSM_JPA_USER_NAME. */
	private static final String C_P_JOSM_RULE_ENGINE_JPA_USER_NAME = "JOSM_RULES";

	/** Constant that defines C_P_JOSM_JPA_PASSWORD. */
	private static final String C_P_JOSM_RULE_ENGINE_JPA_PASSWORD = "j0sM";

	/** Constant that defines C_P_JOSM_JPA_JDBC_URL. */
	private static final String C_P_JOSM_RULE_ENGINE_JPA_JDBC_URL = "jdbc:oracle:thin:@192.168.159.52:1521/josmdb.celtel.net";

	/** Constant that defines C_P_JOSM_JPA_JDBC_DRIVER. */
	private static final String C_P_JOSM_RULE_ENGINE_JPA_JDBC_DRIVER = "oracle.jdbc.OracleDriver";

	/**
	 * Instantiates a new enum action.
	 *
	 * @param key the key
	 * @param value the value
	 */
	private EnumTestRuleEngine(final String key, final String value) {
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
