package nl.bart;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Supermarket supermarket = new Supermarket();
        Discount twoForThree = new Discount(34, "2 for price of 3", "","", 5, 9, true);
        Product milk = new Product("Milk", 99, twoForThree);
        Product sugar = new Product("Sugar", 1, twoForThree);

        supermarket.setBrand("Laidl");
        supermarket.addProduct(milk);
        supermarket.openClose();
        supermarket.addProduct(sugar);
        supermarket.removeProduct(milk);
    }
}
