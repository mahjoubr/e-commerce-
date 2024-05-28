package discount;

public class discountapp implements discount{
    private static final double DISCOUNT_RATE = 0.1; // 10% discount for price more than 800TND

    
    public double dodiscount(double totalPrice) {
        if (totalPrice>800) {
            return totalPrice * (1 - DISCOUNT_RATE);
        }
        return totalPrice;
    }
}
