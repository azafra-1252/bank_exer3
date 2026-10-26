import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manages bank accounts using a map of account IDs.
 */
public class BankAccountManager implements Bank {

    private static final int MAX_ACCOUNTS = 100;

    private final Map<Integer, BankAccount> accounts;
    private int id;

    /**
     * Creates a new account manager.
     */
    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    /**
     * Adds an account and assigns it an ID.
     *
     * @param account the account to add
     * @return the assigned account ID
     */
    @Override
    public int addAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException(
                    "Account cannot be null");
        }

        if (accounts.size() >= MAX_ACCOUNTS) {
            throw new IllegalStateException(
                    "Maximum account limit reached");
        }

        int assignedId = id;
        accounts.put(assignedId, account);
        id++;

        System.out.println(
                "Account added successfully with ID: "
                        + assignedId);

        return assignedId;
    }

    /**
     * Retrieves an account by its ID.
     *
     * @param id the account ID
     * @return the account, or null if not found
     */
    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    /**
     * Displays all accounts in ascending ID order.
     */
    public void listAccounts() {
        Map<Integer, BankAccount> sortedAccounts =
                new TreeMap<>(accounts);

        for (Map.Entry<Integer, BankAccount> entry
                : sortedAccounts.entrySet()) {

            BankAccount account = entry.getValue();

            System.out.printf(
                    "Account ID: %d, Account Name: %s, Balance: %.2f%n",
                    entry.getKey(),
                    account.getOwnerName(),
                    account.getBalance()
            );
        }
    }
  
    /**
     * Filters transactions whose amounts meet or exceed the given amount.
     *
     * @param amount the minimum transaction amount
     * @param txList the list of transactions to filter
     * @return a list containing transactions at or above the amount
     */
    public List<Transaction> filterTransactionsAtOrAbove(
            double amount, List<Transaction> txList) {

        Predicate<Transaction> amountPredicate =
                transaction -> transaction.getAmount() >= amount;

        return txList.stream()
                .filter(amountPredicate)
                .collect(Collectors.toList());
    }
    
    /**
     * Sorts transactions by amount in ascending order.
     *
     * @param txList the list of transactions to sort
     * @return a new list sorted from smallest to largest amount
     */
    public List<Transaction> sortTransactionsByAmount(
            List<Transaction> txList) {

        Comparator<Transaction> amountComparator =
                (first, second) ->
                        Double.compare(
                                first.getAmount(),
                                second.getAmount());

        return txList.stream()
                .sorted(amountComparator)
                .collect(Collectors.toList());
    }

}
