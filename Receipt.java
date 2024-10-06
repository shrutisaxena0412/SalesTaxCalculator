package sales.tax.com;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
    private List<Item> items;
    private TaxCalculator taxCalculator;

    public Receipt() {
        items = new ArrayList<>();
        taxCalculator = new TaxCalculator();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void printReceipt() {
        double totalSalesTaxes = 0.0;
        double totalPrice = 0.0;

        for (Item item : items) {
            double tax = taxCalculator.calculateTax(item);
            double finalPrice = item.getPrice() + tax;

            // Print item details
            System.out.printf("%s: %.2f%n", item.getName(), finalPrice);

            totalSalesTaxes += tax;
            totalPrice += finalPrice;
        }

        // Print total sales taxes and total amount
        System.out.printf("Sales Taxes: %.2f%n", totalSalesTaxes);
        System.out.printf("Total: %.2f%n", totalPrice);
    }


}
