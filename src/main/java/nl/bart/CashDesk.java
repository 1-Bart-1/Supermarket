package nl.bart;

public class CashDesk {
    private int change;
    private int money = 100;

    public int payChange(int price, int money) { // price is of product, money is given by customer
        this.money += money;
        if (price < money) {
            this.change = money - price;
        } else if (money == 0) {
            System.out.println("Wow, just don't pay, uh?");
        } else if (price > money) {
            System.out.println("Wow, just don't pay enough, uh?");
            this.change = 0;
        }
        this.money = this.money - this.change;
        return this.change;
    }
}
