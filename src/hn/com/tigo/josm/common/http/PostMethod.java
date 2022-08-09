package hn.com.tigo.josm.common.http;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

/**
 * PostMethod.
 *
 * @author harold.castillo
 * @version 1.0
 * @param <T> the generic type
 * @since Oct 4, 2016 10:30:40 AM
 */
public abstract class PostMethod<T> extends ServiceInvoker<T> {

	/**
	 * Instantiates a new post method.
	 *
	 * @param url
	 *            the url
	 * @param buildable
	 *            the buildable
	 */
	public PostMethod(final String url, final Buildable buildable) {
		super(url, buildable);
	}

	/**
	 * Instantiates a new post method.
	 *
	 * @param url
	 *            the url
	 * @param buildable
	 *            the buildable
	 * @param properties
	 *            the properties
	 */
	public PostMethod(final String url, final Buildable buildable,
			Map<String, String> properties) {

		super(url, buildable, properties);

		httpRequestBase = new HttpPost(url);
		httpRequestBase.setConfig(buildable.getRequestConfig());

		for (Map.Entry<String, String> property : properties.entrySet()) {
			httpRequestBase.addHeader(property.getKey(), property.getValue());
		}
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.http.ServiceInvoker#loadEntity(java.lang.String, java.lang.String)
	 */
	@Override
	protected void loadEntity(final String request, final String charset)
			throws UnsupportedEncodingException {
		final HttpEntity entity = new ByteArrayEntity(request.getBytes(charset));
		((HttpEntityEnclosingRequestBase) httpRequestBase).setEntity(entity);
	}

}
