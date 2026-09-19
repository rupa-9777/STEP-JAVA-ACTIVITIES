public class TestActivity14 {

    public static void main(String[] args) {

        AccountRulesEngine engine =
                AccountRulesEngine.getInstance();

        System.out.println(
                "Savings Interest: "
                        + engine.getInterestRate("SAVINGS", 1)
        );

        System.out.println(
                "Savings Minimum Balance: "
                        + engine.getMinimumBalance("SAVINGS", 1)
        );

        System.out.println(
                "Current Overdraft: "
                        + engine.getOverdraftLimit("CURRENT")
        );

        engine.reloadRules();

        System.out.println("Rules reloaded successfully");
    }
}
