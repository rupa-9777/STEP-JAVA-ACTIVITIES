public class TestEnhancedAccount {
    public static void main(String[] args) {

        Account account =
                new Account("A001", "Alice", 2000, 20);

        account.setPin("1234");

        System.out.println("PIN valid: "
                + account.verifyPin("1234"));

        account.deposit(500);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(300);
        System.out.println("Balance: " + account.getBalance());

        account.closeAccount();

        try {
            account.deposit(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        account.reopenAccount();
        account.deposit(100);

        System.out.println("Final Balance: "
                + account.getBalance());
    }
}