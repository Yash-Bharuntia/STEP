import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

final class Transaction {
    private final String transactionId;
    private final LocalDateTime timestamp;
    private final double amount;
    private final String transactionType;
    private final String description;
    private final String fromAccount;
    private final String toAccount;
    private final Map<String, String> metadata;

    public Transaction(String id, double amount, String type, String desc,
                       String from, String to, Map<String, String> metadata) {
        this.transactionId = id;
        this.timestamp = LocalDateTime.now();
        this.amount = amount;
        this.transactionType = type;
        this.description = desc;
        this.fromAccount = from;
        this.toAccount = to;
        this.metadata = new HashMap<>(metadata);
    }

    public String getTransactionId() { return transactionId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public double getAmount() { return amount; }
    public String getTransactionType() { return transactionType; }
    public String getDescription() { return description; }
    public String getFromAccount() { return fromAccount; }
    public String getToAccount() { return toAccount; }
    public Map<String, String> getMetadata() { return new HashMap<>(metadata); }

    public final boolean isValid() {
        return amount > 0 && transactionType != null;
    }

    @Override
    public String toString() {
        return "Transaction{" + transactionId + ", " + transactionType + ", $" + amount + "}";
    }
}

class BankAccount {
    private final String accountNumber;
    private final String accountType;
    private final LocalDate openDate;
    private final String ownerId;
    private double balance;
    private String accountStatus;
    private final List<Transaction> transactionHistory;

    public BankAccount(String accountNumber, String type, LocalDate openDate, String ownerId, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountType = type;
        this.openDate = openDate;
        this.ownerId = ownerId;
        this.balance = initialBalance;
        this.accountStatus = "ACTIVE";
        this.transactionHistory = new ArrayList<>();
    }

    double getInternalBalance() { return balance; }

    public String getPublicAccountInfo() {
        return "Account: ****" + accountNumber.substring(accountNumber.length() - 4) +
                ", Type: " + accountType + ", Status: " + accountStatus;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction(UUID.randomUUID().toString(), amount,
                "DEPOSIT", "Cash Deposit", null, accountNumber, Map.of()));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(UUID.randomUUID().toString(), amount,
                    "WITHDRAWAL", "ATM Withdrawal", accountNumber, null, Map.of()));
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
}

class BankTeller {
    private final String tellerId;
    private final String branch;

    public BankTeller(String tellerId, String branch) {
        this.tellerId = tellerId;
        this.branch = branch;
    }
}

class AccountManager {
    private final String managerId;
    private final Set<String> clientAccounts;

    public AccountManager(String id, Set<String> accounts) {
        this.managerId = id;
        this.clientAccounts = new HashSet<>(accounts);
    }
}

class Auditor {
    private final String auditorId;

    public Auditor(String id) {
        this.auditorId = id;
    }
}

final class BankingSystem {
    private static final Map<String, BankAccount> accountRegistry = new HashMap<>();

    public static boolean processTransaction(Transaction tx, BankAccount account, Object staff) {
        if (!tx.isValid()) return false;
        if (staff instanceof BankTeller || staff instanceof AccountManager) {
            if ("DEPOSIT".equals(tx.getTransactionType())) {
                account.deposit(tx.getAmount());
                return true;
            } else if ("WITHDRAWAL".equals(tx.getTransactionType())) {
                account.withdraw(tx.getAmount());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("ACC1001", "SAVINGS", LocalDate.now(), "U001", 1000);
        BankTeller teller = new BankTeller("T001", "MainBranch");

        Transaction tx1 = new Transaction("TXN001", 500, "DEPOSIT", "Initial Deposit", null, "ACC1001", Map.of());
        boolean result = BankingSystem.processTransaction(tx1, acc1, teller);

        System.out.println("Transaction Processed: " + result);
        System.out.println(acc1.getPublicAccountInfo());
        System.out.println("History: " + acc1.getTransactionHistory());
    }
}
