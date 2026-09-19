public class SalaryAccount extends AbstractAccount {

    public SalaryAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (!active)
            throw new IllegalStateException("Account is inactive");
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Invalid withdrawal");
        balance -= amount;
    }

    @Override
    public String getAccountType() {
        return "SALARY";
    }
}