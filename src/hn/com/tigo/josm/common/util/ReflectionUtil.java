/**
 * ReflectionUtil.java
 * CBSDriver
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.ParameterType;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * ReflectionUtil.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 
 * @since 17/12/2014 02:02:26 PM 2014
 */
public final class ReflectionUtil {

	/** Attribute that determine the constant DELIMITER. **/
	private static final String DELIMITER = "$";

	/**
	 * Method responsible to create an ReflectionUtil instance.
	 */
	private ReflectionUtil() {
	}

	/**
	 * Reflection test.
	 *
	 * @param object the object
	 * @param msg the msg
	 * @param parameters 
	 * @throws IllegalAccessException the illegal access exception
	 */
	@SuppressWarnings("unchecked")
	private static synchronized void reflectionFields(final Object object,
			final String msg, ParameterArray parameters) throws IllegalAccessException {
		final List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(object.getClass().getDeclaredFields()));
		if (object.getClass().getSuperclass() != null) {
			fields.addAll(Arrays.asList(object.getClass().getSuperclass()
					.getDeclaredFields()));
		} 

		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(object);
			// Create builder for parameters names
			final StringBuilder nameParam = new StringBuilder();
			
			validateParametersName(object, msg, nameParam);
			// The type element is validated how JAXBElement.
			if (value != null && value.getClass() == javax.xml.bind.JAXBElement.class) {
				final JAXBElement<Object> element = (JAXBElement<Object>) value;
				value = element.getValue();
			}
			final int cont = 0;
			if (value != null && value.getClass() == ArrayList.class) {
				final ArrayList<Object> list = (ArrayList<Object>) value;
				loadElementsList(field, nameParam, cont, list, parameters);
			} else if (Modifier.isProtected(field.getModifiers()) && validateField(value)) {
				addElementToList(field, value, nameParam, parameters);
			} else if (value != null) {
				nameParam.append(DELIMITER + field.getName());
				reflectionFields(value, nameParam.toString(), parameters);
			}
		}
	}
	
	/**
	 * Adds the element to list.
	 *
	 * @param field the field
	 * @param value the value
	 * @param nameParam the name param
	 * @param parameterArray 
	 */
	private static void addElementToList(final Field field, final Object value,
			final StringBuilder nameParam, final ParameterArray parameterArray) {
		final StringBuffer buffer = new StringBuffer();
		buffer.append(nameParam.toString());
		buffer.append(DELIMITER);
		buffer.append(field.getName());
		
		final ParameterType parameter = new ParameterType();
		parameter.setName(buffer.toString());
		parameter.setValue(value.toString());
		
		parameterArray.getParameter().add(parameter);
	}

	
	/**
	 * Validate parameters name.
	 *
	 * @param object the object
	 * @param msg the msg
	 * @param nameParam the name param
	 */
	private static void validateParametersName(final Object object,
			final String msg, final StringBuilder nameParam) {
		if (msg != null && !msg.isEmpty()) {
			nameParam.append(msg);
		} else {
			nameParam.append(object.getClass().getSimpleName());
		}
	}

	
	/**
	 * Method in charge to load the elements list.
	 *
	 * @param field the field
	 * @param nameParam the name param
	 * @param cont the cont
	 * @param list the list
	 * @param parameterArray 
	 * @throws IllegalAccessException the illegal access exception
	 */
	private static void loadElementsList(final Field field,
			final StringBuilder nameParam, int cont,
			final ArrayList<Object> list, final ParameterArray parameterArray) throws IllegalAccessException {
		for (Object objTmp : list) {
			cont++;
			if (validateField(objTmp)) {
				addElementToList(field, objTmp, nameParam, parameterArray);
			} else {
				if (!nameParam.toString().contains(field.getName())) {
					nameParam.append(DELIMITER + field.getName());
				}
				reflectionFields(objTmp, nameParam.toString()
						+ cont, parameterArray);
			}
		}
	}
	
	/**
	 * Method responsible to gets the parameter array.
	 * @param _parameters 
	 *
	 * @return the parameter array
	 * @throws IllegalAccessException 
	 */
	public static synchronized ParameterArray getParameterArray(final Object object, final String msg) throws IllegalAccessException {
		final ParameterArray parameterArray = new ParameterArray();
		reflectionFields(object, msg, parameterArray);
		return parameterArray;
	}

	/**
	 * Validate type object.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	private static Boolean validateField(final Object value) {
		if(value == null){
			return false;
		}
		if(value.getClass().isEnum()){
			return true;
		}
		if(value instanceof XMLGregorianCalendar){
			return true;
		}
		final List<Object> list = new ArrayList<Object>();
		list.add(java.lang.Long.class);
		list.add(java.lang.String.class);
		list.add(java.lang.Integer.class);
		list.add(java.lang.Boolean.class);
		list.add(java.math.BigInteger.class);
		list.add(java.math.BigDecimal.class);
		list.add(java.lang.Double.class);
		list.add(java.lang.Enum.class);
		list.add(java.util.Date.class);
		list.add(java.util.Calendar.class);
		list.add(javax.xml.datatype.XMLGregorianCalendar.class);
		
		return (value.getClass().isPrimitive()) || list.contains(value.getClass());
	}
	
}
