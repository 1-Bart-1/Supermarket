package nl.bart;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public final static Supermarket supermarket = new Supermarket();

    public static void printStuff(String str) {
        System.out.print(str);
    }

    public static void printLine(String str) {
        System.out.println(str);
    }

    public static void printProducts(ArrayList<Product> products, String toShow) {
        System.out.println("This is in your " + toShow + ":");
        for (int i = 0; i < products.size(); i++) {
            printStuff("\t" + products.get(i).getName() + ", $" + products.get(i).getPrice() + ", " + products.get(i).showDiscount());
            if (i != products.size() - 1) {
                printLine(",");
            } else {
                printLine(".");
            }
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer();

        Discount twoForThree = new Discount(34, "2 for price of 3", "","", 5, 9, true);
        Discount hotDeal = new Discount(99, "Hot Deal!", "", "", 5, 19, true);
        Discount lowDeal = new Discount(-1000, "Low Deal...", "", "", 9, 19, true);

        Product milk = new Product("Milk", 99, twoForThree);
        Product sugar = new Product("Sugar", 1, twoForThree);
        Product sambal = new Product("Sambal", 199, hotDeal);
        Product carbon = new Product("Carbon", 10, lowDeal);

        supermarket.setBrand("Laidl");

        supermarket.addProduct(milk);
        supermarket.addProduct(sugar);
        supermarket.addProduct(sambal);
        supermarket.addProduct(carbon);

        System.out.println();
        System.out.println("Switching to customer's point of view...");
        System.out.println();

        customer.addProduct(milk);
        customer.pay();
    }
}
