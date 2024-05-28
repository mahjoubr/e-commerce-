package payment;

import java.util.Random;

public class edinar implements paymentmeth{
        private int accountnum;

    public edinar(int accnum) {
        accountnum = accnum;
    }

    
    public boolean processPayment(payment payment) {
        // Simulate Edinar payment processing logic
        System.out.println("Processing Edinar payment please wait...");
        // successful or failed payment
        return new Random().nextBoolean();
    }

}
