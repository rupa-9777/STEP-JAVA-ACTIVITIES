public class SavingsAccount extends BankAccount {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double getMinimumBalance() {
        return 500;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public double getInterestRate() {
        return 2.5;
    }
}
