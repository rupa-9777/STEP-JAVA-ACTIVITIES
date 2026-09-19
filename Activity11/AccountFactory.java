public class AccountFactory {

    public static IAccount createAccount(
            String type,
            String accountNumber,
            String holderName,
            double balance) {

        return switch (type.toUpperCase()) {
            case "SAVINGS" ->
                    new SavingsAccount(accountNumber, holderName, balance);
            case "CURRENT" ->
                    new CurrentAccount(accountNumber, holderName, balance);
            case "FIXED" ->
                    new FixedDepositAccount(accountNumber, holderName, balance);
            case "SALARY" ->
                    new SalaryAccount(accountNumber, holderName, balance);
            default ->
                    throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}