package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.exceptions.ResponseFaultMsg;
import hn.com.tigo.josm.subscription.dto.ActivateSubscriptionType;
import hn.com.tigo.josm.subscription.dto.ChangeNumberType;
import hn.com.tigo.josm.subscription.dto.DeactivateSubscriptionType;
import hn.com.tigo.josm.subscription.dto.DeactivateSubscriptionsAllType;
import hn.com.tigo.josm.subscription.dto.MessageACKType;
import hn.com.tigo.josm.subscription.dto.VerifySubscriptionType;

import javax.ejb.Remote;

@Remote
public interface SubscriptionRemote {

	public MessageACKType activateSubscription(ActivateSubscriptionType body)
			throws ResponseFaultMsg;

	public MessageACKType deactivateSubscription(DeactivateSubscriptionType body)
			throws ResponseFaultMsg;

	public MessageACKType deactivateSubscriptionsAll(
			DeactivateSubscriptionsAllType body) throws ResponseFaultMsg;

	public MessageACKType verifySubscription(VerifySubscriptionType body)
			throws ResponseFaultMsg;
	
	public MessageACKType changeNumber(ChangeNumberType body)
			throws ResponseFaultMsg;

}
