public abstract class Account {
    private static int accountCounter = 1000;
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = ++accountCounter;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: " + balance;
    }
}
