package hn.com.tigo.josm.common.exceptions;

/**
 * HttpClientException.
 *
 * @author harold.castillo
 * @version 1.0
 * @since 09-27-2016 04:57:46 PM
 */
public class HttpClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpClientException(final String message) {
		super(message);
	}

	public HttpClientException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	public HttpClientException(final Throwable cause) {
		super(cause);
	}

}
