public class AccountRulesEngine {

    private static final AccountRulesEngine instance =
            new AccountRulesEngine();

    private AccountRulesEngine() {
    }

    public static AccountRulesEngine getInstance() {
        return instance;
    }

    public double getMinimumBalance(String accountType) {
        return switch (accountType.toUpperCase()) {
            case "SAVINGS" -> 500;
            case "CURRENT" -> 1000;
            case "FIXED" -> 10000;
            case "SALARY" -> 0;
            default -> throw new IllegalArgumentException("Unknown account type");
        };
    }

    public double getInterestRate(String accountType) {
        return switch (accountType.toUpperCase()) {
            case "SAVINGS" -> 2.5;
            case "CURRENT" -> 0.0;
            case "FIXED" -> 5.0;
            case "SALARY" -> 1.0;
            default -> throw new IllegalArgumentException("Unknown account type");
        };
    }

    public double getOverdraftLimit(String accountType) {
        return switch (accountType.toUpperCase()) {
            case "CURRENT" -> 5000;
            default -> 0;
        };
    }

    public boolean validateWithdrawal(
            String accountType,
            double balance,
            double amount) {

        double minimum = getMinimumBalance(accountType);
        double overdraft = getOverdraftLimit(accountType);

        return balance - amount >= minimum - overdraft;
    }
}