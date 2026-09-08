import java.util.Date;
import java.text.SimpleDateFormat;

public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private String description;
    private double balanceAfter;
    private Date timestamp;

    public Transaction(String type, double amount, String description, double balanceAfter) {
        this.transactionId = generateTransactionId();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.balanceAfter = balanceAfter;
        this.timestamp = new Date();
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis() + 
               (int)(Math.random() * 1000);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s: $%.2f - %s (Balance: $%.2f)", 
                sdf.format(timestamp), 
                type, 
                amount, 
                description, 
                balanceAfter);
    }
}