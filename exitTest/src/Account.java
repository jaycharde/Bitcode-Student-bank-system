import java.util.*;

abstract class Account {
    String accountNumber;
    String accountHolderName;
    double balance;
    List<Transaction> transactions;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(UUID.randomUUID().toString(), new Date(), amount, "Deposit"));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(UUID.randomUUID().toString(), new Date(), amount, "Withdraw"));
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transferFunds(Account toAccount, double amount) {
        if (balance >= amount) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add(new Transaction(UUID.randomUUID().toString(), new Date(), amount, "Transfer"));
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void viewAccountStatement() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void extractAccountStatement() {

    }
}

class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void depositInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
    }
}

class StudentSavingsAccount extends SavingsAccount {
    public StudentSavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance, interestRate);
    }
}

class GeneralSavingsAccount extends SavingsAccount {
    public GeneralSavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance, interestRate);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }
}

class GeneralCurrentAccount extends CurrentAccount {
    public GeneralCurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }
}

class StartupCurrentAccount extends CurrentAccount {
    public StartupCurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }
}

class Transaction {
    String transactionId;
    Date date;
    double amount;
    String type;

    public Transaction(String transactionId, Date date, double amount, String type) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}

class Bank {
    List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(String accountNumber) {
        accounts.removeIf(account -> account.accountNumber.equals(accountNumber));
    }

    public void updateAccount(String accountNumber, String newAccountHolderName) {
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                account.accountHolderName = newAccountHolderName;
                break;
            }
        }
    }

    public void viewDetailsSortedByAccountNumber() {
        accounts.sort(Comparator.comparing(account -> account.accountNumber));
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void viewDetailsSortedByAccountName() {
        accounts.sort(Comparator.comparing(account -> account.accountHolderName));
        for (Account account : accounts) {
            System.out.println(account);
        }
    } public void viewDetailsSortedByAccountBalance() {
        accounts.sort(Comparator.comparing(account -> account.balance));
        for (Account account : accounts) { System.out.println(account);
        }
    } public Account searchAccount(String searchTerm) {
        for (Account account : accounts) {
            if (account.accountNumber.equals(searchTerm) || account.accountHolderName.equals(searchTerm)) {
                return account;
            } }
        return null;
    }
    public void backupDetails() {

    } }
