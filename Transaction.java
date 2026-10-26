
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deposit or withdrawal transaction.
 */
public class Transaction {

    private final String type;
    private final double amount;
    private final LocalDateTime time_stamp;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Creates a transaction with the current timestamp.
     *
     * @param type the transaction type
     * @param amount the transaction amount
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    /**
     * Returns the transaction type.
     *
     * @return the transaction type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the transaction amount.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the transaction timestamp.
     *
     * @return the transaction timestamp
     */
    public LocalDateTime getTimeStamp() {
        return time_stamp;
    }

    /**
     * Returns the transaction details.
     *
     * @return the formatted transaction details
     */
    @Override
    public String toString() {
        return String.format(
                "Transaction [type=%s, amount=%s, time_stamp=%s]",
                type,
                Double.toString(amount),
                time_stamp.format(FORMATTER)
        );
    }
}
