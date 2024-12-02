# Bitcode-Student-bank-system
This project is a demo banking system for BitCode Student Bank. It includes various types of accounts, transaction functionalities, and bank operations.

Features
Account Types:
Savings Accounts
Student Savings Account
General Savings Account
Current Accounts
General Current Account
Startup Current Account

Account Operations:
Deposit
Withdraw
Transfer Funds
View Account Statement
Extract Account Statement to an External File
UPI Pay and Receive

Bank Operations:
Add/Remove a Bank Account
Update Account Information
View Account Details (Sorted by Account Number, Account Name, or Account Balance)
Search for an Account by Account Number, Contact Number, or Account Name
Deposit Interest to Applicable Accounts
Backup Account Details to an External File (Concurrent with Regular Operations)

Classes and Interfaces
Account (abstract class)

Fields: accountNumber, accountHolderName, balance, transactions

Methods: deposit(), withdraw(), transferFunds(), viewAccountStatement(), extractAccountStatement(), payViaUPI(), receiveViaUPI()
SavingsAccount (extends Account)

Fields: interestRate

Methods: depositInterest()
StudentSavingsAccount (extends SavingsAccount)
GeneralSavingsAccount (extends SavingsAccount)
CurrentAccount (extends Account)
GeneralCurrentAccount (extends CurrentAccount)
StartupCurrentAccount (extends CurrentAccount)

Transaction
Fields: transactionId, date, amount, type

Methods: toString()

UPITransaction (extends Transaction)

Fields: upiId

Methods: toString()
Bank
Fields: accounts

Methods: addAccount(), removeAccount(), updateAccount(), viewDetailsSortedByAccountNumber(), viewDetailsSortedByAccountName(), viewDetailsSortedByAccountBalance(), searchAccount(), backupDetails()

Main
Contains the main method to demonstrate the functionality of the banking system.

