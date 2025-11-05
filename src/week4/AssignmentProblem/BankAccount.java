package Week4.AssignmentProblem;


import java.util.*;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private static int counter = 1000;

    public BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = counter++;
        this.balance = 0.0;
    }

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = counter++;
        this.balance = 0.0;
    }

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = counter++;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public void displayAccount() {
        System.out.println("Account: " + accountNumber + " | Holder: " + accountHolder + " | Balance: " + balance);
    }
}

public class Problem2Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000);

        a2.deposit(2000);
        a3.withdraw(1000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
