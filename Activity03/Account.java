public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private String pin;
    private boolean active;

    public Account(String accountNumber, String holderName, double balance, int age) {
        if (age < 18)
            throw new IllegalArgumentException("Age must be at least 18");

        if (balance < 500)
            throw new IllegalArgumentException("Minimum balance is 500");

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.active = true;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean verifyPin(String pin) {
        return this.pin != null && this.pin.equals(pin);
    }

    public void deposit(double amount) {
        if (!active)
            throw new IllegalStateException("Account is closed");

        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount");

        balance += amount;
    }

    public void withdraw(double amount) {
        if (!active)
            throw new IllegalStateException("Account is closed");

        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount");

        if (balance - amount < 500)
            throw new IllegalArgumentException("Minimum balance violation");

        balance -= amount;
    }

    public void closeAccount() {
        active = false;
    }

    public void reopenAccount() {
        active = true;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }
}