package inventory;
import product.*;
import java.util.ArrayList;
import java.util.HashMap;
import search.*;

public class inventory implements searching,filtering{
    private ArrayList<product> products;
    private ArrayList<String> categories;
    private HashMap<String, Integer> productOccurrences;

    public inventory() {
        products = new ArrayList<>();
        categories = new ArrayList<>();
        productOccurrences = new HashMap<>();
    }
    public ArrayList<product> search(String keyword) {
        ArrayList<product> searchResults = new ArrayList<>();
        for (product product : products) {
            if (product.getname().toLowerCase().contains(keyword.toLowerCase()) ||
                product.getcategory().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }
    //filtering the products conatianed in the inventory par categorie
    public ArrayList<product> filter(String category) {
        ArrayList<product> filteredProducts = new ArrayList<>();
        for (product product : products) {
            if (product.getcategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
    public void addProduct(product product) {
        products.add(product);

        // Add or update product occurrences
        String productName = product.getname();
        productOccurrences.put(productName, productOccurrences.getOrDefault(productName, 0) + 1);

        // Add category if not already present
        String category = product.getcategory();
        if (!categories.contains(category)) {
            categories.add(category);
        }

        // Sort products by name
        products.sort((p1, p2) -> p1.getname().compareTo(p2.getname()));
    }

    public void removeProduct(product product) {
        products.remove(product);

        // Update product occurrences
        String productName = product.getname();
        int occurrences = productOccurrences.getOrDefault(productName, 0);
        if (occurrences > 1) {
            productOccurrences.put(productName, occurrences - 1);
        } else {
            productOccurrences.remove(productName);
        }

        // Remove category if no products left in that category
        String category = product.getcategory();
        if (!productOccurrences.containsValue(category)) {
            categories.remove(category);
        }
    }

    public ArrayList<product> getprods() {
        return products;
    }

    public ArrayList<String> getallcateg() {
        return categories;
    }

    public int getprodocc(String productName) {
        return productOccurrences.getOrDefault(productName, 0);
    }
    private static void displayprod(ArrayList<product> products) {
        for (product product : products) {
            System.out.println(product.getname() + " - TND" + product.getprice());
        }
    }
}

