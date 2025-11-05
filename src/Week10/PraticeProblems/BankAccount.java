package Week10.PraticeProblems;

class BankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    public BankAccount(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }
    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }
    public void debit(double amount) {
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
    }
}
class ATM {
    private BankAccount linkedAccount;
    public ATM(BankAccount linkedAccount) {
        this.linkedAccount = linkedAccount;
    }
    public void withdraw(int enteredPin, double amount) {
        if (linkedAccount.validatePin(enteredPin)) {
            linkedAccount.debit(amount);
            System.out.println("Transaction successful. Please collect your cash.");
        } else {
            System.out.println("Invalid PIN. Transaction failed.");
        }
    }
}
class Customer {
    private String name;
    private ATM atm;
    public Customer(String name, ATM atm) {
        this.name = name;
        this.atm = atm;
    }
    public void performWithdrawal(int pin, double amount) {
        System.out.println(name + " is requesting withdrawal...");
        atm.withdraw(pin, amount);
    }
}
public class ATMDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("12345", 50000, 1234);
        ATM atm = new ATM(acc);
        Customer cust = new Customer("Ravi", atm);
        cust.performWithdrawal(1234, 5000);
        cust.performWithdrawal(9999, 2000);