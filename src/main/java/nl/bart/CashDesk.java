package nl.bart;

import java.util.ArrayList;

public class CashDesk {
    private int change;
    private int money = 100;
    private int price = 0;

    private int applyDiscount(ArrayList<Product> products) {
        for (int i = 0; i < products.size() - 1; i++) {

        }


        return 0;
    }

    public int payChange(ArrayList<Product> products, int money) { // price is of product, money is given by customer
        this.price = products.get(0).getPrice();

        this.applyDiscount(products);

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
