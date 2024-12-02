public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(); //
        // Create accounts
        SavingsAccount studentSavings = new StudentSavingsAccount("100", "Ojas", 5000.0, 4.0);
        CurrentAccount generalCurrent = new GeneralCurrentAccount("200", "Jay", 2000.0); //
        //Add accounts to bank
        bank.addAccount(studentSavings);
        bank.addAccount(generalCurrent); // Perform transactions
        studentSavings.deposit(500.0);
        generalCurrent.withdraw(300.0);
        studentSavings.transferFunds(generalCurrent, 200.0);
        // View account statements
        studentSavings.viewAccountStatement();
        generalCurrent.viewAccountStatement();
        // View details sorted by account number
        bank.viewDetailsSortedByAccountNumber();
        // Search for an account
        Account searchedAccount = bank.searchAccount("100");
        if (searchedAccount != null) {
            System.out.println("Account found: " + searchedAccount.accountHolderName);
        } else {
            System.out.println("Account not found");
        }
    }
}