public class CurrentAccount extends AbstractAccount {

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (!active)
            throw new IllegalStateException("Account is inactive");
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount");
        if (balance - amount < -5000)
            throw new IllegalArgumentException("Overdraft limit exceeded");
        balance -= amount;
    }

    @Override
    public String getAccountType() {
        return "CURRENT";
    }
}