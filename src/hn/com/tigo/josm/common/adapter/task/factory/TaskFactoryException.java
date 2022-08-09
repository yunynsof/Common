package hn.com.tigo.josm.common.adapter.task.factory;

import hn.com.tigo.josm.common.exceptions.enumerators.TaskFactoryErrors;

/**
 *
 * @author Peter Galdámez
 */
public class TaskFactoryException extends Exception {

    protected String mDetails;

    public TaskFactoryException() {
        super();
    }

    public TaskFactoryException(String message, String details, Throwable t) {
        super(message, t);
        setDetails(details);
    }

    public TaskFactoryException(TaskFactoryErrors e, Throwable t) {
        this(e.toString(), t.getMessage(), t);
    }

    public TaskFactoryException(TaskFactoryErrors e) {
        super(e.toString());
    }

    public TaskFactoryException(TaskFactoryErrors e, String details) {
        super(e.toString());
        setDetails(details);
    }

    public TaskFactoryException(String message) {
        super(message);
    }

    public TaskFactoryException(String message, Throwable t) {
        super(message, t);
        setDetails(t.getMessage());
    }

    public TaskFactoryException(String message, String details) {
        super(message);
        setDetails(details);
    }

    private void setDetails(String details) {
        mDetails = details;
        if (mDetails != null && mDetails.length() > 255) {
            mDetails = mDetails.substring(0, 255);
        }
    }

    public String getDetails() {
        return mDetails;
    }

    private static final long serialVersionUID = 4447290310269629239L;
}
