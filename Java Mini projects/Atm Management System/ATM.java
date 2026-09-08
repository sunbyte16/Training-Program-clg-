import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Account currentAccount;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.currentAccount = null;
        this.scanner = new Scanner(System.in);
    }

    // Authentication System
    public boolean login() {
        System.out.println("=== ATM LOGIN ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        Account account = bank.getAccount(accountNumber);
        
        if (account != null && account.validatePin(pin) && account.isActive()) {
            currentAccount = account;
            System.out.println("Login Successful!");
            System.out.println("Welcome, " + account.getAccountHolderName());
            return true;
        } else {
            System.out.println("Login Failed! Invalid account number, PIN, or account is inactive.");
            return false;
        }
    }

    public void logout() {
        currentAccount = null;
        System.out.println("Logged out successfully. Thank you for using our ATM!");
    }

    // Balance Inquiry
    public void checkBalance() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }
        
        System.out.println("=== BALANCE INQUIRY ===");
        System.out.println("Account: " + currentAccount.getAccountNumber());
        System.out.println("Account Holder: " + currentAccount.getAccountHolderName());
        System.out.println("Current Balance: $" + String.format("%.2f", currentAccount.getBalance()));
    }

    // Cash Withdrawal
    public void withdrawCash() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("=== CASH WITHDRAWAL ===");
        System.out.println("Current Balance: $" + String.format("%.2f", currentAccount.getBalance()));
        System.out.println("ATM Cash Available: $" + String.format("%.2f", bank.getAtmCashBalance()));
        System.out.print("Enter amount to withdraw: ");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            // Validation checks
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                return;
            }
            
            if (amount > currentAccount.getBalance()) {
                System.out.println("Insufficient balance in your account.");
                return;
            }
            
            if (amount > bank.getAtmCashBalance()) {
                System.out.println("Insufficient cash in ATM. Please try a smaller amount.");
                return;
            }
            
            if (amount % 100 != 0 && amount % 50 != 0 && amount % 20 != 0) {
                System.out.println("Amount must be in multiples of 20, 50, or 100.");
                return;
            }
            
            // Perform withdrawal
            if (currentAccount.withdraw(amount) && bank.deductCashFromAtm(amount)) {
                System.out.println("Withdrawal Successful!");
                System.out.println("Amount Withdrawn: $" + String.format("%.2f", amount));
                System.out.println("Remaining Balance: $" + String.format("%.2f", currentAccount.getBalance()));
                System.out.println("Please collect your cash.");
            } else {
                System.out.println("Withdrawal Failed. Please try again.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // Cash Deposit
    public void depositCash() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("=== CASH DEPOSIT ===");
        System.out.println("Current Balance: $" + String.format("%.2f", currentAccount.getBalance()));
        System.out.print("Enter amount to deposit: ");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            // Validation checks
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                return;
            }
            
            if (amount > 50000) {
                System.out.println("Deposit amount cannot exceed $50,000 in a single transaction.");
                return;
            }
            
            // Perform deposit
            if (currentAccount.deposit(amount) && bank.addCashToAtm(amount)) {
                System.out.println("Deposit Successful!");
                System.out.println("Amount Deposited: $" + String.format("%.2f", amount));
                System.out.println("New Balance: $" + String.format("%.2f", currentAccount.getBalance()));
            } else {
                System.out.println("Deposit Failed. Please try again.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // PIN Change
    public void changePin() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("=== PIN CHANGE ===");
        System.out.print("Enter current PIN: ");
        String oldPin = scanner.nextLine();
        
        System.out.print("Enter new 4-digit PIN: ");
        String newPin = scanner.nextLine();
        
        System.out.print("Confirm new PIN: ");
        String confirmPin = scanner.nextLine();

        // Validation
        if (!newPin.equals(confirmPin)) {
            System.out.println("PINs do not match. Please try again.");
            return;
        }
        
        if (newPin.length() != 4 || !newPin.matches("\\d+")) {
            System.out.println("PIN must be exactly 4 digits.");
            return;
        }
        
        if (oldPin.equals(newPin)) {
            System.out.println("New PIN cannot be the same as old PIN.");
            return;
        }
        
        // Change PIN
        if (currentAccount.changePin(oldPin, newPin)) {
            System.out.println("PIN changed successfully!");
            System.out.println("Please use your new PIN for future transactions.");
        } else {
            System.out.println("PIN change failed. Invalid current PIN.");
        }
    }

    // Transaction History
    public void showTransactionHistory() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("=== TRANSACTION HISTORY ===");
        System.out.println("Account: " + currentAccount.getAccountNumber());
        System.out.println("Account Holder: " + currentAccount.getAccountHolderName());
        
        var transactions = currentAccount.getTransactionHistory();
        
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\n--- Recent Transactions ---");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }
    }

    // Mini Statement
    public void printMiniStatement() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println(currentAccount.getMiniStatement());
    }

    // Transfer Funds (Additional Feature)
    public void transferFunds() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("=== FUND TRANSFER ===");
        System.out.println("Current Balance: $" + String.format("%.2f", currentAccount.getBalance()));
        System.out.print("Enter recipient account number: ");
        String recipientAccountNumber = scanner.nextLine();
        
        System.out.print("Enter amount to transfer: ");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            // Validation
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                return;
            }
            
            if (amount > currentAccount.getBalance()) {
                System.out.println("Insufficient balance.");
                return;
            }
            
            if (recipientAccountNumber.equals(currentAccount.getAccountNumber())) {
                System.out.println("Cannot transfer to your own account.");
                return;
            }
            
            Account recipientAccount = bank.getAccount(recipientAccountNumber);
            
            if (recipientAccount == null) {
                System.out.println("Recipient account not found.");
                return;
            }
            
            if (!recipientAccount.isActive()) {
                System.out.println("Recipient account is inactive.");
                return;
            }
            
            // Perform transfer
            if (currentAccount.withdraw(amount)) {
                if (recipientAccount.deposit(amount)) {
                    System.out.println("Transfer Successful!");
                    System.out.println("Amount Transferred: $" + String.format("%.2f", amount));
                    System.out.println("Remaining Balance: $" + String.format("%.2f", currentAccount.getBalance()));
                    System.out.println("Transferred to: " + recipientAccount.getAccountHolderName());
                } else {
                    // Rollback if deposit fails
                    currentAccount.deposit(amount);
                    System.out.println("Transfer failed. Please try again.");
                }
            } else {
                System.out.println("Transfer failed. Please try again.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // Account Information
    public void showAccountInfo() {
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("=== ACCOUNT INFORMATION ===");
        System.out.println(currentAccount.toString());
    }
}