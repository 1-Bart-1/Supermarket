package nl.bart;

import java.util.ArrayList;

public class Customer {
    private boolean inShop;
    private int money = 100;
    private ArrayList<Product> trolley = new ArrayList<Product>();
    private ArrayList<Product> check = new ArrayList<Product>();
    private ELocation location;

    private Supermarket supermarket = new Supermarket();

    public void walk(ELocation location) {
        this.location = location;
        System.out.println("You're at the " + this.location.toString() + " of the supermarket.");
    }

    public void addProduct(Product product) {
        App.printLine("Adding " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " to your trolley.");

        this.trolley.add(product);

        App.printProducts(trolley, "trolley");

        supermarket.removeProduct(product);
    }

    public void removeProduct(Product product) {
        App.printLine("Removing " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " from your trolley.");

        this.trolley.remove(product);

        App.printProducts(trolley, "trolley");

        supermarket.addProduct(product);
    }

    public void pay(int price) {
        this.money -= price;
        System.out.println(supermarket.getCashDesk());
    }

    public void receiveChange(int amount) {
        this.money += amount;
    }
}
