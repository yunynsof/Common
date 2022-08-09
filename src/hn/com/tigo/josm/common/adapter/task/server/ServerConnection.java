package hn.com.tigo.josm.common.adapter.task.server;

import java.util.HashMap;
import java.io.IOException;
import javax.naming.Context;
import java.net.MalformedURLException;
import java.util.Properties;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnectorFactory;

/**
 *
 * @author Peter Galdámez
 */
public class ServerConnection {
    private JMXServiceURL serviceURL;
    private MBeanServerConnection connection;
    private JMXConnector connector;
    private final ServerConfig configuration;
    private final boolean initializeURL = true;
    private final String PROPERTIESFILE = "commons.properties";
    private final String USER = "USER";
    private final String PASSWORD = "PASSWORD";
    private final Properties properties = null;//Utils.getProperties(this.getClass(), PROPERTIESFILE);
    
    public ServerConnection(Properties properties) throws IOException{
        //Builder<ServerConfig> builder = BuilderFactory.getBuilder(ServerConfig.class);
        configuration = null;//builder.build(properties).getClazz();
        //initializeConnections(initializeURL);
    }
    
    public ServerConnection(String url) throws MalformedURLException, IOException {
        serviceURL = new JMXServiceURL(url);
        configuration = new ServerConfig();
        configuration.setHost(serviceURL.getHost());
        configuration.setPort(serviceURL.getPort());
        configuration.setProtocol(serviceURL.getProtocol());
        
        initializeConnections(!initializeURL);
    }

    public ServerConnection(ServerConfig config) throws MalformedURLException, IOException {
        configuration = config;
        initializeConnections(initializeURL);
    }
    
    private void initializeConnections(boolean initializeURL) throws IOException {
         if (initializeURL)
            serviceURL = new JMXServiceURL(configuration.getURL());
                  
        connector = JMXConnectorFactory.connect(serviceURL, initializeEnviroment());
        connection = connector.getMBeanServerConnection();
    }
    
    
    private HashMap<String, String> initializeEnviroment() {
        HashMap<String, String> h = new HashMap<>();
        if (configuration.getUser().isEmpty())
             configuration.setUser(properties.getProperty(USER));
        
        if (configuration.getPassword().isEmpty())
             configuration.setPassword(properties.getProperty(PASSWORD));
        
        
        h.put(Context.SECURITY_PRINCIPAL, configuration.getUser());
        h.put(Context.SECURITY_CREDENTIALS, configuration.getPassword());
        h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, configuration.getProtocolProviderPackages());
        return h;
    }
    
    public ServerConfig getConfiguration() {
        return configuration;
    }

    public JMXConnector getConnector() {
        return connector;
    }

    public MBeanServerConnection getConnection() {
        return connection;
    }

    public void close() throws IOException {
        this.getConnector().close();
    }

    public void connect() throws IOException {
        this.getConnector().connect();
    }
}
