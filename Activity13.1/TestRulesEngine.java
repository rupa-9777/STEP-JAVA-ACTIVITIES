public class TestRulesEngine {
    public static void main(String[] args) {

        AccountRulesEngine engine =
                AccountRulesEngine.getInstance();

        String[] types = {
                "SAVINGS",
                "CURRENT",
                "FIXED",
                "SALARY"
        };

        for (String type : types) {
            System.out.println(type);
            System.out.println("Minimum Balance: "
                    + engine.getMinimumBalance(type));
            System.out.println("Interest Rate: "
                    + engine.getInterestRate(type));
            System.out.println("Overdraft Limit: "
                    + engine.getOverdraftLimit(type));
            System.out.println();
        }
    }
}