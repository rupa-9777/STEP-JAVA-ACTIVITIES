import java.util.HashMap;
import java.util.Map;

public class AccountRulesEngine {

    private static final AccountRulesEngine instance =
            new AccountRulesEngine();

    private final Map<String, Map<Integer, Rule>> rules = new HashMap<>();

    private AccountRulesEngine() {
        loadRules();
    }

    public static AccountRulesEngine getInstance() {
        return instance;
    }

    private void loadRules() {

        Map<Integer, Rule> savings = new HashMap<>();
        savings.put(0, new Rule(2.5, 500, "Basic Savings"));
        savings.put(1, new Rule(3.5, 1000, "Regular Savings"));
        savings.put(3, new Rule(4.5, 2000, "Premium Savings"));

        Map<Integer, Rule> current = new HashMap<>();
        current.put(0, new Rule(0.0, 1000, "Basic Current"));

        Map<Integer, Rule> fixed = new HashMap<>();
        fixed.put(0, new Rule(5.0, 10000, "Fixed Deposit"));

        Map<Integer, Rule> salary = new HashMap<>();
        salary.put(0, new Rule(1.0, 0, "Salary Account"));

        rules.put("SAVINGS", savings);
        rules.put("CURRENT", current);
        rules.put("FIXED", fixed);
        rules.put("SALARY", salary);
    }

    private Rule findRule(String type, int tenure) {

        Map<Integer, Rule> accountRules =
                rules.get(type.toUpperCase());

        if (accountRules == null)
            throw new IllegalArgumentException("Unknown account type");

        Rule result = null;

        for (Integer key : accountRules.keySet()) {
            if (key <= tenure &&
                    (result == null || key > getTenure(result, accountRules))) {
                result = accountRules.get(key);
            }
        }

        if (result == null)
            throw new IllegalArgumentException("No rule available");

        return result;
    }

    private int getTenure(Rule rule, Map<Integer, Rule> map) {
        for (Map.Entry<Integer, Rule> entry : map.entrySet()) {
            if (entry.getValue() == rule)
                return entry.getKey();
        }
        return 0;
    }

    public double getMinimumBalance(String type) {
        return findRule(type, 0).getMinimumBalance();
    }

    public double getInterestRate(String type) {
        return findRule(type, 0).getInterestRate();
    }

    public double getOverdraftLimit(String type) {
        return type.equalsIgnoreCase("CURRENT") ? 5000 : 0;
    }

    public double getInterestRate(String type, int tenure) {
        return findRule(type, tenure).getInterestRate();
    }

    public double getMinimumBalance(String type, int tenure) {
        return findRule(type, tenure).getMinimumBalance();
    }
}
