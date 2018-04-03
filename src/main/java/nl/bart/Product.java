package nl.bart;

import java.util.ArrayList;

public class Product {
    private String name;
    private int price;
    private Discount discount;

    public Product(String name, int price, Discount discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
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

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public String showDiscount() {
        return this.discount.getName();
    }
}
