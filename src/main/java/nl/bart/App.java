package nl.bart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public final static Supermarket supermarket = new Supermarket();

    private static Date date = new Date();
    public static int hourTime = Integer.parseInt("" + date.toString().charAt(11) + date.toString().charAt(12)) + 2;

    public static DateFormat dateFormat2 = new SimpleDateFormat("EEEE");
    public static Date day = new Date();

    public static int getDayOfWeekNumber() {
        if (day.toString().contains("Mon")) return 0;
        if (day.toString().contains("Tue")) return 1;
        if (day.toString().contains("Wed")) return 2;
        if (day.toString().contains("Thu")) return 3;
        if (day.toString().contains("Fri")) return 4;
        if (day.toString().contains("Sat")) return 5;
        if (day.toString().contains("Sun")) return 6;
        return -1;
    }

    public static int getDayNumber(String d) {
        if (day.toString().contains("Mon")) return 0;
        if (day.toString().contains("Tue")) return 1;
        if (day.toString().contains("Wed")) return 2;
        if (day.toString().contains("Thu")) return 3;
        if (day.toString().contains("Fri")) return 4;
        if (day.toString().contains("Sat")) return 5;
        if (day.toString().contains("Sun")) return 6;
        return -1;
    }

    private static void printStuff(String str) {
        try {
            System.out.print(str);
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException exe) {
            System.out.print("Hey you almost killed me.");
        }
    }

    public static void printLine(String str) {
        try {
            System.out.println(str);
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException exe) {
            System.out.println("Hey you almost killed me.");
        }
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

        Discount twoForThree = new Discount(0, "2 for price of 3", "Mon","Mon", 5, 19, true);
        Product sugar = new Product("Sugar", 1, twoForThree);

        Discount hotDeal = new Discount(99, "Hot Deal!", "Wed", "Wed", 5, 19, false);
        Product sambal = new Product("Sambal", 199, hotDeal);

        Discount yolo = new Discount(10, "You only live once, so just buy it!", "Mon", "Sun", 5, 9, false);
        Product milk = new Product("Milk", 99, yolo);

        Discount lowDeal = new Discount(1, "Low Deal...", "Mon", "Sun", 9, 19, false);
        Product carbon = new Product("Carbon", 10, lowDeal);

        Discount lowDeal1 = new Discount(1, "Low Deal...", "Mon", "Sun", 9, 19, false);
        Product carbon1 = new Product("Carbon", 10, lowDeal1);

        supermarket.setBrand("Laidl");

        supermarket.addProduct(milk);
        supermarket.addProduct(sugar);

        supermarket.addProduct(sambal);
        supermarket.addProduct(carbon);

        System.out.println();
        System.out.println("Switching to customer's point of view...");
        System.out.println();

        customer.addProduct(sugar);
        customer.addProduct(sugar);
        customer.addProduct(carbon);
        customer.addProduct(carbon1);
        customer.pay();
    }
}
