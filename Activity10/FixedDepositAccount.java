public class FixedDepositAccount extends BankAccount {

    public FixedDepositAccount(double balance) {
        super(balance);
    }

    @Override
    public double getMinimumBalance() {
        return 10000;
    }

    @Override
    public String getAccountType() {
        return "FIXED";
    }

    @Override
    public double getInterestRate() {
        return 5.0;
    }
}