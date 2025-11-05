package Week3.PraticeProblem;
class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private static double interestRate = 3.5;

    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountNumber = ++totalAccounts;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) balance -= amount;
        else System.out.println("Insufficient balance.");
    }

    public void displayAccount() {
        System.out.println("[" + bankName + "] Acc#" + accountNumber + " | Holder: " + accountHolder + " | Balance: " + balance);
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    // Static setters
    public static void setBankName(String name) { bankName = name; }
    public static void setInterestRate(double rate) { interestRate = rate; }
    public static int getTotalAccounts() { return totalAccounts; }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 2000);

        acc1.deposit(500);
        acc2.withdraw(300);

        acc1.displayAccount();
        acc2.displayAccount();

        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Interest for Alice: " + acc1.calculateInterest());
    }
}
