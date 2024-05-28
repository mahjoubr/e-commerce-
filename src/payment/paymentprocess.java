package payment;

public class paymentprocess {
    public boolean ppayment(payment payment, paymentmeth paymentMethod) {
        return paymentMethod.processPayment(payment);
    }
}
