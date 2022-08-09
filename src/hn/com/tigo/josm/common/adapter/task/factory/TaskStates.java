package hn.com.tigo.josm.common.adapter.task.factory;

/**
 *
 * @author pgaldamez
 */
public enum TaskStates {
	 STARTING("STARTING"), 
     RUNNING("RUNNING"), 
     PAUSED("PAUSED"), 
     SHUTDOWN("SHUTDOWN");
      
    private final String value;
	
	private TaskStates(String value){
		this.value = value;
	}
	
        @Override
	public String toString(){
    	return value;
	}
	
	public static TaskStates parse(String s) {
        s = s.trim().toLowerCase();
        if (s.equals(STARTING.toString().toLowerCase()))
            return STARTING;
        else if (s.equals(RUNNING.toString().toLowerCase()))
            return RUNNING;
        else if (s.equals(PAUSED.toString().toLowerCase()))
            return PAUSED;
        else if (s.equals(SHUTDOWN.toString().toLowerCase()))
            return SHUTDOWN;
        else
            return STARTING;
	}
}
