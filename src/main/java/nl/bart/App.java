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

    public static DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static Date date = new Date();
    public static int hourTime = Integer.parseInt("" + date.toString().charAt(11) + date.toString().charAt(12)) + 2;

    public static DateFormat dateFormat2 = new SimpleDateFormat("EEEE");
    public static Date day = new Date();

    public static void printStuff(String str) {
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

        Discount twoForThree = new Discount(0, "2 for price of 3", "","", 5, 19, true);
        Product sugar = new Product("Sugar", 1, twoForThree);

        Discount hotDeal = new Discount(99, "Hot Deal!", "Wed", "", 5, 19, false);
        Product sambal = new Product("Sambal", 199, hotDeal);

        Discount yolo = new Discount(10, "You only live once, so just buy it!", "", "", 5, 9, false);
        Product milk = new Product("Milk", 99, yolo);

        Discount lowDeal = new Discount(1, "Low Deal...", "", "", 9, 19, false);
        Product carbon = new Product("Carbon", 10, lowDeal);

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
        customer.addProduct(carbon);
        customer.pay();
    }
}
