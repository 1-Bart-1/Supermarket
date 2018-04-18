package nl.bart;

import java.util.ArrayList;

public class Product {
    private String name;
    private int price;
    private ArrayList<Discount> discounts = new ArrayList<Discount>();

    public Product(String name, int price, Discount discount) {
        this.name = name;
        this.price = price;
        this.discounts.add(discount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }

    public Discount getDiscount(int i) {
        return discounts.get(i);
    }

    public String showDiscount(int i) {
        return this.discounts.get(i).getName();
    }
}
