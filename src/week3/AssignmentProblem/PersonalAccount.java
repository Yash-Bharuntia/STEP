package Week3.AssignmentProblem;


import java.util.*;

class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";
    private static int counter = 1;

    public PersonalAccount(String holder, double opening) {
        this.accountHolderName = holder;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = opening;
        this.totalIncome = opening;
        totalAccounts++;
    }

    public static void setBankName(String name) { bankName = name; }
    public static int getTotalAccounts() { return totalAccounts; }
    public static String generateAccountNumber() { return "PA" + String.format("%04d", counter++); }

    public void addIncome(double amount, String description) {
        if (amount > 0) { currentBalance += amount; totalIncome += amount; }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) { currentBalance -= amount; totalExpenses += amount; }
    }

    public double calculateSavings() { return totalIncome - totalExpenses; }

    public void displayAccountSummary() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account: " + accountNumber + " | Holder: " + accountHolderName);
        System.out.println("Balance: " + currentBalance);
        System.out.println("Income: " + totalIncome + " Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
        System.out.println();
    }
}

public class Assignment1Main {
    public static void main(String[] args) {
        PersonalAccount.setBankName("NeoBank");
        PersonalAccount a1 = new PersonalAccount("Alice", 1000);
        PersonalAccount a2 = new PersonalAccount("Bob", 500);
        PersonalAccount a3 = new PersonalAccount("Charlie", 0);
        a1.addIncome(7500, "Salary"); a1.addExpense(1200, "Rent"); a1.addExpense(500, "Groceries");
        a2.addIncome(3000, "Freelance"); a2.addExpense(800, "Utilities");
        a3.addIncome(10000, "Bonus"); a3.addExpense(2500, "Shopping");
        a1.displayAccountSummary();
        a2.displayAccountSummary();
        a3.displayAccountSummary();
        System.out.println("Total Accounts: " + PersonalAccount.getTotalAccounts());
    }
}
