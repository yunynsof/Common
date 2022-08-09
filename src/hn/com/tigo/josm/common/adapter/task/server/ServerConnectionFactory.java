package hn.com.tigo.josm.common.adapter.task.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Peter Galdámez
 */
public class ServerConnectionFactory {

    private static final Map<String, ServerConnection> CONNECTIONS = new HashMap<>();

    public static ServerConnection getServerConnection(ServerConfig configuration) throws IOException {
        //String key = (configuration.getType().equals(ServerConnectionType.RUNTIME) ? configuration.getURL() : configuration.getURLAdmin());
        try {
            if (!configuration.getURL().isEmpty()) {
                if (CONNECTIONS.containsKey(configuration.getURL())) {
                    return CONNECTIONS.get(configuration.getURL());
                }

                CONNECTIONS.put(configuration.getURL(), new ServerConnection(configuration));
                return CONNECTIONS.get(configuration.getURL());
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
}
