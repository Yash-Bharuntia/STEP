package week3.practiceProblems;

public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("---------------------------");
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Interest Earned: ₹" + calculateInterest());
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        BankAccount.setBankName("CodeBank");
        BankAccount.setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("ACC001", "Yash", 10000);
        BankAccount acc2 = new BankAccount("ACC002", "Isha", 15000);
        BankAccount.displayBankInfo();
        displayBankInfo();

        acc1.deposit(2000);
        acc2.withdraw(500);

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}