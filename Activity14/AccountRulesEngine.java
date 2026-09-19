public class AccountRulesEngine {

    private static final AccountRulesEngine instance =
            new AccountRulesEngine();

    private final AccountRulesPropertiesLoader loader =
            new AccountRulesPropertiesLoader();

    private AccountRulesEngine() {
        reloadRules();
    }

    public static AccountRulesEngine getInstance() {
        return instance;
    }

    public void reloadRules() {
        loader.loadRules();
    }

    public double getMinimumBalance(String type) {
        return loader.getMinimumBalance(type, 0);
    }

    public double getMinimumBalance(String type, int tenure) {
        return loader.getMinimumBalance(type, tenure);
    }

    public double getInterestRate(String type) {
        return loader.getInterestRate(type, 0);
    }

    public double getInterestRate(String type, int tenure) {
        return loader.getInterestRate(type, tenure);
    }

    public double getOverdraftLimit(String type) {
        return loader.getOverdraftLimit(type);
    }
}