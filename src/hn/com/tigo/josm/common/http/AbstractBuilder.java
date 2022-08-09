/**
 * HttpBuilder.java
 * AbstractBuilder
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.http;

import hn.com.tigo.josm.common.cache.HttpClientConfigurationCache;
import hn.com.tigo.josm.common.configuration.dto.HttpClientConfiguration;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * AbstractBuilder.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 09-27-2016 10:20:38 PM
 */
public abstract class AbstractBuilder implements Buildable {

	protected CloseableHttpClient httpclient;

	protected HttpClientConfiguration httpClientConfiguration;

	protected HttpClientConfigurationCache httpClientConfigurationCache;

	protected RequestConfig requestConfig;

	protected AbstractBuilder(final String httpConfigName) {
		httpClientConfigurationCache = new HttpClientConfigurationCache(httpConfigName);
		this.createHttpClient();
	}

	protected abstract void createHttpClient();

	public CloseableHttpClient getHttpclient() {
		return httpclient;
	}

	public RequestConfig getRequestConfig() {
		return requestConfig;
	}

	public HttpClientConfigurationCache getHttpClientConfigurationCache() {
		return httpClientConfigurationCache;
	}

}
