
package exceptions;

/**
 * Indicates that a transaction was attempted on a frozen account.
 */
public class AccountFrozenException extends Exception {

    private final String message;

    /**
     * Creates an exception with the specified message.
     *
     * @param message the error message
     */
    public AccountFrozenException(String message) {
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
