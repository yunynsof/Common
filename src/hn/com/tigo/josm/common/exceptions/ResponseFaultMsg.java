
package hn.com.tigo.josm.common.exceptions;

import hn.com.tigo.josm.subscription.dto.MessageFaultType;

import javax.ejb.ApplicationException;
import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "MessageFault", targetNamespace = "http://tigo.com/josm/subscription/services/subscription/v1/schema")
@ApplicationException(rollback=true)
public class ResponseFaultMsg
    extends Exception
{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private MessageFaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ResponseFaultMsg(String message, MessageFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ResponseFaultMsg(String message, MessageFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: hn.com.tigo.josm.subscription.schedule.client.MessageFaultType
     */
    public MessageFaultType getFaultInfo() {
        return faultInfo;
    }
    
    
    public static ResponseFaultMsg createFault(final int error, final String message){
    	
    	final MessageFaultType faultType = new MessageFaultType();
    	faultType.setError(error);
    	faultType.setDescription(message);
    	final ResponseFaultMsg fault = new ResponseFaultMsg(message, faultType);
    	
    	return fault;
   	
    }
    
    
    public static ResponseFaultMsg createFault(final int error, final String message, final Throwable cause){
    	
    	final MessageFaultType faultType = new MessageFaultType();
    	faultType.setError(error);
    	faultType.setDescription(message);
    	final ResponseFaultMsg fault = new ResponseFaultMsg(message, faultType, cause);
    	
    	return fault;
   	
    }

}
