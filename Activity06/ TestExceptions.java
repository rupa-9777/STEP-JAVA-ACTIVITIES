public class TestExceptions {
    public static void main(String[] args) {

        try {
            throw new InvalidAmountException("Amount must be positive");
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new InsufficientBalanceException("Insufficient balance");
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new MinimumBalanceViolationException(
                    "Minimum balance violation");
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new InactiveAccountException("Account is inactive");
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new InvalidPinException("Invalid PIN");
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }
    }
}