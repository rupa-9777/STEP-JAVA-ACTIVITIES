public class SavingsAccount extends AbstractAccount {

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (!active)
            throw new IllegalStateException("Account is inactive");
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount");
        if (balance - amount < 500)
            throw new IllegalArgumentException("Minimum balance violation");
        balance -= amount;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }
}