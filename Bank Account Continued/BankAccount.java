import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private double balance;
    private String accountHolderName;
    private String accountNumber;

    // Constructor with account number
    public BankAccount(String accountHolderName, double balance, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    // No-parameter constructor
    public BankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        this.accountHolderName = scanner.nextLine();
        System.out.print("Enter starting balance: ");
        this.balance = scanner.nextDouble();
        scanner.nextLine();  // consume the newline
        System.out.print("Enter account number: ");
        this.accountNumber = scanner.nextLine();
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " into " + accountHolderName);
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

    // Method to transfer money
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            targetAccount.balance += amount;
            System.out.println("Transferred: $" + amount + " from account of " + this.accountHolderName + " to account of " + targetAccount.accountHolderName);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to print account details
    public void printAccountDetails() {
        System.out.println(accountHolderName + " (" + accountNumber + "): $" + balance);
    }

    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello world! Welcome to the Bank of Matt!");
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            if (choice == -1) {
                break;
            } else if (choice == 1) {
                System.out.println("Enter your account number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = findAccountByNumber(accounts, accountNumber);
                if (account == null) {
                    System.out.println("Account not found.");
                } else {
                    mainMenu(account, accounts, scanner);
                }
            } else if (choice == 2) {
                BankAccount newAccount = new BankAccount();
                accounts.add(newAccount);
                System.out.println("New account created:");
                newAccount.printAccountDetails();
                mainMenu(newAccount, accounts, scanner);
            }
        }

        scanner.close();
    }

    private static BankAccount findAccountByNumber(ArrayList<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private static void mainMenu(BankAccount account, ArrayList<BankAccount> accounts, Scanner scanner) {
        System.out.println("Hello " + account.accountHolderName + "!");
        while (true) {
            System.out.println("Welcome to the Main Menu, what would you like to do today?");
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdraw");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("0. To exit.");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                account.printAccountDetails();
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume the newline
                account.withdraw(amount);
            } else if (choice == 3) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume the newline
                account.deposit(amount);
            } else if (choice == 4) {
                System.out.print("Please enter the account number to transfer to: ");
                String targetAccountNumber = scanner.nextLine();
                BankAccount targetAccount = findAccountByNumber(accounts, targetAccountNumber);
                if (targetAccount == null) {
                    System.out.println("Account doesn't exist.");
                } else {
                    System.out.print("Please enter the amount to transfer: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    account.transfer(targetAccount, amount);
                }
            }
        }
    }
}