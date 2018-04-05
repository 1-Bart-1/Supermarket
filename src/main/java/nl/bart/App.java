package nl.bart;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
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

//        customer.addProduct(milk);
    }
}
