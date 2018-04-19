package nl.bart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CashDesk {
    private double change;
    private double money = 100;
    private double price = 0;
    private int productNumber = 0;
    private double productPrice;

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private int getDayOfWeekNumber() {
        return App.getDayOfWeekNumber();
    }

    private int getDayNumber(String d) {
        return App.getDayNumber(d);
    }

    private double calculateDiscount(ArrayList<Product> products, int i) { // i is discountNumber
        double discount = 0;
        int hourTime = App.hourTime;
        if (products.get(productNumber).getDiscount(i).isDiscountOrNot()) {
            if ((getDayOfWeekNumber() >= getDayNumber(products.get(productNumber).getDiscount(i).getBeginDate())) && (getDayOfWeekNumber() <= getDayNumber(products.get(productNumber).getDiscount(i).getEndDate()))) {
                if (hourTime >= products.get(this.productNumber).getDiscount(i).getBeginTime() && hourTime <= products.get(this.productNumber).getDiscount(i).getEndTime()) {
                    if (products.get(this.productNumber).getDiscount(i).getName().equals("2 for price of 3")) {
                        if (this.productNumber == 1) {
                            this.price += productPrice;
                        }
                        return 0;
                    }
                    if (products.get(this.productNumber).getDiscount(i).getName().equals("Dollar Power")) {
                        productPrice = 1;
                    }
                    discount = products.get(this.productNumber).getDiscount(i).getPercentage();
                    return 100 - discount; // discount is wrong way around
                }
            }
        }
        return 0;
    }

    private void calculatePrice(ArrayList<Product> products) {
        this.price = 0;
        for (this.productNumber = 0; this.productNumber < products.size(); this.productNumber++) {
            productPrice = products.get(this.productNumber).getPrice();
            for (int i = 0; i < products.get(productNumber).getDiscounts().size(); i++) {
                productPrice = this.calculateDiscount(products, i) != 0 ? (this.calculateDiscount(products, i) / 100) * productPrice : productPrice;
            }
            this.price += productPrice;
            App.printLine(products.get(productNumber).getName() + " : $" + productPrice);
        }
        this.price = round(this.price);
        App.printLine("Your total checkout price is: " + this.price + " dollars.");
    }

    public double payChange(ArrayList<Product> products, int money) { // price is of product, money is given by customer
        this.calculatePrice(products);

        this.money += money;
        if (this.price < money) {
            this.change = money - this.price;
            App.printLine("You paid successfully.");
        } else if (money == 0) {
            App.printLine("Wow, just don't pay, uh?");
            App.printLine("");
            App.printLine("You ran away successfully.");
        } else if (this.price > money) {
            App.printLine("Wow, just don't pay enough, uh?");
            App.printLine("\tYou paid " + money + " dollars.");
            App.printLine("\tYou had to pay " + this.price + " dollars.");
            App.printLine("");
            App.printLine("You ran away successfully.");
            this.change = 0;
        }
        this.money = this.money - this.change;
        this.change = round(this.change);
        return this.change;
    }
}
