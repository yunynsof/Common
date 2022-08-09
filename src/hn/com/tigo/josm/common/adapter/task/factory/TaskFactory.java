package hn.com.tigo.josm.common.adapter.task.factory;

import hn.com.tigo.josm.common.adapter.task.Task;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.management.ObjectName;
import javax.management.MalformedObjectNameException;

import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TreeMap;

/**
 *
 * @author Peter Galdámez
 */
public class TaskFactory {

    private static final Logger log = Logger.getLogger(TaskFactory.class);
    private static final String INNER_TASK_NAME = "TaskFactory";
    private static final String INNER_ADAPTER_NAME = "josm.commons";
    private static final Map<String, TaskDescriptor> TASKS = new HashMap<>();
    private static String adapterName;
    private static String taskName;

    public static Task newTaskInstance(String adaptername, String taskname) throws TaskFactoryException {
        return newTaskDescriptor(adaptername, taskname).getTask();
    }

    public static Task newTaskInstance(String taskname) throws TaskFactoryException {
        return newTaskInstance(null, taskname);
    }
    
    public static TaskDescriptor newTaskDescriptor(String adaptername, String taskname) throws TaskFactoryException{
        initializeVariables(adaptername, taskname);
        String key = (!TaskFactory.adapterName.isEmpty() ? TaskFactory.adapterName.concat(".").concat(TaskFactory.taskName) : TaskFactory.taskName);

        if (TASKS.containsKey(key)) {
            return TASKS.get(key);
        }

        TaskDescriptor descriptor = createNewInstance();
        if (descriptor != null){
            TASKS.put(key, descriptor);
            return TASKS.get(key);
        }
        
        return null;
    }

    private static Task newInstance(String jndi) {
        try {
            InitialContext ic = new InitialContext();
            Object obj = ic.lookup(jndi);
            return (Task) obj;
        } catch (NamingException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public static String retieveJNDI(String adaptername, String taskname) throws TaskFactoryException {
        return newTaskDescriptor(adaptername, taskname).getJndi();
    }
    
    public static String retieveWSDL(String adaptername, String taskname) throws TaskFactoryException {
        return newTaskDescriptor(adaptername, taskname).getWsdl();
    }

    private static TaskDescriptor retrieveTaskDescriptor() throws TaskFactoryException {
        TaskDescriptor descriptor = initializeTaskDescriptor();
        Map<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        /*try {
            boolean validateAdapter = !TaskFactory.adapterName.isEmpty();
            ObjectName name = new ObjectName(configuration.getFormattedQuery(TaskFactory.taskName));
            Set<ObjectName> mbeans = con.getConnection().queryNames(name, null);
            String jndi = "";
            String wsdl = "";
            
            if (!validateAdapter && mbeans.size() > 1) {
                throw new TaskFactoryException(TaskFactoryErrors.MULTIPLETASK);
            }
                        
            boolean assignJndi = !validateAdapter;
            /*for (ObjectName mbeanName : mbeans) {
                if (con.getConnection().isRegistered(mbeanName)) {
                    if (validateAdapter) {
                        assignJndi = mbeanName.getKeyProperty("ApplicationRuntime").toLowerCase().contains(TaskFactory.adapterName.toLowerCase());
                    }

                    if (assignJndi) {
                        map.putAll(mbeanName.getKeyPropertyList());
                        map.put("ip", descriptor.getIpaddress());
                        jndi = configuration.buildJNDI(map);
                        wsdl = configuration.buildWSDL(map);
                    }
                }
            }

            descriptor.setJndi(jndi);
            descriptor.setWsdl(wsdl);
        } catch (IOException | MalformedObjectNameException ex) {
            log.error(ex.getLocalizedMessage());
        }*/

        return descriptor;
    }

    private static void initializeVariables(String adaptername, String taskname) {
        TaskFactory.adapterName = (adaptername != null ? adaptername : "");
        TaskFactory.taskName = (taskname != null ? taskname : "");
    }
    
    private static TaskDescriptor initializeTaskDescriptor() {
        try {
            TaskDescriptor descriptor = new TaskDescriptor();
            InetAddress server = InetAddress.getLocalHost();
            descriptor.setHost(server.getHostName());
            descriptor.setIpaddress(server.getHostAddress());
            descriptor.setServerid(server.toString());

            return descriptor;
        } catch (UnknownHostException ex) {
            log.error(ex.getLocalizedMessage());
        }
        return new TaskDescriptor();
    }

    private static TaskDescriptor createNewInstance() throws TaskFactoryException {
        TaskDescriptor descriptor = retrieveTaskDescriptor();

        if (!descriptor.getJndi().isEmpty()) {
            Task resultTask = TaskFactory.newInstance(descriptor.getJndi());
            descriptor.setTask(resultTask);

            return descriptor;
        }

        return null;
    }

    /*private static class InnerTask extends AbstractTask implements Task {

        @Override
        protected String getTaskName() {
            return INNER_TASK_NAME;
        }

        @Override
        protected String getAdapterName() {
            return INNER_ADAPTER_NAME;
        }

        @Override
        public HashMap<String, String> getTaskConfiguration() {
            return super.getTaskConfiguration();
        }

        @Override
        public ExecuteTaskResponseType executeTask(ExecuteTaskRequestType task) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }*/
}
