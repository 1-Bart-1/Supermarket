package nl.bart;

import java.util.ArrayList;

public class Customer {
    private boolean inShop;
    private int money;
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
        trolley.add(product);
        check.add(product);
    }

    public void removeProduct(Product product) {
        trolley.remove(product);
        trolley.remove(product);
    }
}
