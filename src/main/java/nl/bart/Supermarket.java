package nl.bart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Supermarket {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Discount> discounts = new ArrayList<Discount>();
    private CashDesk cashDesk = new CashDesk();
    private String brand = "Woops, I don't have a name yet...";
    private int dayOfWeek;
    private int hourTime;
    private boolean opened;
    private final int[][] openingTimes = {
            {
                    8, 16
            },
            {
                    8, 15
            },
            {
                    9, 16
            },
            {
                    5, 17
            },
            {
                    6, 17
            },
            {
                    10, 21
            },
            {
                    11, 23
            }
    };

    public CashDesk getCashDesk() {
        return cashDesk;
    }

    private DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date date = new Date();
    private DateFormat dateFormat2 = new SimpleDateFormat("EEEE");
    private Date day = new Date();

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("Your supermarket is a " + this.brand + ".");
    }

    public void addProduct(Product product) {
        App.printLine("Adding " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " to your " + this.brand);

        this.products.add(product);

        App.printProducts(products, "supermarket");
    }

    public void removeProduct(Product product) {
        App.printLine("Removing " + product.getName() + ", $" + product.getPrice() + ", " + product.showDiscount() + " from your " + this.brand);

        this.products.remove(product);

        App.printProducts(products, "supermarket");
    }

    private int getDayOfWeekNumber() {
        if (this.day.toString().contains("Mon")) {
            return 0;
        } else if (this.day.toString().contains("Tue")) {
            return 1;
        } else if (this.day.toString().contains("Wed")) {
            return 2;
        } else if (this.day.toString().contains("Thu")) {
            return 3;
        } else if (this.day.toString().contains("Fri")) {
            return 4;
        } else if (this.day.toString().contains("Sat")) {
            return 5;
        } else if (this.day.toString().contains("Sun")) {
            return 6;
        }
        return -1;
    }

    public void openClose() {
        this.dayOfWeek = this.getDayOfWeekNumber();
        this.hourTime = Integer.parseInt("" + this.date.toString().charAt(11) + this.date.toString().charAt(12)) + 2;
        if ((this.hourTime >= this.openingTimes[dayOfWeek][0]) && (this.hourTime <= this.openingTimes[dayOfWeek][1])) {
            this.opened = true;
            App.printLine("Whoohooo! The " + this.brand + " is opened now!");
            return;
        }

        this.opened = false;
        App.printLine("Nope, don't even try to get into the " + this.brand);
    }
}
