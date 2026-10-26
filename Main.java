
import exceptions.AccountFrozenException;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

import java.util.List;

/**
 * Demonstrates the required Exercise 3 test cases.
 */
public class Main {

    private static final String LINE =
            "==================================================";

    private static final String DIVIDER =
            "--------------------------------------------------";

    /**
     * Runs the hard-coded Exercise 3 test cases.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        BankAccountManager manager = new BankAccountManager();
        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println(LINE);
        System.out.println("             BANK ACCOUNT MANAGER");
        System.out.println(LINE);

        /*
         * Prepare the account history required by test cases 6 and 7.
         * The starting balance after these transactions is 500.125.
         */
        try {
            acc1.deposit(1000.125);
            acc1.withdraw(500);
        } catch (AccountFrozenException
                | InvalidAmountException
                | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n" + DIVIDER);
        System.out.println("EXERCISE 3 - TEST CASES");
        System.out.println(DIVIDER);

        // Test Case 1: Deposit with negative amount.
        System.out.println("\nTEST CASE 1: Deposit with negative amount");
        try {
            acc1.deposit(-500);
        } catch (AccountFrozenException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // Test Case 2: Deposit when account is frozen.
        System.out.println("\nTEST CASE 2: Deposit when account is frozen");
        acc1.freezeAccount();

        try {
            acc1.deposit(11500);
        } catch (AccountFrozenException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        acc1.unfreezeAccount();

        // Test Case 3: Withdraw with negative amount.
        System.out.println("\nTEST CASE 3: Withdraw with negative amount");
        try {
            acc1.withdraw(-100);
        } catch (AccountFrozenException
                | InvalidAmountException
                | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Test Case 4: Withdraw with insufficient funds.
        System.out.println("\nTEST CASE 4: Withdraw with insufficient funds");
        try {
            acc1.withdraw(1500);
        } catch (AccountFrozenException
                | InvalidAmountException
                | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Test Case 5: Withdraw when account is frozen.
        System.out.println("\nTEST CASE 5: Withdraw when account is frozen");
        acc1.freezeAccount();

        try {
            acc1.withdraw(500);
        } catch (AccountFrozenException
                | InvalidAmountException
                | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        acc1.unfreezeAccount();

        /*
         * Complete the successful 100.00 withdrawal needed for
         * the lambda-expression test cases.
         */
        try {
            acc1.withdraw(100);
        } catch (AccountFrozenException
                | InvalidAmountException
                | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        List<Transaction> history = acc1.getTransactionHistory();

        // Test Case 6: Filter transactions at or above 200.
        System.out.println("\n" + DIVIDER);
        System.out.println("TEST CASE 6: Filter transactions at or above 200");
        System.out.println(DIVIDER);

        System.out.println("Filtering transactions at or above 200...");

        List<Transaction> filtered =
                manager.filterTransactionsAtOrAbove(
                        200, acc1.getTransactionHistory());

        System.out.println(filtered);

        // Test Case 7: Sort transactions by amount.
        System.out.println("\n" + DIVIDER);
        System.out.println("TEST CASE 7: Sort transactions by amount");
        System.out.println(DIVIDER);

        System.out.println("Sorting transactions by amount...");

        List<Transaction> sorted =
                manager.sortTransactionsByAmount(
                        acc1.getTransactionHistory());

        System.out.println(sorted);

        // Display the final account status.
        System.out.println("\n" + DIVIDER);
        System.out.println("FINAL ACCOUNT STATUS");
        System.out.println(DIVIDER);
        System.out.println("Account Owner : " + acc1.getOwnerName());
        System.out.printf("Final Balance : %.2f%n", acc1.getBalance());
        System.out.println(
                "Account Status: "
                        + (acc1.isFrozen() ? "FROZEN" : "ACTIVE"));

        // Register accounts with the manager.
        System.out.println("\n" + DIVIDER);
        System.out.println("ACCOUNT REGISTRATION");
        System.out.println(DIVIDER);

        manager.addAccount(acc1);
        manager.addAccount(new SavingsAccount("Test1"));

        System.out.println("\n" + DIVIDER);
        System.out.println("MANAGED ACCOUNTS");
        System.out.println(DIVIDER);

        manager.listAccounts();

        System.out.println("\n" + LINE);
        System.out.println("       END OF ACCOUNT MANAGEMENT REPORT");
        System.out.println(LINE);
    }
}
