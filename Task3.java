package code;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

class atm {
    private BankAccount account;
    private Scanner scanner;

    public atm(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to ATM");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    public void processTransaction() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}

public class ATMinterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        atm atm = new atm(userAccount);
        atm.processTransaction();
    }
}
