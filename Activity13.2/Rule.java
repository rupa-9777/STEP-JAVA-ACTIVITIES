public class Rule {
    private double interestRate;
    private double minimumBalance;
    private String featureName;

    public Rule(double interestRate, double minimumBalance, String featureName) {
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.featureName = featureName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public String getFeatureName() {
        return featureName;
    }
}