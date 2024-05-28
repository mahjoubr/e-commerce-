package payment;

public class payment {
    private double amount;
    private String description;

    public payment(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getamount() {
        return amount;
    }

    public String getdescrip() {
        return description;
    }
}
