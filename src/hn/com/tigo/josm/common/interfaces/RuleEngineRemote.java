package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.exceptions.RuleEngineFault;
import hn.com.tigo.josm.rule.dto.RuleRequest;
import hn.com.tigo.josm.rule.dto.RuleResponse;

import javax.ejb.Remote;

/**
 * RuleEngineRemote.
 * Remote Interface for consumption of RuleEngine  
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 28/07/2015 10:29:08 AM 2015
 */
@Remote
public interface RuleEngineRemote {
	
	/**
	 * Validate the Business Rule. Uses a session to determine the rule package
	 * to validate and the inputs for this rules.
	 * Respond the output parameters for this rules.
	 *
	 * @param ruleRequest
	 *            the rule request
	 * @return the rule response
	 */
	RuleResponse validate(RuleRequest ruleRequest) throws RuleEngineFault;

}
