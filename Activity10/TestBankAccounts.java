public class TestBankAccounts {
    public static void main(String[] args) {

        BankAccount[] accounts = {
                new SavingsAccount(5000),
                new CurrentAccount(5000),
                new FixedDepositAccount(20000)
        };

        for (BankAccount account : accounts) {

            System.out.println(
                    account.getAccountType()
                            + " Initial Balance: "
                            + account.getBalance()
            );

            account.applyMonthlyInterest();

            System.out.println(
                    "After Interest: "
                            + account.getBalance()
            );

            System.out.println();
        }
    }
}