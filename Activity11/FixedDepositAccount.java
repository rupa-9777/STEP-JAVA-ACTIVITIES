public class FixedDepositAccount extends AbstractAccount {

    public FixedDepositAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (!active)
            throw new IllegalStateException("Account is inactive");
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    @Override
    public String getAccountType() {
        return "FIXED";
    }
}