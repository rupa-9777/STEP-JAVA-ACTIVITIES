public class TestAccounts {
    public static void main(String[] args) {

        Account[] accounts = {
                new SavingsAccount("S001", "Alice", 5000, 2.5),
                new CurrentAccount("C001", "Bob", 3000, 5000)
        };

        for (Account account : accounts) {
            account.deposit(500);
            account.withdraw(1000);

            System.out.println(
                    account.getClass().getSimpleName()
                            + " Balance: "
                            + account.getBalance()
            );
        }

        SavingsAccount savings =
                new SavingsAccount("S002", "John", 5000, 2.5);

        savings.applyInterest();

        System.out.println(
                "Savings after interest: "
                        + savings.getBalance()
        );
    }
}
