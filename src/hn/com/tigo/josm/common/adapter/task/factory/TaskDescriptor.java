package hn.com.tigo.josm.common.adapter.task.factory;

import hn.com.tigo.josm.common.adapter.task.Task;

/**
 *
 * @author Peter Galdámez
 */
public class TaskDescriptor {
    private Task task;
    private String wsdl;
    private String jndi;
    private String host;
    private String serverid;
    private String ipaddress;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }    

    public String getWsdl() {
        if (wsdl == null)
            wsdl = "";
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getJndi() {
        if (jndi == null)
            jndi = "";
        return jndi;
    }

    public void setJndi(String jndi) {
        this.jndi = jndi;
    }

    public String getHost() {
        if (host == null)
            host = "";
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getServerid() { 
        if (serverid == null)
            serverid = "";
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid;
    }

    public String getIpaddress() {
        if (ipaddress == null)
            ipaddress = "";
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }
}
