package hn.com.tigo.josm.common.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * PoolingBuilder.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 09-27-2016 04:49:57 PM
 */
public class PoolingBuilder extends AbstractBuilder {

	private static PoolingBuilder poolingBuilder;

	/**
	 * Instantiates a new pooling builder.
	 *
	 * @param httpConfigName the http config name
	 */
	private PoolingBuilder(final String httpConfigName) {
		super(httpConfigName);
	}

	/**
	 * Gets the single instance of PoolingBuilder.
	 *
	 * @param httpConfigName the HTTP configuration name
	 * @return single instance of PoolingBuilder
	 */
	public static PoolingBuilder getInstance(final String httpConfigName) {

		if(poolingBuilder == null) {
			poolingBuilder = new PoolingBuilder(httpConfigName);			
		}

		return PoolingBuilder.poolingBuilder;
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.http.AbstractBuilder#createHttpClient()
	 */
	protected void createHttpClient() {

		httpClientConfiguration = httpClientConfigurationCache.retrieve();
		final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(httpClientConfiguration.getMaxTotal());
		connManager.setDefaultMaxPerRoute(httpClientConfiguration
				.getDefaultMaxPerRoute());
		final Builder builder = RequestConfig.custom();		
		builder.setConnectTimeout(httpClientConfiguration.getConnectTimeout());
		builder.setConnectionRequestTimeout(httpClientConfiguration.getConnectionRequestTimeout());
		builder.setSocketTimeout(httpClientConfiguration.getSocketTimeout());
		requestConfig = builder.build();
		final HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setConnectionManager(connManager);
		httpclient = httpClientBuilder.build();

	}

}
