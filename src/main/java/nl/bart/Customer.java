package nl.bart;

import java.util.ArrayList;

public class Customer {
    private boolean inShop;
    private int money = 100;
    private ArrayList<Product> trolley = new ArrayList<Product>();
    private ArrayList<Product> check = new ArrayList<Product>();
    private ELocation location;

    public void setInShop(boolean inShop) {
        this.inShop = inShop;
        if (inShop) {
            System.out.println();
        }
    }

    public void addProduct(Product product) {
        this.trolley.add(product);
        this.check.add(product);
    }

    public void removeProduct(Product product) {
        this.trolley.remove(product);
        this.trolley.remove(product);
    }

    public void pay(int price) {
        this.money -= price;
    }

    public void receiveChange(int amount) {
        this.money += amount;
    }
}
