package nl.bart;

import java.util.ArrayList;

public class Customer {
    private boolean inShop;
    private int money = 100;
    private int payMoney;
    private double change = 0;
    private int productsAmount = 0;
    private ArrayList<Product> trolley = new ArrayList<Product>();
    private ArrayList<Product> check = new ArrayList<Product>();
    private ELocation location = ELocation.OUTSIDE;

    public void walk(ELocation location) {
        System.out.println("You're walking to the " + location.toString().toLowerCase() + " of the supermarket.");
        this.location = location;
        System.out.println("You're at the " + this.location.toString().toLowerCase() + " of the supermarket.");
    }

    public void addProduct(Product product) {
        if (this.location != ELocation.SHELVES) {
            this.walk(ELocation.SHELVES);
        }
        this.productsAmount++;
        App.printLine("Adding " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " to your trolley.");

        this.trolley.add(product);

        App.printProducts(trolley, "trolley");

        App.supermarket.removeProduct(product);
    }

    public void removeProduct(Product product) {
        if (this.location != ELocation.SHELVES) {
            this.walk(ELocation.SHELVES);
        }
        App.printLine("Removing " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " from your trolley.");

        this.trolley.remove(product);

        App.printProducts(trolley, "trolley");

        App.supermarket.addProduct(product);
    }

    public void pay() {
        if (this.location != ELocation.CHECKOUT) {
            this.walk(ELocation.CHECKOUT);
        }
        System.out.println("You are paying...");
        this.payMoney = 0;
        for (int i = 0; i < this.trolley.size(); i++) {
            this.payMoney += this.trolley.get(i).getPrice();
        }
        System.out.println("You gave " + this.payMoney + " dollars to the checkout.");
        this.money -= this.payMoney;
        this.receiveChange();

        System.out.println("You paid successfully.");
    }

    public void receiveChange() {
        this.change = App.supermarket.getCashDesk(this.trolley, this.payMoney);
        this.money += this.change;
        if (this.change != 0) {
            System.out.println("You got " + this.change + " dollars back.");
        }
    }
}
