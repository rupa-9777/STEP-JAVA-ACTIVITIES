public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(
            String accountNumber,
            String holderName,
            double balance,
            double overdraftLimit) {

        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit)
            balance -= amount;
    }
}