import java.util.Scanner;

class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // User interface for the ATM
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else {
            account.deposit(amount);
            System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}
class BankAccount {
    private double balance;

    // Constructor to initialize the account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance
        BankAccount account = new BankAccount(1000.00);

        // Create an ATM object with the bank account
        ATM atm = new ATM(account);

        // Start the ATM interface
        atm.start();
    }
}
