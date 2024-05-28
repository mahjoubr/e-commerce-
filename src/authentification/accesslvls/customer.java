package authentification.accesslvls;
import order.*;
import product.product;
import shopping.shoppcart;

import java.util.ArrayList;
import discount.discountapp;

public class customer extends user {

    private ArrayList<product> wishlist;
    private ArrayList<order> orderArrayList;

    public customer(String u, String p) {
        super(u, p, "customer");
        wishlist = new ArrayList<>();
        orderArrayList = new ArrayList<>();
    }

    public void addtowishlist(product product) {
        wishlist.add(product);
    }

    public ArrayList<product> getwishlist() {
        return wishlist;
    }

    public ArrayList<order> getorders() {
        return orderArrayList;
    }

    public void createOrder(ArrayList<product> selectedProducts, discountapp discount,shoppcart spc) {
        order order = new order(this, selectedProducts);
        double discountedPrice = order.processOrder(discount,spc);
        System.out.println("Order processed for " + getuname() + " with Total Price: TND" + discountedPrice);
        orderArrayList.add(order);
    }
}
