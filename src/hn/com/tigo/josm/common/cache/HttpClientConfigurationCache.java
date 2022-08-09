/**
 * HttpClientConfigurationCache.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.cache;

import hn.com.tigo.josm.common.configuration.dto.HttpClientConfiguration;
import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.bind.JAXBException;

/**
 * HttpClientConfigurationCache.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 13/08/2015 10:55:49 AM
 */
public class HttpClientConfigurationCache extends Cache<HttpClientConfiguration, HttpClientException> {

	private final String httpConfigName;

	/**
	 * Instantiates a new http client configuration cache.
	 */
	public HttpClientConfigurationCache(final String httpConfigName) {
		super("./properties/invoker/configuration.json");
		this.httpConfigName = httpConfigName;
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.cache.Cache#loadData()
	 */
	@Override
	public HttpClientConfiguration loadData() throws HttpClientException {

		HttpClientConfiguration httpClientConfiguration = new HttpClientConfiguration();

		try {
			final ConfigurationJosmRemote configurationJosmRemote = getConfiguration();
			final byte[] file = configurationJosmRemote.getFileFromSystem(this.path);
			
			// Loading the configuration
			final JsonObject jsonObj = this.deserialize(file);
			httpClientConfiguration.setConnectionRequestTimeout(jsonObj.getJsonObject(httpConfigName).getInt("connectionRequestTimeout"));
			httpClientConfiguration.setConnectTimeout(jsonObj.getJsonObject(httpConfigName).getInt("connectTimeout"));
			httpClientConfiguration.setDefaultMaxPerRoute(jsonObj.getJsonObject(httpConfigName).getInt("defaultMaxPerRoute"));
			httpClientConfiguration.setMaxTotal(jsonObj.getJsonObject(httpConfigName).getInt("maxTotal"));
			httpClientConfiguration.setSocketTimeout(jsonObj.getJsonObject(httpConfigName).getInt("socketTimeout"));
			super.expiration = jsonObj.getJsonObject(httpConfigName).getInt("expirationTimeCache");
		} catch (ServiceLocatorException | JAXBException | IOException e) {
			throw new HttpClientException(e.getCause().getMessage(), e);
		}

		return httpClientConfiguration;
	}

	private JsonObject deserialize(final byte[] content) throws IOException {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(content);
				JsonReader reader = Json.createReader(bais)) {
			return reader.readObject();
		}
	}

}
