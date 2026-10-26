import exceptions.AccountFrozenException;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account and its transaction history.
 */
public class BankAccount {

    private double balance;
    private boolean frozen;
    private final String ownerName;
    private final List<Transaction> transactionHistory;

    /**
     * Creates a bank account with an empty owner name.
     */
    public BankAccount() {
        this("");
    }

    /**
     * Creates a bank account for the specified owner.
     *
     * @param ownerName the account owner's name
     */
    public BankAccount(String ownerName) {
        this.balance = 0.0;
        this.frozen = false;
        this.ownerName = ownerName == null ? "" : ownerName;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Returns the account owner's name.
     *
     * @return the account owner's name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Returns a copy of the transaction history.
     *
     * @return the transaction history
     */
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    
    /**
     * Deposits money into the account.
     *
     * @param amount the amount to deposit
     * @throws AccountFrozenException if the account is frozen
     * @throws InvalidAmountException if the amount is invalid
     */
    public void deposit(double amount)
        throws AccountFrozenException, InvalidAmountException {

    if (frozen) {
        throw new AccountFrozenException(
                "Account is FROZEN. Unable to transact.");
    }

    if (amount <= 0 || !Double.isFinite(amount)) {
        throw new InvalidAmountException(
                "Invalid amount. Must be greater than 0");
    }

    balance += amount;

    transactionHistory.add(
            new Transaction("Deposit", amount));

    System.out.printf("Amount deposited: %.2f%n", amount);
    System.out.printf("Current balance: %.2f%n", balance);
}

    
    /**
     * Withdraws money from the account.
     *
     * @param amount the amount to withdraw
     * @throws AccountFrozenException if the account is frozen
     * @throws InvalidAmountException if the amount is invalid
     * @throws InsufficientFundsException if the balance is insufficient
     */
    public void withdraw(double amount)
        throws AccountFrozenException,
        InvalidAmountException,
        InsufficientFundsException {

    if (frozen) {
        throw new AccountFrozenException(
                "Account is FROZEN. Unable to transact.");
    }

    if (amount <= 0 || !Double.isFinite(amount)) {
        throw new InvalidAmountException(
                "Invalid amount. Must be greater than 0");
    }

    if (amount > balance) {
        throw new InsufficientFundsException(
                String.format(
                        "Insufficient balance. Current balance: %.2f",
                        balance));
    }

    balance -= amount;

    transactionHistory.add(
            new Transaction("Withdraw", amount));

    System.out.printf("Amount withdrawn: %.2f%n", amount);
    System.out.printf("Current balance: %.2f%n", balance);
}


    /**
     * Returns the current balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Freezes the account.
     */
    public void freezeAccount() {
        frozen = true;
    }

    /**
     * Unfreezes the account.
     */
    public void unfreezeAccount() {
        frozen = false;
    }

    /**
     * Checks whether the account is frozen.
     *
     * @return true if the account is frozen
     */
    public boolean isFrozen() {
        return frozen;
    }
}
