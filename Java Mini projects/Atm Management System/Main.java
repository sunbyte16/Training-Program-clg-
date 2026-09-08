import java.util.Scanner;

public class Main {
    private static Bank bank;
    private static ATM atm;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize the system
        initializeSystem();
        
        // Main application loop
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = getIntInput(1, 3);
            
            switch (choice) {
                case 1:
                    // ATM Operations
                    if (atm.login()) {
                        atmMenu();
                    }
                    break;
                case 2:
                    // Admin Operations
                    adminMenu();
                    break;
                case 3:
                    // Exit
                    running = false;
                    System.out.println("Thank you for using our ATM System. Goodbye!");
                    break;
            }
        }
        
        scanner.close();
    }

    private static void initializeSystem() {
        scanner = new Scanner(System.in);
        
        // Create bank with initial ATM cash
        bank = new Bank("National Bank", 100000.0);
        
        // Create ATM instance
        atm = new ATM(bank);
        
        // Create some sample accounts for testing
        createSampleAccounts();
        
        System.out.println("=== ATM MANAGEMENT SYSTEM ===");
        System.out.println("System initialized successfully.");
        System.out.println("Bank: " + bank.getBankName());
        System.out.println("Total Accounts: " + bank.getTotalAccounts());
        System.out.println("ATM Cash Available: $" + String.format("%.2f", bank.getAtmCashBalance()));
        System.out.println();
    }

    private static void createSampleAccounts() {
        // Sample Account 1
        bank.createAccount("1001", "Sunil Kumar", "1234", 5000.0);
        
        // Sample Account 2
        bank.createAccount("1002", "Ajay Sharma", "5678", 2500.0);
        
        // Sample Account 3
        bank.createAccount("1003", "Raju Sharma", "9012", 10000.0);
        
        // Sample Account 4
        bank.createAccount("1004", "Ranjit Sharma", "3456", 7500.0);
        
        System.out.println("Sample accounts created for testing:");
        System.out.println("Account 1001 - Sunil Kumar - PIN: 1234");
        System.out.println("Account 1002 - Ajay Sharma - PIN: 5678");
        System.out.println("Account 1003 - Raju Sharma - PIN: 9012");
        System.out.println("Account 1004 - Ranjit Sharma - PIN: 3456");
        System.out.println();
    }

    private static void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. ATM Operations");
        System.out.println("2. Admin Operations");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void atmMenu() {
        boolean loggedIn = true;
        
        while (loggedIn) {
            showATMMenu();
            int choice = getIntInput(1, 9);
            
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.withdrawCash();
                    break;
                case 3:
                    atm.depositCash();
                    break;
                case 4:
                    atm.changePin();
                    break;
                case 5:
                    atm.showTransactionHistory();
                    break;
                case 6:
                    atm.printMiniStatement();
                    break;
                case 7:
                    atm.transferFunds();
                    break;
                case 8:
                    atm.showAccountInfo();
                    break;
                case 9:
                    atm.logout();
                    loggedIn = false;
                    break;
            }
            
            if (loggedIn) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void showATMMenu() {
        System.out.println("\n=== ATM SERVICES ===");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Cash Deposit");
        System.out.println("4. PIN Change");
        System.out.println("5. Transaction History");
        System.out.println("6. Mini Statement");
        System.out.println("7. Fund Transfer");
        System.out.println("8. Account Information");
        System.out.println("9. Logout");
        System.out.print("Enter your choice: ");
    }

    private static void adminMenu() {
        boolean adminRunning = true;
        
        while (adminRunning) {
            showAdminMenu();
            int choice = getIntInput(1, 7);
            
            switch (choice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    addCashToATM();
                    break;
                case 4:
                    viewBankStatistics();
                    break;
                case 5:
                    closeAccount();
                    break;
                case 6:
                    viewAccountDetails();
                    break;
                case 7:
                    adminRunning = false;
                    break;
            }
            
            if (adminRunning) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void showAdminMenu() {
        System.out.println("\n=== ADMIN MENU ===");
        System.out.println("1. Create New Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Add Cash to ATM");
        System.out.println("4. View Bank Statistics");
        System.out.println("5. Close Account");
        System.out.println("6. View Account Details");
        System.out.println("7. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void createNewAccount() {
        System.out.println("=== CREATE NEW ACCOUNT ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        if (bank.accountExists(accountNumber)) {
            System.out.println("Account number already exists!");
            return;
        }
        
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        
        System.out.print("Enter 4-digit PIN: ");
        String pin = scanner.nextLine();
        
        System.out.print("Enter Initial Deposit Amount: ");
        try {
            double initialBalance = Double.parseDouble(scanner.nextLine());
            
            if (initialBalance < 0) {
                System.out.println("Initial deposit cannot be negative.");
                return;
            }
            
            if (bank.createAccount(accountNumber, accountHolderName, pin, initialBalance)) {
                System.out.println("Account created successfully!");
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Account Holder: " + accountHolderName);
                System.out.println("Initial Balance: $" + String.format("%.2f", initialBalance));
            } else {
                System.out.println("Failed to create account. Invalid PIN format.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }

    private static void viewAllAccounts() {
        System.out.println("=== ALL ACCOUNTS ===");
        System.out.println("Total Accounts: " + bank.getTotalAccounts());
        System.out.println("Active Accounts: " + bank.getActiveAccountsCount());
        System.out.println();
        
        // This would require a method in Bank to return all accounts
        // For now, we'll show sample accounts
        System.out.println("Sample Accounts:");
        System.out.println("1001 - Sunil Kumar - Balance: $" + String.format("%.2f", bank.getAccount("1001").getBalance()));
        System.out.println("1002 - Ajay Sharma - Balance: $" + String.format("%.2f", bank.getAccount("1002").getBalance()));
        System.out.println("1003 - Raju Sharma - Balance: $" + String.format("%.2f", bank.getAccount("1003").getBalance()));
        System.out.println("1004 - Ranjit Sharma - Balance: $" + String.format("%.2f", bank.getAccount("1004").getBalance()));
    }

    private static void addCashToATM() {
        System.out.println("=== ADD CASH TO ATM ===");
        System.out.println("Current ATM Balance: $" + String.format("%.2f", bank.getAtmCashBalance()));
        System.out.print("Enter amount to add: ");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }
            
            if (bank.addCashToAtm(amount)) {
                System.out.println("Cash added successfully!");
                System.out.println("New ATM Balance: $" + String.format("%.2f", bank.getAtmCashBalance()));
            } else {
                System.out.println("Failed to add cash.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }

    private static void viewBankStatistics() {
        System.out.println("=== BANK STATISTICS ===");
        System.out.println("Bank Name: " + bank.getBankName());
        System.out.println("Total Accounts: " + bank.getTotalAccounts());
        System.out.println("Active Accounts: " + bank.getActiveAccountsCount());
        System.out.println("Total Deposits: $" + String.format("%.2f", bank.getTotalBankDeposits()));
        System.out.println("ATM Cash Balance: $" + String.format("%.2f", bank.getAtmCashBalance()));
    }

    private static void closeAccount() {
        System.out.println("=== CLOSE ACCOUNT ===");
        System.out.print("Enter Account Number to close: ");
        String accountNumber = scanner.nextLine();
        
        if (bank.closeAccount(accountNumber)) {
            System.out.println("Account closed successfully!");
        } else {
            System.out.println("Account not found or already closed.");
        }
    }

    private static void viewAccountDetails() {
        System.out.println("=== ACCOUNT DETAILS ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = bank.getAccount(accountNumber);
        
        if (account != null) {
            System.out.println(account.toString());
            System.out.println("\nRecent Transactions:");
            for (Transaction transaction : account.getTransactionHistory()) {
                System.out.println(transaction.toString());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.print("Invalid choice. Please enter between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}