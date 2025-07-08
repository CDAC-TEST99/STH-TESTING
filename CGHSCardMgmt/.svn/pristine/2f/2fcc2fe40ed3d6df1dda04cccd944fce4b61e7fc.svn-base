package formFlowX.util;
import java.util.regex.Pattern;

public class AmountPatternMatching {
    public static void main(String[] args) {
        String amountPattern = "^\\d+(\\.\\d{2})?$"; // Matches whole numbers or numbers with two decimal places
        String[] testAmounts = {"3000.0", "45.67", "9.99", "3.", ".25"};

        for (String amount : testAmounts) {
            boolean isValid = Pattern.matches(amountPattern, amount);
            System.out.println(amount + " is valid: " + isValid);
        }
    }
}