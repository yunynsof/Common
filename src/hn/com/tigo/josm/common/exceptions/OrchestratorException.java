package hn.com.tigo.josm.common.exceptions;


/**
 * The class OrchestratorException.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 
 * @since 16/02/2015 11:00:47 AM 2015
 */
public class OrchestratorException extends AbstractException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OrchestratorException() {
		super();
		
	}

	/**
	 * @param exception
	 */
	public OrchestratorException(final Exception exception) {
		super(exception);
		
	}

	/**
	 * @param orderIndex
	 * @param errorCode
	 * @param errorMessage
	 * @param exception
	 */
	public OrchestratorException(final int orderIndex, final int errorCode, final String errorMessage,final  Exception exception) {
		super(orderIndex, errorCode, errorMessage, exception);
		
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 * @param cause
	 */
	public OrchestratorException(final int errorCode, final String errorMessage, final Exception cause) {
		super(errorCode, errorMessage, cause);
		
	}

	/**
	 * @param errorCode
	 * @param msg
	 * @param cause
	 */
	public OrchestratorException(final int errorCode, final String msg, final Throwable cause) {
		super(errorCode, msg, cause);
		
	}

	/**
	 * @param errorCode
	 * @param message
	 */
	public OrchestratorException(final int errorCode, final String message) {
		super(errorCode, message);
		
	}

	/**
	 * @param errorCode
	 */
	public OrchestratorException(final int errorCode) {
		super(errorCode);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public OrchestratorException(final String message, final Exception cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public OrchestratorException(final String message) {
		super(message);
		
	}
	
	
}
