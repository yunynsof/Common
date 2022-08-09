package hn.com.tigo.josm.common.adapter.task.server;

/**
 *
 * @author pgaldamez
 */
public enum ServerConnectionType {
        DOMAIN("domain"),
	RUNTIME("runtime");
	
	private final String value;
	
	private ServerConnectionType(String value){
            this.value = value;
	}
	
        @Override
	public String toString(){
            return value;
	}
	
	public static ServerConnectionType parse(String s) {
            s = s.trim().toLowerCase();
            if (s.equals(DOMAIN.toString()))
                return DOMAIN;
            else if (s.equals(RUNTIME.toString()))
                return RUNTIME;
            else
                return RUNTIME;
	}

}
