public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(
            String accountNumber,
            String holderName,
            double balance,
            double interestRate) {

        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate / 100;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 500)
            balance -= amount;
    }
}
