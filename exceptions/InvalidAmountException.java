
package exceptions;

/**
 * Indicates that a transaction amount is invalid.
 */
public class InvalidAmountException extends Exception {

    private final String message;

    /**
     * Creates an exception with the specified message.
     *
     * @param message the error message
     */
    public InvalidAmountException(String message) {
        this.message = message;
    }

    /**
     * Returns the error message.
     *
     * @return the error message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
