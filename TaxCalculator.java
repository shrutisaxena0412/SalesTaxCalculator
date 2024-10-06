package sales.tax.com;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;
    
    // Exempt categories
    private static final String[] TAX_EXEMPT_CATEGORIES = { "book", "food", "medical" };

    public double calculateTax(Item item) {
        double tax = 0.0;
        
        // Apply basic sales tax if not exempt
        if (!isExempt(item.getCategory())) {
            tax += item.getPrice() * BASIC_TAX_RATE;
        }

        // Apply import duty if item is imported
        if (item.isImported()) {
            tax += item.getPrice() * IMPORT_TAX_RATE;
        }

        return roundUpToNearestFiveCents(tax);
    }

    // Check if the item belongs to a tax-exempt category
    private boolean isExempt(String category) {
        for (String exemptCategory : TAX_EXEMPT_CATEGORIES) {
            if (exemptCategory.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

    // Rounds up to the nearest 0.05
    private double roundUpToNearestFiveCents(double amount) {
        BigDecimal decimal = new BigDecimal(amount);
        return decimal.setScale(2, RoundingMode.UP).doubleValue();
    }

}
