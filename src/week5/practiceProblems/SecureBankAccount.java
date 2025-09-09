public class SecureBankAccount {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (!isLocked) return balance;
        else throw new IllegalStateException("Account is locked");
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) this.pin = newPin;
        else System.out.println("Incorrect old PIN");
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (correctPin == pin) {
            isLocked = false;
            resetFailedAttempts();
        }
    }

    public void deposit(double amount, int pin) {
        if (validatePin(pin) && amount > 0) balance += amount;
    }

    public void withdraw(double amount, int pin) {
        if (validatePin(pin) && amount > 0 && balance - amount >= MIN_BALANCE) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed");
        }
    }

    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin) && balance >= amount) {
            this.balance -= amount;
            target.balance += amount;
        }
    }

    private void lockAccount() {
        isLocked = true;
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) lockAccount();
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC001", 1000);
        SecureBankAccount acc2 = new SecureBankAccount("ACC002", 500);
        acc1.setPin(0, 1234);
        acc2.setPin(0, 4321);
        acc1.deposit(200, 1234);
        acc1.withdraw(150, 1234);
        System.out.println("Acc1 Balance: " + acc1.getBalance());
        acc1.transfer(acc2, 300, 1234);
        System.out.println("Acc1 Balance: " + acc1.getBalance());
        System.out.println("Acc2 Balance: " + acc2.getBalance());
    }
}
