package hn.com.tigo.josm.common.data;

import hn.com.tigo.josm.common.cache.Cache;
import hn.com.tigo.josm.common.exceptions.ConfigurationException;
import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;
import hn.com.tigo.josm.common.interfaces.producer.InterfaceFactory;
import hn.com.tigo.josm.common.locator.ServiceLocator;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonLoader extends Cache<JsonObject, ConfigurationException> {

	public JsonLoader(){
		super();
	}

	public JsonLoader(String path) {
		super(path);
	}

	public JsonLoader(int expiration, String path) {
		super(expiration, path);
	}

	public JsonObject loadData() throws ConfigurationException {

		JsonObject parameter = null;

		try {
			final ServiceLocator serviceLocator = ServiceLocator.getInstance();
			final ConfigurationJosmRemote config = serviceLocator.getService(InterfaceFactory.COMMON_CONFIGURATION_REMOTE);
			final byte[] a = config.getFileFromSystem(this.path);
			parameter = deserialize(a);
		} catch (ServiceLocatorException | IOException e1) {
			throw new ConfigurationException("Load configuration error",
					"Failed to load the configuration for the path "
							.concat(this.path));
		}

		return parameter;
	}

	public JsonObject loadData(final String path) throws ConfigurationException {
		this.path = path;
		return loadData();
	}

	private JsonObject deserialize(final byte[] content) throws IOException {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(content);
				JsonReader reader = Json.createReader(bais)) {
			return reader.readObject();
		}
	}

}
