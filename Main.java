package sales.tax.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of items:");
        int numItems = Integer.parseInt(scanner.nextLine());

        Receipt receipt = new Receipt();

        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter item details (e.g., '1 book at 12.49'):");

            String input = scanner.nextLine();

            // Parse the input
            String[] parts = input.split(" at ");
            String itemDescription = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());

            // Determine if it's imported based on the description
            boolean isImported = itemDescription.contains("imported");

            // Extract the name of the item by removing the quantity and 'imported' if present
            String itemName = itemDescription.replaceAll("^\\d+ ", "").replace("imported ", "").trim();

            // Determine category based on keywords (you can improve this part to be more comprehensive)
            String category;
            if (itemName.contains("book")) {
                category = "book";
            } else if (itemName.contains("chocolate") || itemName.contains("bar")) {
                category = "food";
            } else if (itemName.contains("pill")) {
                category = "medical";
            } else {
                category = "other";
            }

            // Create item and add to receipt
            Item item = new Item(itemName, price, isImported, category);
            receipt.addItem(item);
        }

        System.out.println("Receipt:");
        receipt.printReceipt();
    }
}
