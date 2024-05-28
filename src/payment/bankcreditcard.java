package payment;

import java.util.Random;

public class bankcreditcard implements paymentmeth {
    private int cardnum;
   

    public bankcreditcard(int cnum) {
        this.cardnum = cnum;
        
    }

    
    public boolean processPayment(payment payment) {
        // Simulate bank/credit card payment processing logic
        System.out.println("Processing bank/credit card payment please wait...");
        // successful or failed payment
        return new Random().nextBoolean();
    }
}

