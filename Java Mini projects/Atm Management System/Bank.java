import java.util.HashMap;

public class Bank {
    private String bankName;
    private HashMap<String, Account> accounts;
    private double atmCashBalance;

    public Bank(String bankName, double initialAtmCash) {
        this.bankName = bankName;
        this.accounts = new HashMap<>();
        this.atmCashBalance = initialAtmCash;
    }

    public String getBankName() {
        return bankName;
    }

    public boolean createAccount(String accountNumber, String accountHolderName, String pin, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            return false; // Account already exists
        }
        
        if (pin.length() != 4 || !pin.matches("\\d+")) {
            return false; // Invalid PIN format
        }
        
        Account newAccount = new Account(accountNumber, accountHolderName, pin, initialBalance);
        accounts.put(accountNumber, newAccount);
        return true;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public boolean closeAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setActive(false);
            return true;
        }
        return false;
    }

    public double getAtmCashBalance() {
        return atmCashBalance;
    }

    public boolean addCashToAtm(double amount) {
        if (amount > 0) {
            atmCashBalance += amount;
            return true;
        }
        return false;
    }

    public boolean deductCashFromAtm(double amount) {
        if (amount > 0 && amount <= atmCashBalance) {
            atmCashBalance -= amount;
            return true;
        }
        return false;
    }

    public int getTotalAccounts() {
        return accounts.size();
    }

    public int getActiveAccountsCount() {
        int count = 0;
        for (Account account : accounts.values()) {
            if (account.isActive()) {
                count++;
            }
        }
        return count;
    }

    public double getTotalBankDeposits() {
        double total = 0;
        for (Account account : accounts.values()) {
            if (account.isActive()) {
                total += account.getBalance();
            }
        }
        return total;
    }
}