package hn.com.tigo.josm.common.exceptions.enumerators;

/**
 * TaskFactoryErrors.
 *
 * @author Peter Galdámez
 */
public enum TaskFactoryErrors {
    
    /** The multipletask. */
    MULTIPLETASK(1, "There exist many Task with the given name. Try specifying the adapter name");

    /** The code. */
    private final int code;
    
    /** The message. */
    private final String message;

    /**
     * Instantiates a new task factory errors.
     *
     * @param code the code
     * @param message the message
     */
    private TaskFactoryErrors(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return String.format("%d: %s", code, message);

    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public int getErrorCode() {
        return code;
    }
}
