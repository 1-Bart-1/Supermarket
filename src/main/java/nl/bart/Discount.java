package nl.bart;

public class Discount {
    private int percentage;
    private String name;

    private String beginDate;
    private String endDate;
    private int beginTime;
    private int endTime;
    private boolean discountOrNot;

    public Discount(int percentage, String name, String beginDate, String endDate, int beginTime, int endTime, boolean discountOrNot) {
        this.percentage = percentage;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.discountOrNot = discountOrNot;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean isDiscountOrNot() {
        return discountOrNot;
    }

    public void setDiscountOrNot(boolean discountOrNot) {
        this.discountOrNot = discountOrNot;
    }
}
