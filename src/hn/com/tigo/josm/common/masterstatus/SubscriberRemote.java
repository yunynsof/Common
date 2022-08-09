/**
 * SubscriberService.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.masterstatus;

import hn.com.tigo.josm.common.exceptions.ProfileException;
import hn.com.tigo.josm.common.profile.ProfileResponse;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

/**
 * SubscriberService.
 * 
 * Interface that allows to expose methods of inserting and deleting of
 * subscribers.
 * 
 * @author Harold Castillo
 * @version 1.0
 * @since 14/05/2015 16:08:12
 */
@Remote
@WebService(name = "SubscriberService", targetNamespace = "http://tigo.com.hn/josm/common/masterstatus/subscriber/V1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface SubscriberRemote {

	/**
	 * Method for creating a subscriber.
	 * 
	 * @param subscriber
	 *            the subscriber id or msisdn
	 * @return the profile response
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse createSubscriber(@WebParam(name = "subscriber") String subscriber) throws ProfileException;

	/**
	 * Method for deleting a subscriber.
	 * 
	 * @param subscriber
	 *            the subscriber id or msisdn
	 * @return the profile response
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse deleteSubscriber(@WebParam(name = "subscriber") String subscriber) throws ProfileException;

	/**
	 * Method that allows changing of a subscriber number.
	 *
	 * @param oldSubscriber
	 *            the old subscriber number
	 * @param newSubscriber
	 *            the new subscriber number
	 * @return the profile response
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse changeNumber(@WebParam(name = "oldSubscriber") String oldSubscriber,
			@WebParam(name = "newSubscriber") String newSubscriber) throws ProfileException;

	/**
	 * Gets the subscriber basic information.
	 *
	 * @param subscriber
	 *            the subscriber
	 * @return the subscriber
	 * @throws ProfileException
	 *             the profile exception
	 */
	@WebMethod
	ProfileResponse getSubscriber(@WebParam(name = "subscriber") String subscriber) throws ProfileException;
	
	/**
	 * Gets the profiles list of a subscriber specific.
	 *
	 * @param subscriber the subscriber
	 * @return the profile
	 * @throws ProfileException the profile exception
	 */
	ProfileResponse getProfile(@XmlElement(required = true) @WebParam(name = "subscriber") String subscriber)
			throws ProfileException;

}
