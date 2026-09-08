# ATM Management System

A comprehensive Java-based ATM Management System with full banking functionality, user authentication, and administrative features.

## Features

### Customer Features
- **User Authentication**: Secure login with account number and 4-digit PIN
- **Balance Inquiry**: Check current account balance
- **Cash Withdrawal**: Withdraw cash with balance and ATM cash validation
- **Cash Deposit**: Deposit cash into account with amount limits
- **PIN Change**: Secure PIN change functionality with validation
- **Transaction History**: View complete transaction history
- **Mini Statement**: Generate and print mini statements
- **Fund Transfer**: Transfer funds to other accounts
- **Account Information**: View detailed account information

### Admin Features
- **Create New Accounts**: Add new customer accounts
- **View All Accounts**: Browse all bank accounts
- **Add Cash to ATM**: Replenish ATM cash balance
- **View Bank Statistics**: View comprehensive bank statistics
- **Close Accounts**: Deactivate customer accounts
- **View Account Details**: Detailed view of specific accounts

## System Architecture

### Classes

1. **Account.java**
   - Manages individual account details
   - Handles PIN validation and changes
   - Processes withdrawals and deposits
   - Maintains transaction history

2. **Transaction.java**
   - Records transaction details
   - Generates unique transaction IDs
   - Tracks timestamps and amounts

3. **Bank.java**
   - Manages multiple accounts
   - Handles ATM cash balance
   - Provides account management operations
   - Maintains bank statistics

4. **ATM.java**
   - Implements ATM operations
   - Handles user authentication
   - Processes all customer transactions
   - Provides input validation

5. **Main.java**
   - Main application entry point
   - User interface and menu system
   - Admin and customer modes
   - System initialization

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Setup Instructions

1. **Clone or Download** the project files to your local machine

2. **Compile the Java files**:
   ```bash
   javac *.java
   ```

3. **Run the application**:
   ```bash
   java Main
   ```

## Usage Guide

### Starting the System

When you start the application, it will:
- Initialize the bank system with default settings
- Create sample accounts for testing
- Display the main menu

### Sample Test Accounts

The system comes pre-loaded with these test accounts:

| Account Number | Holder Name   | PIN  | Balance |
|----------------|---------------|------|---------|
| 1001           | Sunil Kumar   | 1234 | $5000   |
| 1002           | Ajay Sharma   | 5678 | $2500   |
| 1003           | Raju Sharma   | 9012 | $10000  |
| 1004           | Ranjit Sharma | 3456 | $7500   |

### Customer Operations

1. **Login**: Select "ATM Operations" and enter account number and PIN
2. **Balance Inquiry**: View your current account balance
3. **Cash Withdrawal**: 
   - Enter withdrawal amount
   - Amount must be positive and ≤ available balance
   - Amount must be ≤ ATM cash balance
   - Amount must be in multiples of 20, 50, or 100
4. **Cash Deposit**:
   - Enter deposit amount
   - Amount must be positive and ≤ $50,000
5. **PIN Change**:
   - Enter current PIN
   - Enter new 4-digit PIN
   - Confirm new PIN
6. **Transaction History**: View recent transactions
7. **Mini Statement**: Print account mini statement
8. **Fund Transfer**: Transfer money to other accounts
9. **Account Information**: View detailed account info
10. **Logout**: Return to main menu

### Admin Operations

1. **Create New Account**: Add new customer accounts with details
2. **View All Accounts**: Browse existing accounts
3. **Add Cash to ATM**: Replenish ATM cash for withdrawals
4. **View Bank Statistics**: See total accounts, deposits, and ATM balance
5. **Close Account**: Deactivate specific accounts
6. **View Account Details**: Detailed view including transaction history

## Security Features

- **PIN Validation**: 4-digit numeric PIN required
- **Account Status**: Inactive accounts cannot perform transactions
- **Transaction Limits**: Deposit limits and withdrawal validations
- **Amount Validation**: Multiple checks for valid monetary amounts
- **ATM Cash Management**: Ensures ATM has sufficient cash for withdrawals

## Error Handling

The system includes comprehensive error handling for:
- Invalid account numbers
- Incorrect PINs
- Insufficient balances
- Invalid monetary amounts
- ATM cash shortages
- Non-numeric inputs
- Account not found scenarios

## Testing Scenarios

### Test Case 1: Normal Withdrawal
1. Login with account 1001 (Sunil Kumar), PIN 1234
2. Select "Cash Withdrawal"
3. Enter amount: 500
4. Verify success and balance update

### Test Case 2: Insufficient Balance
1. Login with account 1002 (Ajay Sharma), PIN 5678
2. Select "Cash Withdrawal"
3. Enter amount: 10000 (more than balance)
4. Verify error message

### Test Case 3: PIN Change
1. Login with account 1003 (Raju Sharma), PIN 9012
2. Select "PIN Change"
3. Enter current PIN: 9012
4. Enter new PIN: 1111
5. Confirm new PIN: 1111
6. Verify success message

### Test Case 4: Fund Transfer
1. Login with account 1001 (Sunil Kumar), PIN 1234
2. Select "Fund Transfer"
3. Enter recipient: 1002 (Ajay Sharma)
4. Enter amount: 200
5. Verify success and both account balances

### Test Case 5: Admin Operations
1. Select "Admin Operations"
2. Create new account with number 1005
3. Add $5000 to ATM
4. View bank statistics
5. Verify new account appears in statistics

## Future Enhancements

Potential improvements for future versions:
- Database integration for persistent storage
- Network support for multiple ATM locations
- Card reader integration
- Receipt printing functionality
- Multi-language support
- Advanced security features (biometrics, OTP)
- Loan and interest calculation features
- Bill payment integration
- Mobile app integration

## Technical Specifications

- **Language**: Java
- **Minimum Version**: Java 8
- **Architecture**: Object-Oriented Design
- **Data Structures**: HashMap for account management, ArrayList for transactions
- **Input/Output**: Console-based (Scanner class)
- **Error Handling**: Try-catch blocks with user-friendly messages

## Troubleshooting

### Compilation Issues
- Ensure all Java files are in the same directory
- Check that JDK is properly installed
- Verify file names match class names exactly

### Runtime Issues
- Ensure you're running the Main class
- Check that all compiled .class files are present
- Verify sample accounts are created during initialization

### Account Access Issues
- Verify account number and PIN are correct
- Check that account is active (not closed by admin)
- Ensure proper numeric input for amounts

## License

This project is created for educational purposes.

## Author

ATM Management System - Java Mini Project

## Version History

- **Version 1.0**: Initial release with core ATM functionality
  - User authentication
  - Basic transactions (withdrawal, deposit)
  - Account management
  - Admin features
  - Transaction history