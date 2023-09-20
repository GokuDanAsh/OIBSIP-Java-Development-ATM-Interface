# ATM Console Application

The ATM Console Application is a simple Java project that simulates basic ATM functionalities, including withdrawing, depositing, transferring funds, checking the balance, and viewing transaction history. Users can interact with the console interface to manage their accounts and perform these banking operations.

## Features

- Register a new account by providing your name and account number.
- Withdraw funds from your account, with checks for insufficient balance.
- Deposit money into your account.
- Transfer funds to another account, with balance validation.
- Check your account balance.
- View a transaction history to keep track of your financial activities.

## How to Use

1. Choose option 1 to register a new account.
2. Enter your name and account number as prompted.
3. Once registered, you can access the following options:
   - Option 1: Withdraw
   - Option 2: Deposit
   - Option 3: Transfer
   - Option 4: Check balance
   - Option 5: Transaction history
   - Option 6: Exit

4. Select the desired option and follow the on-screen instructions to complete the chosen operation.

## Project Structure

The project is organized into several classes to manage different aspects of the ATM functionality:

- `BankAccount`: Handles user registration by capturing user details.

- `Transaction`: Manages withdrawal, deposit, and fund transfer operations.

- `Check`: Provides functionality to check the account balance.

- `History`: Allows users to view their transaction history.

- `ATM`: The main class that orchestrates the interaction with the user, including the homepage and the main menu.

## Usage

1. Clone the repository to your local machine.
2. Compile and run the Java code using your preferred IDE or command line.

```shell
javac ATM.java
java ATM
