package Week3.LabProblems;
import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    private static int counter = 1;

    public BankAccount(String holderName, double initialDeposit) {
        this.accountHolderName = holderName;
        this.accountNumber = generateAccountNumber();
        this.balance = initialDeposit;
        totalAccounts++;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", counter++);
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + accountHolderName + ", Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankMain {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("Alice", 1000);
        accounts[1] = new BankAccount("Bob", 2000);
        accounts[0].deposit(500);
        accounts[1].withdraw(1000);
        for (BankAccount acc : accounts) acc.displayAccountInfo();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
