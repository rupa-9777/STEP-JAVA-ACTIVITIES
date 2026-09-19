public abstract class AbstractAccount implements IAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected boolean active = true;

    public AbstractAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (!active)
            throw new IllegalStateException("Account is inactive");
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount");
        balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void closeAccount() {
        active = false;
    }
}