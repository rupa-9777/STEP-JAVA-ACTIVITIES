public class TestAccount {
    public static void main(String[] args) {

        Account account = new Account("A001", "Alice", 1000);

        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(200);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}
