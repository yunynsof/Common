/**
 * SprConnection.java
 * SPRDriver
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.http;

import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;


/**
 * HttpUrlConnection.
 *
 * @author Andres Felipe Hinestroza <mailto:afhinestroza@stefanini.com />
 * @version 1.0
 * @since 21/10/2015 05:14:15 PM 2015
 */
public class HttpUrlConnection {
	
	
	/** Attribute that determine a Constant of LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(HttpUrlConnection.class);
	
	/** Attribute that determine httpURLConnection. */
	private HttpURLConnection httpURLConnection;
		
	/** The _url. */
	private URL _url; 

	/** The _connect time out. */
	private int _connectTimeOut;
	
	/** The _read time out. */
	private int _readTimeOut;
	
	/** Attribute that determine _connectionType. */
	private Map<String, String> requestProperties = new HashMap<String, String>();
	
	/**
	 * Instantiates a new http url connection.
	 */
	public HttpUrlConnection(){
		
	}
	
	/**
	 * Instantiates a new http url connection.
	 *
	 * @param urlStr the url str
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public HttpUrlConnection(final String urlStr) throws IOException {
		_url = new URL(urlStr);
	}
	
	

	/**
	 * 
	 *
	 * @param request 
	 * @param isOutput 
	 * @return 
	 * @throws IOException 
	 * @throws AdapterException 
	 */
	public String sendPost(final String request, final boolean isOutput) throws IOException, AdapterException {

		final StringBuffer response = new StringBuffer();
		BufferedReader bufferedReader = null;

		try{
			final byte[] postDataBytes = request.toString().getBytes("UTF-8");
			httpURLConnection = (HttpURLConnection) _url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);
			
			httpURLConnection.setConnectTimeout(_connectTimeOut);
			httpURLConnection.setReadTimeout(_readTimeOut);
			
			httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpURLConnection.setRequestProperty("Connection", "close");
			httpURLConnection.setRequestProperty("SOAPAction", "");
			
			updateRequestProperties();
			
			httpURLConnection.getOutputStream().write(postDataBytes);
			
			final int responseCode = httpURLConnection.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, httpURLConnection.getResponseMessage(), String.valueOf(responseCode), null);
			}
			
			if(isOutput){
				final InputStream inputStream = httpURLConnection.getInputStream();
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String inputLine;
				while ((inputLine = bufferedReader.readLine()) != null) {
					response.append(inputLine);
				}
			}

		} catch(NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			LOGGER.error("URL: " + _url);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, e.getMessage(), e);
		} finally{
			if(bufferedReader != null){
				bufferedReader.close();
			}
			httpURLConnection.disconnect();
		}
		
		return response.toString();
	}
	
	/**
	 * Method responsible to sets the connection request properties.
	 */
	private void updateRequestProperties(){
		for(Map.Entry<String, String> property : requestProperties.entrySet()){
			httpURLConnection.setRequestProperty(property.getKey(), property.getValue());
		}
	}
	
	/**
	 * Send get.
	 *
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String sendGet( final boolean isOutput) throws IOException {

		final StringBuffer response = new StringBuffer();
		BufferedReader bufferedReader = null;

		try {
			httpURLConnection = (HttpURLConnection) _url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setConnectTimeout(_connectTimeOut);
			httpURLConnection.setReadTimeout(_readTimeOut);
			
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			if(isOutput){
				String inputLine;
				while ((inputLine = bufferedReader.readLine()) != null) {
					response.append(inputLine);
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if(bufferedReader != null){
				bufferedReader.close();
			}
			if(httpURLConnection != null){
				httpURLConnection.disconnect();
			}
		}
		
		return response.toString();
	}
	
	/**
	 * Disconnect.
	 */
	public void disconnect(){
		if(httpURLConnection != null){
			httpURLConnection.disconnect();
		}
	}
	
	/**
	 * Sets the connect time out.
	 *
	 * @param connectTimeOut the new connect time out
	 */
	public void setConnectTimeOut(final int connectTimeOut) {
		this._connectTimeOut = connectTimeOut;
	}

	/**
	 * Sets the read time out.
	 *
	 * @param readTimeOut the new read time out
	 */
	public void setReadTimeOut(final int readTimeOut) {
		this._readTimeOut = readTimeOut;
	}

	/**
	 * Put request properties.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void putRequestProperties(final String key, final String value) {
		httpURLConnection.setRequestProperty(key, value);
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 * @throws MalformedURLException the malformed url exception
	 */
	public void setURL(final String url) throws MalformedURLException{
		_url = new URL(url);
	}

	/**
	 * Gets the request properties.
	 *
	 * @return the request properties
	 */
	public Map<String, String> getRequestProperties() {
		return requestProperties;
	}

	/**
	 * Sets the request properties.
	 *
	 * @param requestProperties the request properties
	 */
	public void setRequestProperties(final Map<String, String> requestProperties) {
		this.requestProperties = requestProperties;
	}
	
	

	
	
}
