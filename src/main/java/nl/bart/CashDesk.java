package nl.bart;

public class CashDesk {
    private int change;
    private int money = 100;
    private int price = 0;

    private int applyDiscount(Product product) {
        product.getDiscount();

        return 0;
    }

    public int payChange(Product product, int money) { // price is of product, money is given by customer
        this.price = product.getPrice();

        this.applyDiscount(product);

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
