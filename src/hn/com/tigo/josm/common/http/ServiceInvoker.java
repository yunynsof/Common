/*
 * Copyright 2017 (C) Tigo Honduras
 */
package hn.com.tigo.josm.common.http;

import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.interfaces.MonitoringManagerRemote;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.jmx.event.MXBeanType;
import hn.com.tigo.josm.common.jmx.event.PerformanceEvent;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * ServiceInvoker.
 *
 * @author harold.castillo
 * @version 1.1.0
 * @param <T> the generic type
 * @since 15/06/2016 04:56:48 PM
 */
abstract class ServiceInvoker<T> {

	private static final Logger LOGGER = Logger.getLogger(ServiceInvoker.class);

	private HttpContext context;

	private Buildable buildable;

	private Header[] header;

	private MonitoringManagerRemote monitoringManager;

	private String url;

	protected HttpRequestBase httpRequestBase;

	public ServiceInvoker(final String url, final Buildable buildable, final Map<String, String> properties) {

		this.buildable = buildable;
		this.url = url;
		this.context = HttpClientContext.create();
	}

	public ServiceInvoker(final String url, final Buildable buildable) {

		this.buildable = buildable;
		this.url = url;
		httpRequestBase = new HttpPost(url);
		httpRequestBase.setConfig(buildable.getRequestConfig());
		this.context = HttpClientContext.create();
	}

	public T invoke(final String request, final Charset charset) throws HttpClientException {

		CloseableHttpResponse httpResponse = null;
		T response = null;
		long initTransaction = 0;
		long endTransaction = 0;
		boolean transactionState = false;

		try {
			monitoringManager = ServiceLocator.getInstance().getService(InterfaceFactory.MONITORING_MANAGER_REMOTE);
			this.loadEntity(request, charset.toString());
			initTransaction = System.currentTimeMillis();
			httpResponse = buildable.getHttpclient().execute(httpRequestBase, context);
			final String result = EntityUtils.toString(httpResponse.getEntity(), charset);
			endTransaction = System.currentTimeMillis();
			header = httpResponse.getAllHeaders();
			final int statusCode = httpResponse.getStatusLine().getStatusCode();
			final String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
			response = getResponse(result, statusCode, reasonPhrase);
			transactionState = true;
		} catch (ServiceLocatorException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			endTransaction = System.currentTimeMillis();
			throw new HttpClientException(e);
		} finally {

			if(monitoringManager != null) {
				final PerformanceEvent event = new PerformanceEvent(MXBeanType.BASIC);
				event.setComponent("http");
				event.setObjectName(getIpAddress(url));
				event.setResult(transactionState, endTransaction - initTransaction);
				monitoringManager.receiveEvent(event);
			}

			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					throw new HttpClientException(e.getCause().getMessage(), e);
				}
			}

		}

		return response;
	}
	
	/**
	 * Gets the response of a execution service.
	 *
	 * @param response
	 *            the response raw
	 * @param responseCode
	 *            the response code
	 * @param responseMessage
	 *            the response message
	 * @return the response
	 * @throws HttpClientException
	 *             {@link HttpClientException} instance
	 */
	protected abstract T getResponse(final String response, final int responseCode,
			final String responseMessage) throws HttpClientException;

	/**
	 * Load a entity raw {@link String}.
	 *
	 * @param request the request
	 * @param charset the charset
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	protected abstract void loadEntity(final String request, final String charset) throws UnsupportedEncodingException;

	/**
	 * Gets the header by param's name.
	 *
	 * @param param the name of parameter
	 * @return the {@link Header} instance with the services parameters 
	 */
	public Header getHeader(final String param) {

		Header headerResult = null;

		for (int i = 0; i < header.length; i++) {

			if (header[i].getName().equals(param)) {
				headerResult = header[i];
				break;
			}

		}

		return headerResult;
	}

	/**
	 * Gets the Internet protocol address from a WSDL.
	 *
	 * @param wsdl the WSDL direction
	 * @return the Internet protocol address
	 */
	private String getIpAddress(final String wsdl) {

		final StringBuilder result = new StringBuilder();
		final String ipAddressPatten = "^(([^:/?#]+):)?([^/?#]*)?(//([^/?#]*):)?([^?#]*)(\\?([^#]*))?(#(.*))?";
		final Pattern pattern = Pattern.compile(ipAddressPatten);
		final Matcher matcher = pattern.matcher(wsdl);

		if (matcher.find()) {
			result.append(matcher.group(2)).append(File.separator)
					.append(matcher.group(5)).append(File.separator)
					.append(matcher.group(6));
		}

		return result.toString();
	}

	/**
	 * Gets the HTTP header parameters.
	 *
	 * @return the header array
	 */
	public Header[] getHeader() {
		return header;
	}
	
}