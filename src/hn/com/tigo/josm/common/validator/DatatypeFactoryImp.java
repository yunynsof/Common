package hn.com.tigo.josm.common.validator;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.log4j.Logger;

/**
 * DatatypeFactoryImp.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 22/07/2016 04:31:56 PM 2016
 */
public class DatatypeFactoryImp {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(DatatypeFactoryImp.class);
	
	/** The datatype factory holder. */
	private static DatatypeFactory datatypeFactoryHolder;


	static {

		try {
			datatypeFactoryHolder = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			LOGGER.warn(e.getMessage(), e);
			throw new IllegalStateException("Error while trying to obtain a new instance of DatatypeFactory", e);
		}

	}
	
	
	/**
	 * Gets the datatype factory holder.
	 *
	 * @return the datatype factory holder
	 */
	public static DatatypeFactory getDatatypeFactoryHolder() {
		return datatypeFactoryHolder;
	}


}
