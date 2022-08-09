package hn.com.tigo.josm.common.http;

import hn.com.tigo.josm.common.cache.HttpClientConfigurationCache;
import hn.com.tigo.josm.common.configuration.dto.HttpClientConfiguration;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

/**
 * SimpleBuilder.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 09-27-2016 04:58:37 PM
 */
public class SimpleBuilder extends AbstractBuilder {

	private CloseableHttpClient httpclient;

	private HttpClientConfiguration httpClientConfiguration;
	
	private HttpClientConfigurationCache httpClientConfigurationCache;

	private RequestConfig requestConfig;
	
	public SimpleBuilder(final String httpConfigName) {
		super(httpConfigName);
	}
	
	public void createHttpClient() {

		httpClientConfiguration = httpClientConfigurationCache.retrieve();
		final HttpClientConnectionManager connManager = new BasicHttpClientConnectionManager();
		final Builder builder = RequestConfig.custom();		
		builder.setConnectTimeout(httpClientConfiguration.getConnectTimeout());
		builder.setConnectionRequestTimeout(httpClientConfiguration.getConnectionRequestTimeout());
		builder.setSocketTimeout(httpClientConfiguration.getSocketTimeout());
		requestConfig = builder.build();
		final HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setConnectionManager(connManager);
		httpclient = httpClientBuilder.build();

	}	

	public CloseableHttpClient getHttpclient() {
		return httpclient;
	}

	public RequestConfig getRequestConfig() {		
		return requestConfig;
	}

}
