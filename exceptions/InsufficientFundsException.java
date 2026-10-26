
package exceptions;

/**
 * Indicates that an account has insufficient funds.
 */
public class InsufficientFundsException extends Exception {

    private final String message;

    /**
     * Creates an exception with the specified message.
     *
     * @param message the error message
     */
    public InsufficientFundsException(String message) {
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
