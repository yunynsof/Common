package hn.com.tigo.josm.common.adapter.task.server;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Peter Galdámez
 */
public class ServerConfig {
    private String host;
    private int port;
    private String user;
    private String password;
    private String protocol;
    private String jndiroot;
    private String protocolProviderPackages;
    private String mserver;
    private String domain;
    private String jndiprefix;
    private String query;
    private String jndiformat;
    private String jndidefinition;
    private String wsdlformat;
    private String wsdldefinition;

    public String getWsdldefinition() {
        if (wsdldefinition == null)
            wsdldefinition = "";
        return wsdldefinition;
    }

    public void setWsdldefinition(String wsdldefinition) {
        this.wsdldefinition = wsdldefinition;
    }  
    
    public String getWsdlformat() {
        if (wsdlformat == null)
            wsdlformat = "";
            
        return wsdlformat;
    }

    public void setWsdlformat(String wsdlformat) {
        this.wsdlformat = wsdlformat;
    }   

    public String getJndiprefix() {
        if (jndiprefix == null) {
            jndiprefix = "";
        }
        return jndiprefix;
    }

    public void setJndiprefix(String jndiprefix) {
        this.jndiprefix = jndiprefix;
    }

    public String getQuery() {
        if (query == null) {
            query = "";
        }
        return query;
    }

    public String getFormattedQuery(String... values) {
        String s = String.format(this.getQuery(), (Object[]) values);
        return this.getDomain() + s;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDomain() {
        if (domain == null) {
            domain = "";
        }
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getHost() {
        if (host == null) {
            host = "";
        }
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public String getUser() {
        if (user == null) {
            user = "";
        }
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        if (password == null) {
            password = "";
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        if (protocol == null) {
            protocol = "";
        }
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getJndiroot() {
        if (jndiroot == null) {
            jndiroot = "";
        }
        return jndiroot;
    }

    public void setJndiroot(String jndiroot) {
        this.jndiroot = jndiroot;
    }

    public String getProtocolProviderPackages() {
        if (protocolProviderPackages == null) {
            protocolProviderPackages = "";
        }
        return protocolProviderPackages;
    }

    public void setProtocolProviderPackages(String protocolProviderPackages) {
        this.protocolProviderPackages = protocolProviderPackages;
    }
 
    public String getMserver() {
        if (mserver == null) {
            mserver = "";
        }
        return mserver;
    }
    
    public void setMserver(String mserver){
        this.mserver = mserver; 
    }

    public String getJndiformat() {
        if (jndiformat == null)
            jndiformat = "";
        return jndiformat;
    }

    public void setJndiformat(String jndiformat) {
        this.jndiformat = jndiformat;
    }

    public String getJndidefinition() {
        if (jndidefinition == null)
            jndidefinition = "";
        return jndidefinition;
    }

    public void setJndidefinition(String jndidefinition) {
        this.jndidefinition = jndidefinition;
    }
    
    private String buildDefinition(boolean isJNDI, Map<String, String> properties){
        Map<String, String> nodeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        nodeMap.putAll(this.toMap());
        nodeMap.putAll(properties);
        
        String def = (isJNDI ? this.getJndidefinition() : this.getWsdldefinition());
        String[] definition = def.split("\\,");
        
        List<String> list = new LinkedList<>();
        for (String d : definition){
            list.add(nodeMap.get(d.trim()));
        }
        
        return String.format((isJNDI ? this.getJndiformat() : this.getWsdlformat()), list.toArray());
    }
    
    public String buildJNDI(Map<String, String> properties){
        return buildDefinition(true, properties);
    }
    
    public String buildWSDL(Map<String, String> properties){
        return buildDefinition(false, properties);
    }
    
    public Map<String, String> toMap()
    {        
        //Builder<ServerConfig> builder = BuilderFactory.getBuilder(this.getClass());
        //return builder.build(this).getValues();
    	return null;
    }
    
    public String getURL() {
        StringBuilder url = new StringBuilder();

        if (!this.getProtocol().isEmpty()) {
            url.append(this.getProtocol());
            url.append("//");
        }

        if (!this.getHost().isEmpty()) {
            url.append(this.getHost());
            if (this.getPort() > 0) {
                url.append(":");
                url.append(String.valueOf(this.getPort()));
            }
        }

        url.append(this.getJndiroot());
        url.append(this.getMserver());
        return url.toString();
    }

    @Override
    public String toString() {
        return this.getURL();
    }
}
