package shopping;

import java.util.HashMap;
import java.util.Map;

import product.product;

public class shoppcart {
    
    private Map<product, Integer> cartItems;  //map to store the product ak a key and the quantity as a value in the cart

    public shoppcart() {
        cartItems = new HashMap<>();
    }

    /// adding a product
    public void addItem(product product, int quantity) {
        if (cartItems.containsKey(product)) {
            // updating the quantity if exists already
            cartItems.put(product, cartItems.get(product) + quantity);
        } else {
            /// else add the product with its quantity
            cartItems.put(product, quantity);
        }
        System.out.println(quantity + " " + product.getname() + "(s) added to the cart.");
    }

    //updating the quantity of the product if needed
    public void updateItem(product product, int newQuantity) {
        if (cartItems.containsKey(product)) {
            ///if exists
            cartItems.put(product, newQuantity);
            System.out.println(product.getname() + " quantity updated to " + newQuantity + " in the cart.");
        } else {
            System.out.println(product.getname() + " is not in the cart.");
        }
    }

    // Removing product
    public void removeItem(product product) {
        if (cartItems.containsKey(product)) {
            //if exists
            cartItems.remove(product);
            System.out.println(product.getname() + " removed from the cart.");
        } else {
            System.out.println(product.getname() + " is not in the cart.");
        }
    }

    //affichage of items
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<product, Integer> entry : cartItems.entrySet()) {
            product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + quantity + " " + product.getname() + "(s) - TND" + product.getprice() * quantity);
        }
        System.out.println("Total Price: TND" + calcprix());
    }

    // Calculate the total price of items in the cart
    public double calcprix() {
        double totalPrice = 0;
        for (Map.Entry<product, Integer> entry : cartItems.entrySet()) {
            product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getprice() * quantity;
        }
        return totalPrice;
    }
    public Map<product, Integer> getCartItems() {
        return cartItems;
    }
    public void clearCart() {
        cartItems.clear();
        System.out.println("Shopping cart empty.");
    }
}

