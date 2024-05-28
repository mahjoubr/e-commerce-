package payment;

import java.util.Random;

public class onlineapp implements paymentmeth{
     private String appusern;
    private String apppass;

    public onlineapp(String usernme, String pass) {
        appusern = usernme;
        apppass = pass;
    }

    
    public boolean processPayment(payment payment) {
        // Simulate online application payment processing logic
        System.out.println("Processing online application payment please wait...");
        // successful or failed payment
        return new Random().nextBoolean();
    }
}
