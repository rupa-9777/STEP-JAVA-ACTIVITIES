import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AccountRulesPropertiesLoader {

    private final Map<String, Properties> rules = new HashMap<>();

    public void loadRules() {

        String[] types = {
                "savings",
                "current",
                "fixeddeposit",
                "salary"
        };

        for (String type : types) {

            Properties properties = new Properties();

            String file = "/" + type + ".properties";

            try (InputStream input =
                         getClass().getResourceAsStream(file)) {

                if (input == null)
                    throw new IllegalStateException(
                            "Missing configuration: " + file);

                properties.load(input);
                rules.put(type.toUpperCase(), properties);

            } catch (IOException e) {
                throw new IllegalStateException(
                        "Unable to load " + file, e);
            }
        }
    }

    public double getInterestRate(String type, int tenure) {

        Properties p = rules.get(type.toUpperCase());

        if (p == null)
            throw new IllegalArgumentException("Unknown account type");

        String key = type.toLowerCase()
                + ".tenure."
                + tenure
                + ".interestRate";

        return Double.parseDouble(p.getProperty(key, "0.0"));
    }

    public double getMinimumBalance(String type, int tenure) {

        Properties p = rules.get(type.toUpperCase());

        if (p == null)
            throw new IllegalArgumentException("Unknown account type");

        String key = type.toLowerCase()
                + ".tenure."
                + tenure
                + ".minBalance";

        return Double.parseDouble(p.getProperty(key, "0.0"));
    }

    public double getOverdraftLimit(String type) {

        Properties p = rules.get(type.toUpperCase());

        if (p == null)
            return 0;

        return Double.parseDouble(
                p.getProperty(
                        type.toLowerCase() + ".overdraftLimit",
                        "0.0"
                )
        );
    }
}