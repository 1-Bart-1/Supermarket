package nl.bart;

import java.util.ArrayList;

public class Customer {
    private boolean inShop;
    private int money = 100;
    private int payMoney;
    private int change = 0;
    private int productsAmount = 0;
    private ArrayList<Product> trolley = new ArrayList<Product>();
    private ArrayList<Product> check = new ArrayList<Product>();
    private ELocation location;

    public void walk(ELocation location) {
        this.location = location;
        System.out.println("You're at the " + this.location.toString() + " of the supermarket.");
    }

    public void addProduct(Product product) {
        this.productsAmount++;
        App.printLine("Adding " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " to your trolley.");

        this.trolley.add(product);

        App.printProducts(trolley, "trolley");

        App.supermarket.removeProduct(product);
    }

    public void removeProduct(Product product) {
        App.printLine("Removing " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " from your trolley.");

        this.trolley.remove(product);

        App.printProducts(trolley, "trolley");

        App.supermarket.addProduct(product);
    }

    public void pay() {
        int price = 0;

        this.payMoney = price + 5;
        this.money -= this.payMoney;
        this.receiveChange();
    }

    public void receiveChange() {
        this.change = App.supermarket.getCashDesk(this.trolley, this.payMoney);
        System.out.println(this.change);
        this.money += change;
    }
}
