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
        if (products.get(i).getDiscount().isDiscountOrNot()) {
            if (App.day.toString().contains(products.get(i).getDiscount().getBeginDate()) || products.get(i).getDiscount().getBeginDate().equals("")) {
                if (hourTime >= products.get(i).getDiscount().getBeginTime() && hourTime <= products.get(i).getDiscount().getEndTime()) {
                    if (products.get(i).getDiscount().getName().equals("2 for price of 3")) {
                        if (i == 1) {
                            this.price += (0.5 * this.price); // why doesn't this work
                        }
                        return 0;
                    }
                    App.printLine("You've got a discount on your " + products.get(i).getName() + "!");
                    discount = products.get(i).getDiscount().getPercentage();
                    return discount;
                }
            }
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
            App.printLine("You ran away succesfully.");
        } else if (this.price > money) {
            App.printLine("Wow, just don't pay enough, uh?");
            App.printLine("\tYou paid " + money + " dollars.");
            App.printLine("\tYou had to pay " + this.price + " dollars.");
            App.printLine("");
            App.printLine("You ran away successfully.");
            this.change = 0;
        }
        this.money = this.money - this.change;
        this.change = round(this.change, 2);
        return this.change;
    }
}
