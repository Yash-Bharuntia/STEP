package Week5.PraticeProblems;

public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;
    private final int MAX_FAILED_ATTEMPTS = 3;
    private final double MIN_BALANCE = 0.0;
    public SecureBankAccount(String accNum, double initialBalance) {
        accountNumber = accNum;
        balance = initialBalance;
        pin = 0;
        isLocked = false;
        failedAttempts = 0;
    }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return isLocked ? 0 : balance; }
    public boolean isAccountLocked() { return isLocked; }
    public void setPin(int oldPin, int newPin) {
        if (pin == 0 || pin == oldPin) pin = newPin;
    }
    public boolean validatePin(int enteredPin) {
        if (pin != enteredPin) {
            incrementFailedAttempts();
            return false;
        }
        resetFailedAttempts();
        return true;
    }
    public void unlockAccount(int correctPin) {
        if (pin == correctPin) isLocked = false;
    }
    public void deposit(double amount, int enteredPin) {
        if (!isLocked && validatePin(enteredPin)) balance += amount;
    }
    public void withdraw(double amount, int enteredPin) {
        if (!isLocked && validatePin(enteredPin) && balance - amount >= MIN_BALANCE) balance -= amount;
    }
    public void transfer(SecureBankAccount target, double amount, int enteredPin) {
        if (!isLocked && validatePin(enteredPin) && balance - amount >= MIN_BALANCE) {
            balance -= amount;
            target.balance += amount;
        }
    }
    private void lockAccount() { isLocked = true; }
    private void resetFailedAttempts() { failedAttempts = 0; }
    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) lockAccount();
    }
    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC100", 1000);
        SecureBankAccount acc2 = new SecureBankAccount("ACC200", 500);
        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);
        acc1.deposit(500, 1234);
        acc1.withdraw(200, 1234);
        acc1.transfer(acc2, 300, 1234);
        acc1.validatePin(1111);
        acc1.validatePin(1111);
        acc1.validatePin(1111);
        acc1.deposit(100, 1234);
    }
}
