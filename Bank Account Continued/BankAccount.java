public class BankAccount {
    private double balance;
    private String accountHolderName;

    // Constructor
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount +  " into " + accountHolderName);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + " from account of " + accountHolderName);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to print account details
    public void printAccountDetails() {
        System.out.println(accountHolderName + " $" + balance);
    }

    public static void main(String[] args) {
        // Instantiate a BankAccount object with 500 dollars
        BankAccount account = new BankAccount("My Account Balance is: ", 500.0);

        // Deposit 100 dollars into the account
        account.deposit(100.0);

        // Print the account details to the console
        account.printAccountDetails();
    }
}

class BankTransfer {
    public static void main(String[] args) {
        // Instantiate two BankAccount objects
        BankAccount account1 = new BankAccount("First Account Balance:", 5000.0);
        BankAccount account2 = new BankAccount("Second Account Balance:", 300.0);

        // Withdraw 100 dollars from the first account
        account1.withdraw(100.0);

        // Deposit 100 dollars into the second account
        account2.deposit(100.0);

        // Print the account details to the console
        account1.printAccountDetails();
        account2.printAccountDetails();
    }
}