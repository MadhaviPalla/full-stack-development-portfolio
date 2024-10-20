import java.util.*;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Create a new account
    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created for " + account.getAccountHolder());
    }

    // Find account by account number
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money from an account
    public void withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Check the balance of an account
    public void checkBalance(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("The balance for account " + accountNumber + " is " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        String option;
        do {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter account type (1: Savings, 2: Checking): ");
                    int type = scanner.nextInt();
                    if (type == 1) {
                        bank.createAccount(new SavingsAccount(name));
                    } else if (type == 2) {
                        bank.createAccount(new CheckingAccount(name));
                    } else {
                        System.out.println("Invalid account type.");
                    }
                    scanner.nextLine(); // Consume newline
                    break;
                case "2":
                    System.out.print("Enter account number: ");
                    int accNumDeposit = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accNumDeposit, depositAmount);
                    scanner.nextLine(); // Consume newline
                    break;
                case "3":
                    System.out.print("Enter account number: ");
                    int accNumWithdraw = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(accNumWithdraw, withdrawAmount);
                    scanner.nextLine(); // Consume newline
                    break;
                case "4":
                    System.out.print("Enter account number: ");
                    int accNumBalance = scanner.nextInt();
                    bank.checkBalance(accNumBalance);
                    scanner.nextLine(); // Consume newline
                    break;
                case "5":
                    System.out.println("Thank you for using the Bank Management System.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (!option.equals("5"));

        scanner.close();
    }
}
