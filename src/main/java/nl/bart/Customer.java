package nl.bart;

import java.util.ArrayList;

public class Customer {
    private boolean inShop;
    private int money = 100;
    private int payMoney;
    private int productsAmount = 0;
    private ArrayList<Product> trolley = new ArrayList<Product>();
    private ArrayList<Product> check = new ArrayList<Product>();
    private ELocation location = ELocation.OUTSIDE;

    private void walk(ELocation location) {
        App.printLine("You're walking to the " + location.toString().toLowerCase() + " of the supermarket.");
        this.location = location;
        App.printLine("You're at the " + this.location.toString().toLowerCase() + " of the supermarket.");
    }

    public void addProduct(Product product) {
        if (this.location != ELocation.SHELVES) {
            this.walk(ELocation.SHELVES);
        }
        this.productsAmount++;
        App.printLine("Adding " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount(0) + " to your trolley.");

        this.trolley.add(product);

        if (this.trolley.size() == 4) {
            for (int i = 0; i < this.trolley.get(3).getDiscounts().size(); i++) {
                this.trolley.get(3).getDiscounts().get(i).setDiscountOrNot(true);
            }
        }

        App.printProducts(trolley, "trolley");

        App.supermarket.removeProduct(product);
    }

    public void removeProduct(Product product) {
        if (this.location != ELocation.SHELVES) {
            this.walk(ELocation.SHELVES);
        }
        App.printLine("Removing " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount(0) + " from your trolley.");

        this.trolley.remove(product);

        App.printProducts(trolley, "trolley");

        App.supermarket.addProduct(product);
    }

    public void pay() {
        if (this.location != ELocation.CHECKOUT) {
            this.walk(ELocation.CHECKOUT);
        }
        App.printLine("You are paying...");
        this.payMoney = 0;
        for (Product aTrolley : this.trolley) {
            this.payMoney += aTrolley.getPrice();
        }
        App.printLine("You gave " + this.payMoney + " dollars to the checkout.");
        this.money -= this.payMoney;
        this.receiveChange();
    }

    private void receiveChange() {
        double change = App.supermarket.getCashDesk(this.trolley, this.payMoney);
        this.money += change;
        if (change != 0) {
            App.printLine("You got " + change + " dollars back.");
        }
    }
}
