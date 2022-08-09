package hn.com.tigo.josm.common.cache;

import java.util.Hashtable;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;

import org.apache.log4j.Logger;

/**
 * ObjectFactoryCache.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 09-27-2016 03:17:44 PM
 */
public class ObjectFactoryCache {

	/**
	 * This attribute will store an instance of log4j for ObjectFactoryCache
	 * class.
	 */
	private static final Logger LOGGER = Logger.getLogger(ObjectFactoryCache.class);

	/**
	 * Attribute that determine the object factory object and it´s loaded with
	 * the classloader.
	 */
	private static ObjectFactoryCache objectFactory = new ObjectFactoryCache();

	/**
	 * Attribute that determine the instance of the {@link MessageFactory}
	 * object.
	 */
	private MessageFactory messageFactory;

	/**
	 * Attribute that determine the instance of the {@link JAXBContext} objects.
	 */
	private Map<String, JAXBContext> jaxbContexts;

	/**
	 * Attribute that determine the instance of the
	 * {@link DocumentBuilderFactory} object.
	 */
	private DocumentBuilderFactory documentBuilderFactory;

	/**
	 * Instantiates a new object factory cache.
	 */
	private ObjectFactoryCache() {
		jaxbContexts = new Hashtable<>();
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
	}

	/**
	 * Gets the single instance of ObjectFactoryCache.
	 *
	 * @return single instance of ObjectFactoryCache
	 */
	public static ObjectFactoryCache getInstance() {
		return objectFactory;
	}

	/**
	 * Gets the message factory.
	 *
	 * @return {@link MessageFactory} unique instance.
	 */
	public MessageFactory getMessageFactory() {

		if (this.messageFactory == null) {

			try {
				this.messageFactory = MessageFactory.newInstance();
			} catch (SOAPException e) {
				LOGGER.error(e.getCause().getMessage(), e);
			}

		}

		return this.messageFactory;
	}

	/**
	 * Gets the message factory.
	 *
	 * @param protocol
	 *            the protocol
	 * @return the message factory
	 */
	public MessageFactory getMessageFactory(final String protocol) {

		if (this.messageFactory == null) {

			try {
				this.messageFactory = MessageFactory.newInstance(protocol);
			} catch (SOAPException e) {
				LOGGER.error(e.getCause().getMessage(), e);
			}

		}

		return this.messageFactory;
	}

	/**
	 * Gets the jaxb context.
	 *
	 * @param contextName
	 *            the context name
	 * @return the jaxb context
	 * @throws JAXBException
	 *             the JAXB exception
	 */
	public JAXBContext getJaxbContext(final String contextName) throws JAXBException {

		if (!jaxbContexts.containsKey(contextName)) {
			final JAXBContext context = JAXBContext.newInstance(contextName);
			jaxbContexts.put(contextName, context);
		}

		return jaxbContexts.get(contextName);
	}

	/**
	 * Gets the document builder factory.
	 *
	 * @return the document builder factory
	 */
	public DocumentBuilderFactory getDocumentBuilderFactory() {
		return documentBuilderFactory;
	}

}
