public class CurrentAccount extends BankAccount {

    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public double getMinimumBalance() {
        return -5000;
    }

    @Override
    public String getAccountType() {
        return "CURRENT";
    }

    @Override
    public double getInterestRate() {
        return 0;
    }
}
