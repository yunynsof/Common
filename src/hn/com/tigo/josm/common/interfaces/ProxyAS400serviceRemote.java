package hn.com.tigo.josm.common.interfaces;

import hn.com.tigo.josm.common.proxy.as400.dto.ProxyAs400RequestType;

import javax.ejb.Remote;

/**
 * The Interface ProxyAS400serviceRemote.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version
 * @since 24-nov-2014 14:48:20 2014
 */
@Remote
public interface ProxyAS400serviceRemote {

	/**
	 * Gets the proxy a s400service.
	 * 
	 * @param proxyAs400RequestType
	 *            the proxy as400 request type
	 * @return the proxy a s400service
	 */
	Boolean getProxyAS400service(final ProxyAs400RequestType proxyAs400RequestType);

}
