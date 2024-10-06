package sales.tax.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    System.out.println("Output 1:");
    Receipt receipt1 = new Receipt();
    receipt1.addItem(new Item("book", 12.49, false, "book"));
    receipt1.addItem(new Item("music CD", 14.99, false, "other"));
    receipt1.addItem(new Item("chocolate bar", 0.85, false, "food"));
    receipt1.printReceipt();
    System.out.println();

    // Input 2: 1 imported box of chocolates at 10.00, 1 imported bottle of perfume at 47.50
    System.out.println("Output 2:");
    Receipt receipt2 = new Receipt();
    receipt2.addItem(new Item("imported box of chocolates", 10.00, true, "food"));
    receipt2.addItem(new Item("imported bottle of perfume", 47.50, true, "other"));
    receipt2.printReceipt();
    System.out.println();

    // Input 3: 1 imported bottle of perfume at 27.99, 1 bottle of perfume at 18.99,
    // 1 packet of headache pills at 9.75, 1 box of imported chocolates at 11.25
    System.out.println("Output 3:");
    Receipt receipt3 = new Receipt();
    receipt3.addItem(new Item("imported bottle of perfume", 27.99, true, "other"));
    receipt3.addItem(new Item("bottle of perfume", 18.99, false, "other"));
    receipt3.addItem(new Item("packet of headache pills", 9.75, false, "medical"));
    receipt3.addItem(new Item("imported box of chocolates", 11.25, true, "food"));
    receipt3.printReceipt();
}
}
