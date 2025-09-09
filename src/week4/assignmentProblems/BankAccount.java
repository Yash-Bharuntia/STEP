package week4.assignmentProblems;

import java.util.*;

class BankAccount {
    private final String accountHolder;
    private final int accountNumber;
    private double balance;

    public BankAccount() {
        this("Unknown", new Random().nextInt(9000) + 1000, 0.0);
    }

    public BankAccount(String accountHolder) {
        this(accountHolder, new Random().nextInt(9000) + 1000, 0.0);
    }

    public BankAccount(String accountHolder, double balance) {
        this(accountHolder, new Random().nextInt(9000) + 1000, balance);
    }

    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited Rs." + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew Rs." + amount);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + " | Acc No: " + accountNumber + " | Balance: Rs." + balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000.0);

        a1.deposit(1000);
        a1.displayAccount();

        a2.deposit(2000);
        a2.withdraw(500);
        a2.displayAccount();

        a3.withdraw(6000);
        a3.displayAccount();
    }
}
