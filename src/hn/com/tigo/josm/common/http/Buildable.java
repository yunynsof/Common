package hn.com.tigo.josm.common.http;

import hn.com.tigo.josm.common.cache.HttpClientConfigurationCache;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Buildable.
 * 
 * Exposes the methods for obtaining the specifically configuration and of the
 * HTTP builders instances.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 09-27-2016 03:32:00 PM
 */
public interface Buildable {

	/**
	 * Gets the HTTP client.
	 *
	 * @return {@link CloseableHttpClient} instance
	 */
	CloseableHttpClient getHttpclient();

	/**
	 * Gets the request configuration.
	 *
	 * @return {@link RequestConfig} instance
	 */
	RequestConfig getRequestConfig();

	/**
	 * Gets the HTTP client configuration cache.
	 *
	 * @return {@link HttpClientConfigurationCache} instance
	 */
	HttpClientConfigurationCache getHttpClientConfigurationCache();

}
