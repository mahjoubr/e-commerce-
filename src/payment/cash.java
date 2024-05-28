package payment;

public class cash implements paymentmeth {
    public boolean processPayment(payment payment) {
        // Simulate cash on delivery payment processing logic
        System.out.println("Processing cash on delivery payment please wait...");
        
        return true;
    }
}
