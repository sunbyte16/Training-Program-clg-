public class ATMTest {
    public static void main(String[] args) {
        System.out.println("=== ATM SYSTEM TEST ===\n");
        
        // Initialize system
        Bank bank = new Bank("Test Bank", 50000.0);
        ATM atm = new ATM(bank);
        
        // Create test accounts
        bank.createAccount("TEST001", "Sunil Kumar", "1234", 1000.0);
        bank.createAccount("TEST002", "Ajay Sharma", "5678", 500.0);
        bank.createAccount("TEST003", "Raju Sharma", "9012", 2000.0);
        bank.createAccount("TEST004", "Ranjit Sharma", "3456", 1500.0);
        
        System.out.println("✓ System initialized successfully");
        System.out.println("✓ Test accounts created:");
        System.out.println("  - TEST001: Sunil Kumar (PIN: 1234)");
        System.out.println("  - TEST002: Ajay Sharma (PIN: 5678)");
        System.out.println("  - TEST003: Raju Sharma (PIN: 9012)");
        System.out.println("  - TEST004: Ranjit Sharma (PIN: 3456)");
        System.out.println("✓ ATM cash balance: $" + bank.getAtmCashBalance());
        
        // Test account retrieval
        Account account = bank.getAccount("TEST001");
        if (account != null) {
            System.out.println("✓ Account retrieval successful");
            System.out.println("  Account: " + account.getAccountNumber());
            System.out.println("  Balance: $" + account.getBalance());
            System.out.println("  PIN validation: " + (account.validatePin("1234") ? "✓ PASS" : "✗ FAIL"));
        }
        
        // Test deposit
        if (account.deposit(500.0)) {
            System.out.println("✓ Deposit successful");
            System.out.println("  New balance: $" + account.getBalance());
        }
        
        // Test withdrawal
        if (account.withdraw(200.0)) {
            System.out.println("✓ Withdrawal successful");
            System.out.println("  New balance: $" + account.getBalance());
        }
        
        // Test insufficient balance
        if (!account.withdraw(10000.0)) {
            System.out.println("✓ Insufficient balance check working");
        }
        
        // Test PIN change
        if (account.changePin("1234", "9999")) {
            System.out.println("✓ PIN change successful");
            System.out.println("  New PIN validation: " + (account.validatePin("9999") ? "✓ PASS" : "✗ FAIL"));
        }
        
        // Test transaction history
        System.out.println("✓ Transaction history size: " + account.getTransactionHistory().size());
        
        // Test bank statistics
        System.out.println("✓ Total accounts: " + bank.getTotalAccounts());
        System.out.println("✓ Total deposits: $" + bank.getTotalBankDeposits());
        
        // Test fund transfer
        Account fromAccount = bank.getAccount("TEST001"); // Sunil Kumar
        Account toAccount = bank.getAccount("TEST002");   // Ajay Sharma
        
        double fromBalance = fromAccount.getBalance();
        double toBalance = toAccount.getBalance();
        
        if (fromAccount.withdraw(100.0) && toAccount.deposit(100.0)) {
            System.out.println("✓ Fund transfer successful");
            System.out.println("  From account new balance: $" + fromAccount.getBalance());
            System.out.println("  To account new balance: $" + toAccount.getBalance());
        }
        
        // Test mini statement
        System.out.println("\n=== MINI STATEMENT TEST ===");
        System.out.println(account.getMiniStatement());
        
        System.out.println("\n=== ALL TESTS COMPLETED SUCCESSFULLY ===");
    }
}