package order;
import product.*;
import authentification.accesslvls.*;
import discount.discountapp;
import shopping.shoppcart;


import java.util.ArrayList;

public class order {
    
     private customer customer;
    private ArrayList<product> selectedProducts;

    public order(customer customer, ArrayList<product> selectedProducts) {
        this.customer = customer;
        this.selectedProducts = selectedProducts;
    }

    public double caltotprice(shoppcart spc) {
        double totprice = spc.calcprix();
        
        return totprice;
    }

    public double processOrder(discountapp discount, shoppcart spc) {
        double totprice = caltotprice(spc);
        double discprice = discount.dodiscount(totprice);
        
        
        System.out.println("Original Price: TND" + totprice);
        System.out.println("Discounted Price: TND" + discprice);
    
        return discprice;
    }
}

