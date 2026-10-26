
/**
 * Defines operations for managing bank accounts.
 */
public interface Bank {

    /**
     * Adds an account to the manager.
     *
     * @param account the account to add
     * @return the assigned account ID
     */
    int addAccount(BankAccount account);

    /**
     * Retrieves an account using its ID.
     *
     * @param id the account ID
     * @return the account, or null if not found
     */
    BankAccount getAccount(int id);
}
