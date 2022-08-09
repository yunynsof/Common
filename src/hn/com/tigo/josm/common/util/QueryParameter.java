/**
 * QueryParameter.java
 * Gateway
 * Copyright (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for the creations of query parameters.
 * 
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version
 * @see
 * @since 26/11/2014 11:27:57 AM 2014
 */
public class QueryParameter {

	/** The Constant QUERY_PARAM_RETRY_POLICY_PRODUCT_ID. */
	public static final String QUERY_PARAM_RETRY_POLICY_PRODUCT_ID = "productId";

	/** Attribute that determine a Constant of QUERY_PARAM_PRODUCT_ID. */
	public static final String QUERY_PARAM_PRODUCT_ID = "productId";
	
	/** Attribute that determine a Constant of QUERY_PARAM_ERROR_CODE. */
	public static final String QUERY_PARAM_ERROR_CODE = "errorCode";

	/** The Constant QUERY_PARAM_PRODUCT_FAMILY_ID. */
	public static final String QUERY_PARAM_PRODUCT_FAMILY_ID = "productFamilyId";

	/** The Constant QUERY_PARAM_PLATFORM_ID. */
	public static final String QUERY_PARAM_PLATFORM_ID = "platformId";

	/** The Constant QUERY_PARAM_ORDER_TYPE. */
	public static final String QUERY_PARAM_ORDER_TYPE = "orderType";

	/** Attribute that determine a Constant of QUERY_PARAM_SUBSCRIBER_ID. */
	public static final String QUERY_PARAM_SUBSCRIBER_ID = "subscriberId";

	/** Attribute that determine a Constant of QUERY_PARAM_CURRENT_DATE. */
	public static final String QUERY_PARAM_CURRENT_DATE = "currentDate";

	/** Attribute that determine a Constant of QUERY_PARAM_CURRENT_HOUR. */
	public static final String QUERY_PARAM_CURRENT_HOUR = "currentHour";

	/** Attribute that determine a Constant of QUERY_PARAM_LAST_EXECUTE_DATE. */
	public static final String QUERY_PARAM_LAST_EXECUTE_DATE = "lastExecuteDate";
	
	/** Attribute that determine a Constant of QUERY_PARAM_PROFILE_ID. */
	public static final String QUERY_PARAM_PROFILE_ID = "profileId";

	/**
	 * Attribute that determine the name of the query to search plugins of the
	 * product.
	 */
	public static final String QUERY_PRODUCT_POLICY_INSTANCE_FIND_BY_PRODUCT = "ProductPolicyInstance.findByProduct";

	/** The Constant QUERY_FIND_ACTUAL_BPM_VERSION_BY_FAMILY_ID. */
	public static final String QUERY_FIND_ACTUAL_BPM_VERSION_BY_FAMILY_ID = "BpmVersion.findActualVersionByFamilyId";

	/** Attribute that determine a Constant of QUERY_SUBSCRIBERPROFILE_FIND_HISTORY. */
	public static final String QUERY_SUBSCRIBERPROFILE_FIND_HISTORY = "SubscriberProfile.findHistory";
	
	/** Attribute that determine a Constant of QUERY_FIND_BY_SUBSCRIBER_PROFILE. */
	public static final String QUERY_FIND_BY_SUBSCRIBER_PROFILE = "SubscriberProfile.findBySubscriberProfile";

	/** The Constant QUERY_FIND_BY_SUBSCRIBER_PROFILE_BY_DATE. */
	public static final String QUERY_FIND_BY_SUBSCRIBER_PROFILE_BY_DATE = "SubscriberProfile.findBySubscriberProfileDateFrom";
	
	/** Attribute that determine a constant with the name of the query for the subscribers subscriptions. */
	public static final String QUERY_SUBSCRIPTION_FIND_BY_SUBSCRIBER = "Subscription.findBySubscriber";
	
	/**
	 * Attribute that determine a constant with the name of the query for the
	 * subscribers subscriptions from a date specific.
	 */
	public static final String QUERY_SUBSCRIPTION_LAST_EXECUTION_DATE = "Subscription.findBySubscriberFromlastExecuteDate";
	
	/** Attribute that determine a Constant of QUERY_MESSAGE_BUNDLE_FIND_BY_PRODUCT_ERROR_CODE. */
	public static final String QUERY_MESSAGE_BUNDLE_FIND_BY_PRODUCT_ERROR_CODE = "MessageBundle.findByProductAndErrorCode";
	
	/** The Constant QUERY_RULE_BASE_FIND_ALL. */
	public static final String QUERY_RULE_BASE_FIND_ALL = "RuleBase.findAll";
	
	/** The Constant QUERY_RULE_FIND_ALL. */
	public static final String QUERY_RULE_FIND_ALL = "Rule.findAll";
	


	/** Attribute that determine the query parameters. */
	private Map<String, Object> parameters = null;

	/**
	 * Instantiates a new query parameter.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	private QueryParameter(String name, Object value) {
		this.parameters = new HashMap<String, Object>();
		this.parameters.put(name, value);
	}

	/**
	 * Public method that instance a QueryParameter object.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the query parameter
	 */
	public static QueryParameter with(String name, Object value) {
		return new QueryParameter(name, value);
	}

	/**
	 * Add a parameter to a QueryParammeter object.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the query parameter
	 */
	public QueryParameter and(String name, Object value) {
		this.parameters.put(name, value);
		return this;
	}

	/**
	 * Return the parameters for query.
	 * 
	 * @return the map
	 */
	public Map<String, Object> parameters() {
		return this.parameters;
	}

}
