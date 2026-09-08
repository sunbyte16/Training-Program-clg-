import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactionHistory;
    private boolean isActive;

    public Account(String accountNumber, String accountHolderName, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.isActive = true;
        
        // Record initial deposit as first transaction
        if (initialBalance > 0) {
            recordTransaction("INITIAL_DEPOSIT", initialBalance, "Account opening deposit");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public boolean changePin(String oldPin, String newPin) {
        if (validatePin(oldPin) && newPin.length() == 4 && newPin.matches("\\d+")) {
            this.pin = newPin;
            recordTransaction("PIN_CHANGE", 0, "PIN changed successfully");
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance && isActive) {
            balance -= amount;
            recordTransaction("WITHDRAWAL", amount, "Cash withdrawal");
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0 && isActive) {
            balance += amount;
            recordTransaction("DEPOSIT", amount, "Cash deposit");
            return true;
        }
        return false;
    }

    private void recordTransaction(String type, double amount, String description) {
        Transaction transaction = new Transaction(type, amount, description, balance);
        transactionHistory.add(transaction);
        
        // Keep only last 10 transactions
        if (transactionHistory.size() > 10) {
            transactionHistory.remove(0);
        }
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public String getMiniStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("=== MINI STATEMENT ===\n");
        statement.append("Account: ").append(accountNumber).append("\n");
        statement.append("Holder: ").append(accountHolderName).append("\n");
        statement.append("Current Balance: $").append(String.format("%.2f", balance)).append("\n");
        statement.append("\n--- Recent Transactions ---\n");
        
        for (Transaction transaction : transactionHistory) {
            statement.append(transaction.toString()).append("\n");
        }
        
        return statement.toString();
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + 
               "\nHolder: " + accountHolderName + 
               "\nBalance: $" + String.format("%.2f", balance) +
               "\nStatus: " + (isActive ? "Active" : "Inactive");
    }
}