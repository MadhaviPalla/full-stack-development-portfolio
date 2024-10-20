public class SavingsAccount extends Account {
    public SavingsAccount(String accountHolder) {
        super(accountHolder);
        System.out.println("Savings account created for " + accountHolder);
    }
}
