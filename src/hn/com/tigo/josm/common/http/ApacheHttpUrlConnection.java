package hn.com.tigo.josm.common.http;

import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.common.spr.IdleConnectionMonitorThread;

import java.io.Closeable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * SprApacheHttpConection.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 17/11/2015 02:15:06 AM 2015
 */
public class ApacheHttpUrlConnection implements Closeable {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(ApacheHttpUrlConnection.class);
	
	/** The Constant CLOSE_IDLE_TIME. */
	private static final int CLOSE_IDLE_TIME = 20000;
	
	/** The Constant RETRY_NUMBER. */
	private static final int RETRY_NUMBER = 3;
	
	/** The _request executor. */
	private HttpRequestExecutor _requestExecutor;
	
	/** The client connection. */
	private HttpClientConnection _clientConnection;
	
	/** The context. */
	private HttpClientContext _context;
	
	/** The manager. */
	private BasicHttpClientConnectionManager _manager;
	
	/** The route. */
	private HttpRoute _route;
	
	/** The connect timeout. */
	private int _connectTimeout;
	
	/** The _read timeout. */
	private int _readTimeout;
	
	/** The _id thread. */
	private IdleConnectionMonitorThread _idThread; 

	/**
	 * Instantiates a new spr apache http conection.
	 *
	 * @param readTimeout the read timeout
	 * @param connectTimeout the connect timeout
	 * @throws AdapterException the adapter exception
	 */
	public ApacheHttpUrlConnection(final int readTimeout, final int connectTimeout) throws AdapterException {
		
		
		_connectTimeout = connectTimeout;
		_readTimeout = readTimeout;
		
		_manager = new BasicHttpClientConnectionManager();
		_context = HttpClientContext.create();

		_requestExecutor = new HttpRequestExecutor();
		
		_idThread = new IdleConnectionMonitorThread(_manager);
		_idThread.setName("IdleConnectionMonitorThread_Notify");
		_idThread.start();
		
	}

	
	/**
	 * Send http request.
	 *
	 * @param hostIp the host ip
	 * @param port the port
	 * @param request the request
	 * @param statusCodeExpected the status code expected
	 * @return the string
	 * @throws AdapterException the adapter exception
	 */
	public String sendHttpRequest(final String hostIp, final int port, final HttpRequest request, final int statusCodeExpected) throws AdapterException {
		
		String outResult = "";

		try {

			final HttpHost host = new HttpHost(hostIp, port, "http");
			_route = new HttpRoute(host);
			_context.setTargetHost(host);

			HttpResponse httpResponse = null; 
			int retry = 0;
			boolean success = false;
			while (!success && retry < RETRY_NUMBER) {
				try {
					final ConnectionRequest connRequest = _manager.requestConnection(_route, null);
					_clientConnection = connRequest.get(_connectTimeout, TimeUnit.MILLISECONDS);
					if(!_clientConnection.isOpen()){
						_manager.connect(_clientConnection, _route, _connectTimeout, _context);
						_manager.routeComplete(_clientConnection, _route, _context);
						_clientConnection.setSocketTimeout(_readTimeout);
					}
					httpResponse = _requestExecutor.execute(request, _clientConnection, _context);
					success= true;
				} catch (NoHttpResponseException e) {
					retry++;
				} finally {
					_manager.releaseConnection(_clientConnection, null, CLOSE_IDLE_TIME, TimeUnit.MILLISECONDS);
				}
			}
			if(httpResponse != null){
				if (httpResponse.getStatusLine().getStatusCode() != statusCodeExpected) {
					final String error = "Failed : HTTP error code : " + httpResponse.getStatusLine().getStatusCode();
					throw new AdapterException(AdapterErrorCode.COMMUNICATION_ERROR.getError(),error);
				}
				if(httpResponse.getEntity() != null){
					outResult = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.ISO_8859_1);
				}
			}

		} catch (MalformedURLException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR.getError(), e.getMessage());
		} catch (IOException e) {
			try {
				_clientConnection.close();
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage(), e1);
			}
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR.getError(), e.getMessage());
		} catch (HttpException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR.getError(), e.getMessage());
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR.getError(), e.getMessage());
		} 
		
		LOGGER.info(outResult.toString());
		return outResult.toString();
	}
	
	
	/* (non-Javadoc)
	 * @see java.io.Closeable#close()
	 */
	@Override
	public void close() throws IOException {

		try {
			_idThread.shutdown();
			_manager.close();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

}
