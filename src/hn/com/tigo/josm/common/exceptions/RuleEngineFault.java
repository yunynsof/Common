package hn.com.tigo.josm.common.exceptions;

import hn.com.tigo.josm.rule.dto.RuleEngineException;

import javax.xml.ws.WebFault;

/**
 * RuleEngineFault.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 28/07/2015 10:58:39 AM 2015
 */
@WebFault(name = "RuleEngineException", targetNamespace = "http://tigo.com/josm/rule/service/V1")
public class RuleEngineFault extends Exception {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/**
	 * Java type that goes as soapenv:Fault detail element.
	 * 
	 */
	private RuleEngineException faultInfo;

	/**
	 * Instantiates a new rule engine fault.
	 *
	 * @param message the message
	 * @param faultInfo the fault info
	 */
	public RuleEngineFault(String message, RuleEngineException faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	/**
	 * Instantiates a new rule engine fault.
	 *
	 * @param message the message
	 * @param faultInfo the fault info
	 * @param cause the cause
	 */
	public RuleEngineFault(String message, RuleEngineException faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	/**
	 * Gets the fault info.
	 *
	 * @return returns fault bean:
	 *         hn.com.tigo.josm.subscription.schedule.client.MessageFaultType
	 */
	public RuleEngineException getFaultInfo() {
		return faultInfo;
	}

	
	/**
	 * Creates the fault.
	 *
	 * @param error the error
	 * @param message the message
	 * @return the rule engine fault
	 */
	public static RuleEngineFault createFault(final int error,
			final String message) {

		final RuleEngineException faultType = new RuleEngineException();
		faultType.setError(error);
		faultType.setDescription(message);
		final RuleEngineFault fault = new RuleEngineFault(message, faultType);

		return fault;

	}

	/**
	 * Creates the fault.
	 *
	 * @param error the error
	 * @param message the message
	 * @param cause the cause
	 * @return the rule engine fault
	 */
	public static RuleEngineFault createFault(final int error,
			final String message, final Throwable cause) {

		final RuleEngineException faultType = new RuleEngineException();
		faultType.setError(error);
		faultType.setDescription(message);
		final RuleEngineFault fault = new RuleEngineFault(message, faultType,
				cause);

		return fault;

	}

}
