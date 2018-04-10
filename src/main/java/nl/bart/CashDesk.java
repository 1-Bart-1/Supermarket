package nl.bart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CashDesk {
    private double change;
    private double money = 100;
    private double price = 0;

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private double calculateDiscount(ArrayList<Product> products, int i) {
        double discount = 0;
        int hourTime = App.hourTime;
        if (hourTime >= products.get(i).getDiscount().getBeginTime() && hourTime <= products.get(i).getDiscount().getEndTime()) {
            if (products.get(i).getDiscount().getName().equals("2 for price of 3")) {
                if (i == 2) {
                    this.calculatePrice(products); // double paying
                }
                return 0;
            }
            discount = products.get(i).getDiscount().getPercentage();
            return discount;
        }
        return 0;
    }

    private void calculatePrice(ArrayList<Product> products) {
        this.price = 0;
        for (int i = 0; i < products.size(); i++) {
            this.price += products.get(i).getPrice();
            this.price -= (this.calculateDiscount(products, i) / 100) * this.price;
        }
        this.price = round(this.price, 2);
        System.out.println("Your total checkout price is: " + this.price + " dollars.");
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
            System.out.println("\tYou paid " + money + " dollars.");
            System.out.println("\tYou had to pay " + this.price + " dollars.");
            this.change = 0;
        }
        this.money = this.money - this.change;
        return this.change;
    }
}
