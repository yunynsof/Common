package hn.com.tigo.josm.common.validator;

import hn.com.tigo.josm.common.exceptions.ValidatorException;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class SchemaValidator {

	private static final Logger LOGGER = Logger
			.getLogger(SchemaValidator.class);

	private static final SchemaValidator validatorFactory = new SchemaValidator();

	private HashMap<SchemaType, Schema> validatorMap;

	private SchemaFactory factory;

	private SchemaValidator() {
		validatorMap = new HashMap<SchemaType, Schema>();
		factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	}
	

	public static SchemaValidator getInstance() {
		return validatorFactory;
	}

	private Validator getValidator(final SchemaType schemaType) {

		Schema schema = validatorMap.get(schemaType);

		if (schema == null) {
			schema = createValidator(schemaType);
			validatorMap.put(schemaType, schema);
		}

		return schema.newValidator();

	}
	

	private synchronized Schema createValidator(final SchemaType schemaType) {
		
		try {
			
			final URL src = SchemaValidator.class.getClassLoader().getResource(schemaType.getPath());
			final Schema schema = factory.newSchema(src);
			return schema;
		} catch (SAXException e) {
			LOGGER.error(e.getMessage(), e);
		} 
		
		return null;

	}

	public <T> void checkValidation(final SchemaType schemaType, final QName name, Class<T> type, T request) throws ValidatorException {

		try {
			final JAXBElement<T> element = new JAXBElement<T>(name, type,request);
			final JAXBContext context = JAXBContext.newInstance(schemaType.getContext());

			final JAXBSource source = new JAXBSource(context, element);
			final Validator validator = getValidator(schemaType);
			validator.validate(source);
			
		} catch (SAXException e) {
			LOGGER.error(e.getMessage(), e);
			final JAXBException jaxbe = (JAXBException) e.getException();
			final Throwable linke = jaxbe.getLinkedException();
			throw new ValidatorException(linke.getMessage(), linke);

		}catch(JAXBException e){
			LOGGER.error(e.getMessage(), e);
			throw new ValidatorException(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ValidatorException(e.getMessage(), e);
		}

	}
	
	

}
