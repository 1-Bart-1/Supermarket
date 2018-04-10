package nl.bart;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CashDesk {
    private double change;
    private double money = 100;
    private double price = 0;

    private double calculateDiscount(ArrayList<Product> products, int i) {
        double discount = 0;
        int hourTime = App.hourTime;
        if (hourTime >= products.get(i).getDiscount().getBeginTime() && hourTime <= products.get(i).getDiscount().getEndTime()) {
            if (products.get(i).getDiscount().getName().equals("2 for price of 3")) {
                if (i == 2) {
                    this.calculatePrice(products); // double paying
                }
                return 1;
            }
            discount = products.get(i).getDiscount().getPercentage();
            System.out.println(discount);
            return discount;
        }
        return 1;
    }

    private void calculatePrice(ArrayList<Product> products) {
        this.price = 0;
        for (int i = 0; i < products.size(); i++) {
            this.price += products.get(i).getPrice();
            this.price -= (this.calculateDiscount(products, i) / 100) * this.price;
        }
        System.out.println("Price: " + this.price);
    }

    public double payChange(ArrayList<Product> products, int money) { // price is of product, money is given by customer

        this.calculatePrice(products);

        this.money += money;
        if (this.price < money) {
            this.change = money - this.price;
        } else if (money == 0) {
            System.out.println("Wow, just don't pay, uh?");
        } else if (this.price > money) {
            System.out.println("Wow, just don't pay enough, uh?");
            this.change = 0;
        }
        this.money = this.money - this.change;
        return this.change;
    }
}
