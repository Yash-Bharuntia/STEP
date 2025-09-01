package week3.labProblems;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountHolderName, double initialDeposit) {
        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative.");
            return;
        }
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public static String generateAccountNumber() {
        return String.format("ACC%03d", totalAccounts + 1);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited ₹" + amount + " to " + accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds in " + accountNumber);
            return;
        }
        balance -= amount;
        System.out.println("Withdrew ₹" + amount + " from " + accountNumber);
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("----- Account Info -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("------------------------");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount("Yash", 5000);
        accounts[1] = new BankAccount("Aarav", 10000);
        accounts[2] = new BankAccount("Diya", 7500);

        accounts[0].deposit(1500);
        accounts[1].withdraw(3000);
        accounts[2].withdraw(8000);

        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }

        System.out.println("Total Bank Accounts Created: " + BankAccount.getTotalAccounts());
    }
}