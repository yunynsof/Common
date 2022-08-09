package hn.com.tigo.josm.common.exceptions;

/**
 * TransactionException.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 12/08/2015 03:39:26 PM 2015
 */
public class TransactionManagerException extends Exception {
	
	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 637244818045041285L;

	/**
	 * Instantiates a new transaction exception.
	 */
	public TransactionManagerException() {
	}

	
	/**
	 * Instantiates a new transaction exception.
	 *
	 * @param exception the exception
	 */
	public TransactionManagerException(final Exception exception) {
		super(exception);
		
	}

}
