public abstract class BankAccount {

    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public abstract double getMinimumBalance();

    public abstract String getAccountType();

    public abstract double getInterestRate();

    public boolean canWithdraw(double amount) {
        return balance - amount >= getMinimumBalance();
    }

    public void withdraw(double amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
        }
    }

    public void applyMonthlyInterest() {
        balance += balance * getInterestRate() / 100 / 12;
    }

    public double getBalance() {
        return balance;
    }
}
