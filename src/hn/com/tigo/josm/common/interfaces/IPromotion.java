package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.exceptions.PromotionException;
import hn.com.tigo.josm.common.exceptions.ValidationException;
import hn.com.tigo.josm.promotion.dto.PromotionResponse;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * IPromotion.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 24/02/2016 08:45:27 PM 2016
 */
@Remote
@WebService(name = "IPromotion", targetNamespace = "http://tigo.com.hn/josm/common/interfaces/Promotion/V1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface IPromotion {

	/**
	 * Load.
	 *
	 * @param promotionId the promotion id
	 * @return the promotion response
	 * @throws ValidationException 
	 * @throws PromotionException 
	 */
	@WebMethod(operationName = "load")
	PromotionResponse load(@WebParam(name = "promotionId") final long promotionId) throws PromotionException, ValidationException;

	/**
	 * Load subscriber.
	 *
	 * @param promotionId the promotion id
	 * @param subscriberId the subscriber id
	 * @param transactionId the transaction id
	 * @return the promotion response
	 * @throws PromotionException the promotion exception
	 * @throws ValidationException the validation exception
	 */
	@WebMethod(operationName = "loadSubscriber")
	PromotionResponse loadSubscriber(@WebParam(name = "promotionId") final long promotionId,  @WebParam(name = "subscriberId") final long subscriberId,  @WebParam(name = "transactionId") final String transactionId)
			throws PromotionException, ValidationException;

	/**
	 * Query subscriber.
	 *
	 * @param promotionId the promotion id
	 * @param subscriberId the subscriber id
	 * @param transactionId the transaction id
	 * @return the promotion response
	 * @throws PromotionException the promotion exception
	 * @throws ValidationException the validation exception
	 */
	@WebMethod(operationName = "querySubscriber")
	PromotionResponse querySubscriber(@WebParam(name = "promotionId") final long promotionId,  @WebParam(name = "subscriberId") final long subscriberId,  @WebParam(name = "transactionId") final String transactionId,@WebParam(name = "isMandatory") final Boolean isMandatory)
			throws PromotionException, ValidationException;

	/**
	 * Activate subscriber.
	 *
	 * @param promotionId the promotion id
	 * @param subscriberId the subscriber id
	 * @param transactionId the transaction id
	 * @return the promotion response
	 * @throws PromotionException the promotion exception
	 * @throws ValidationException the validation exception
	 */
	@WebMethod(operationName = "activateSubscriber")
	PromotionResponse activateSubscriber(@WebParam(name = "promotionId") final long promotionId,  @WebParam(name = "subscriberId") final long subscriberId,  @WebParam(name = "transactionId") final String transactionId)
			throws PromotionException, ValidationException;

	/**
	 * Deactivate subscriber.
	 *
	 * @param promotionId the promotion id
	 * @param subscriberId the subscriber id
	 * @param transactionId the transaction id
	 * @return the list
	 * @throws PromotionException the promotion exception
	 * @throws ValidationException the validation exception
	 */
	@WebMethod(operationName = "deactivateSubscriber")
	PromotionResponse deactivateSubscriber(@WebParam(name = "promotionId") final long promotionId, @WebParam(name = "subscriberId") final long subscriberId,
			@WebParam(name = "transactionId")  final String transactionId) throws PromotionException, ValidationException;

}
