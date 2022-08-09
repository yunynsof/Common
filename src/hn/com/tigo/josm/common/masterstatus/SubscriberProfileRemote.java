/**
 * SubscriberProfileService.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.masterstatus;

import hn.com.tigo.josm.common.exceptions.ProfileException;
import hn.com.tigo.josm.common.profile.Attributes;
import hn.com.tigo.josm.common.profile.ProfileResponse;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * SubscriberProfileService.
 * 
 * Interface that allows to expose methods of cnosulting and inserting of
 * attributes associated with a profile and a subscriber.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 14/05/2015 16:21:49
 */
@Remote
@WebService(name = "SubscriberProfileService", targetNamespace = "http://tigo.com.hn/josm/common/masterstatus/subscriberprofile/V1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface SubscriberProfileRemote {

	/**
	 * Get attributes associated with a profile and a subscriber.
	 * 
	 * @param subscriber
	 *            the subscriber id or msisdn
	 * @param profile
	 *            the profile id, is the identifier of the table
	 *            <code>PROFILE</code> in the schema <code>MASTER STATUS</code>
	 * @return the profile information
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse getSubscriberProfile(@WebParam(name = "subscriber") String subscriber,
			@WebParam(name = "profile") String profile) throws ProfileException;

	/**
	 * Get all attributes associated with a profile and a subscriber.
	 * 
	 * @param subscriber
	 *            the subscriber id or msisdn
	 * @param profile
	 *            the profile id, is the identifier of the table
	 *            <code>PROFILE</code> in the schema <code>MASTER STATUS</code>
	 * @return the profile information
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse getSubscriberProfileHistory(@WebParam(name = "subscriber") String subscriber,
			@WebParam(name = "profile") String profile) throws ProfileException;

	/**
	 * Create attributes associated with a profile and a subscriber..
	 *
	 * @param subscriber            the subscriber id or msisdn
	 * @param profile            the profile id, is the identifier of the table
	 *            <code>PROFILE</code> in the schema <code>MASTER STATUS</code>
	 * @param transactionId            the transaction id
	 * @param attributes            the attributes of the profile
	 * @return the profile information
	 * @throws ProfileException             the profile exception
	 */
	@WebMethod
	ProfileResponse createSubscriberProfile(@WebParam(name = "subscriber") String subscriber,
			@WebParam(name = "profile") String profile,
			@WebParam(name = "transactionId") String transactionId,
			@WebParam(name = "attributes") Attributes attributes) throws ProfileException;

	/**
	 * Get the attributes associated with a profile and a subscriber from a date
	 * specific.
	 * 
	 * @param subscriber
	 *            the subscriber
	 * @param profile
	 *            the profile
	 * @param date
	 *            the date
	 * @return the profile date
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse getSubscriberProfileFromDate(@WebParam(name = "subscriber") final String subscriber,
			@WebParam(name = "profile") final String profile, @WebParam(name = "date") final String date)
			throws ProfileException;

	/**
	 * Gets the subscriber profile from date by transaction.
	 *
	 * @param subscriber the subscriber
	 * @param profile the profile
	 * @param date the date
	 * @return the subscriber profile from date by transaction
	 * @throws ProfileException the profile exception
	 */
	@WebMethod
	ProfileResponse getSubscriberProfileFromDateByTransaction(@WebParam(name = "subscriber") final String subscriber,
			@WebParam(name = "profile") final String profile, @WebParam(name = "date") final String date)
			throws ProfileException;

}
