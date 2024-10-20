public class CheckingAccount extends Account {
    public CheckingAccount(String accountHolder) {
        super(accountHolder);
        System.out.println("Checking account created for " + accountHolder);
    }
}
