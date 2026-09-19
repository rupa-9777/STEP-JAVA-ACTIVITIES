public class TestActivity12 {
    public static void main(String[] args) {

        IAccount[] accounts = {
                AccountFactory.createAccount("SAVINGS", "S001", "Alice", 5000),
                AccountFactory.createAccount("CURRENT", "C001", "Bob", 5000),
                AccountFactory.createAccount("FIXED", "F001", "John", 10000),
                AccountFactory.createAccount("SALARY", "SAL001", "David", 7000)
        };

        for (IAccount account : accounts) {
            account.deposit(500);
            System.out.println(
                    account.getAccountType() + " : " + account.getBalance()
            );
        }

        try {
            AccountFactory.createAccount("INVALID", "X001", "Test", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid account type handled successfully");
        }
    }
}