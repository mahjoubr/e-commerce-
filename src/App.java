import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import authentification.accesslvls.*;
import discount.discountapp;
import inventory.inventory;
import order.order;
import payment.bankcreditcard;
import payment.cash;
import payment.edinar;
import payment.onlineapp;
import payment.payment;
import payment.paymentmeth;
import payment.paymentprocess;
import product.product;
import shopping.shoppcart;


public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static authe authenticationSystem = new authe();
    private static inventory productInventory = new inventory();
    private static shoppcart shoppingCart = new shoppcart();
    private static user loggedinuser = null;

    public static void main(String[] args) {
        //for the testing purposes
        try{product[] initialProducts = {
            new product("Laptop", "Electronics", 1200),
            new product("Smartphone", "Electronics", 800),
            new product("Coffee Maker", "Appliances", 100),
            new product("Running Shoes", "Sports", 80),
            
        };
        for (product p : initialProducts) {
            productInventory.addProduct(p);
        }

        boolean exit = false;

        do {
            menu();
            try{
            int authChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (authChoice) {
                case 1:
                    authenti();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }} catch (InputMismatchException e) {
        scanner.nextLine(); 
        System.out.println("Invalid input. Please enter a number.");
    }
        } while (!exit);}catch(Exception e){System.out.println("the app is not responding please restart !");}
    }

    private static void menu() {
        System.out.println("\n *            Authentication Menu            *");
        System.out.println("                1/ Authentication");
        System.out.println("                2/ Exit");
        System.out.print("Enter your choice: ");
    }

    private static void authenti() {
        try{boolean backmenu = false;

        do {
            try{
            authmenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    regist();
                    break;
                case 2:
                    loggin();
                    break;
                case 3:
                    loggout();
                    break;
                case 4:
                    admin();
                    break;
                case 5:
                    customer();
                    break;
                case 6:
                    backmenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }} catch (InputMismatchException e) {
                scanner.nextLine();  
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!backmenu);}catch(Exception e){System.out.println("the app is not responding please restart !");}
    }

    private static void authmenu() {
        System.out.println("\n*           User Authentication Menu            *");
        System.out.println("              1/ Register User");
        System.out.println("              2/ Login");
        System.out.println("              3/ Logout");
        System.out.println("              4/ Admin Operations");
        System.out.println("              5/ Customer Operations");
        System.out.println("              6/ Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void regist() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role customer or admin: ");
        String role = scanner.nextLine();

        loggedinuser=authenticationSystem.register(username, password, role);
    }

    private static void loggin() {
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();
        
        if (authenticationSystem.login(loginUsername, loginPassword)) {
            loggedinuser = authenticationSystem.getlogginuser();
            if (loggedinuser != null) {
                System.out.println(loggedinuser.getuname() + " hi again !!");
            } else {
                System.out.println("Error: User information not available.");
            }
        } else {
            System.out.println("Login failed. Please check your info! ");
        }
    }
    
    

    private static void loggout() {
        System.out.print("Enter username: ");
        String logoutUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String logoutPassword = scanner.nextLine();
        authenticationSystem.logout(logoutUsername, logoutPassword);
        loggedinuser = null;
    }

    private static void admin() {
        try{if (loggedinuser.getrole()=="admin") {
            admin adminUser = (admin) loggedinuser;
            adminUser.affloggedin(authenticationSystem);
            adminUser.affinfo(authenticationSystem);
        } else {
            System.out.println("You need to log in as an admin to perform admin operations.");
        }}catch(Exception e){System.out.println("please register and login first !");}
    }

    private static void customer() {
        try{if (loggedinuser.getrole()=="customer") {
            customer customerUser = (customer) loggedinuser;
            int c;
            int  choice=8;
            do {
                try{
                custmenu();

                 choice = scanner.nextInt();
                scanner.nextLine(); 
                c=choice;

                switch (choice) {
                    case 1:
                        affprod();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        addcart();
                        break;
                    case 4:
                        shoppingCart.displayCart();
                        break;
                    case 5:
                        finish();
                        break;
                    case 6:
                       
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }}
                catch (InputMismatchException e) {
                    scanner.nextLine();  
                    System.out.println("Invalid input. Please enter a number.");
                }
                finally{
                    c=choice;
                }
            } while (c!=6);
        } else {
            System.out.println("You need to log in as a customer to perform customer operations.");
        }}catch(Exception e){System.out.println("please register and login first !");}
    }

    private static void custmenu() {
        System.out.println("\n*           Customer Menu           * ");
        System.out.println("              1/ View Products in Inventory");
        System.out.println("              2/ Search Products in Inventory");
        System.out.println("              3/ Add Product to Shopping Cart");
        System.out.println("              4/ View Shopping Cart");
        System.out.println("              5/ Checkout");
        
        System.out.println("              6/ Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void affprod() {
        System.out.println("\n*         All Products in Inventory        *");
        ArrayList<product> allProducts = productInventory.getprods();
        displayprods(allProducts);
    }

    private static void search() {
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();
        ArrayList<product> searchResults = productInventory.search(keyword);
        System.out.println("\n*       Search Results for '" + keyword + "'        *");
        displayprods(searchResults);
    }

    private static void addcart() {
        affprod();
        System.out.print("Enter product name to add to cart: ");
        String productName = scanner.nextLine();
        product selectedProduct = searchname(productInventory, productName);

        if (selectedProduct != null) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            shoppingCart.addItem(selectedProduct, quantity);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    private static product searchname(inventory productInventory, String productName) {
        for (product p : productInventory.getprods()) {
            if (p.getname().equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }
    private static void creditcard() {
    System.out.println("Processing Credit Card Payment...");
    
    System.out.print("Enter the credit card number:");
    int num=scanner.nextInt();
    paymentmeth creditCard = new bankcreditcard(num);
    paymentprocess paymentProcess = new paymentprocess();
    paymentProcess.ppayment(new payment(0, ""), creditCard);
}

private static void cashdel() {
    System.out.println("Processing Cash on Delivery Payment...");
    
    paymentmeth cashOnDelivery = new cash();
    paymentprocess paymentProcess = new paymentprocess();
    paymentProcess.ppayment(new payment(0, ""), cashOnDelivery);
}

private static void edinarpay() {
    System.out.println("Processing Edinar Payment...");
    
    System.out.print("Enter the credit card number:");
    int num=scanner.nextInt();
    paymentmeth edinarPayment = new edinar(num);
    paymentprocess paymentProcess = new paymentprocess();
    paymentProcess.ppayment(new payment(0, ""), edinarPayment);
}

private static void onlineapp() {
    System.out.println("Processing Online Application Payment...");
    
    paymentmeth onlinePayment = new onlineapp(loggedinuser.getuname(),loggedinuser.getuname());
    paymentprocess paymentProcess = new paymentprocess();
    paymentProcess.ppayment(new payment(0, ""), onlinePayment);
}

private static String paymentop() {
    System.out.println("\n*          Payment Options          *");
    System.out.println("             1/ Credit Card");
    System.out.println("             2/ Cash on Delivery");
    System.out.println("             3/ Edinar");
    System.out.println("             4/ Online Application");
    System.out.println("             5/ Back to Customer Menu");
    System.out.print("Enter your choice: ");

    int choice = 0;
    String ch="none";
    boolean validInput = false;

    try{while (!validInput) {
        try {
            choice = scanner.nextInt();
            validInput = true;
    scanner.nextLine();
    
    switch (choice) {
        case 1:
            creditcard();
            ch="credit card";
            
            break;
        case 2:
            cashdel();
            ch="cash on delivery";
            
            break;
        case 3:
            edinarpay();
            ch=" edinar";
            break;
        case 4:
            onlineapp();
            ch="online application";
            break;
        case 5:
            
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
     } }catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
        }}
        }catch(Exception e){System.out.println("the app is not responding please restart !");}
        finally{return(ch);}
}


private static void shippingmethd(String shippingMethod) {
    System.out.println("Processing " + shippingMethod + " Payment...");

   try{ switch (shippingMethod.toLowerCase()) {
        case "standard shipping":
            standardship();
            break;
        case "express shipping":
            expressship();
            break;
        case "next day delivery":
            nextdayship();
            break;
        default:
            System.out.println("Invalid shipping method. Please try again.");
    }}catch(Exception e){System.out.println("the app is not responding please restart !");}
}

private static void standardship() {
    System.out.println("Order will be delivered between 48 and 72 hours for Standard Shipping.");
    
}

private static void expressship() {
    System.out.println("Order will be delivered between 24 and 48 hours for Express Shipping.");
    
}

private static void nextdayship() {
    System.out.println("Order will be delivered after 24 hours for Next Day Delivery.");
    
}


private static String shippingops() {
    System.out.println("\n*          Shipping Options          *");
    System.out.println("             1/ Standard Shipping");
    System.out.println("             2/ Express Shipping");
    System.out.println("             3/ Next Day Delivery");
    System.out.println("             4/ Back to Customer Menu");
    System.out.print("Enter your choice: ");

    int choice = 0;
    String shippingMethod = "none";
    boolean validInput = false;

    while (!validInput) {
        try {
            choice = scanner.nextInt();
            validInput = true;
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shippingMethod = "Standard Shipping";
                    break;
                case 2:
                    shippingMethod = "Express Shipping";
                    break;
                case 3:
                    shippingMethod = "Next Day Delivery";
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }

    return shippingMethod;
}

    
    private static void finish() {
        try{if (loggedinuser != null) {
            shoppingCart.displayCart();
            System.out.print("Do you want to checkout?  ");
            System.out.print("1/ yes  ");
            System.out.print("2/ no  ");
            String checkoutChoice = scanner.nextLine().toLowerCase();

            if (checkoutChoice.equals("yes")) {
                // Process the order
                ArrayList<product> selectedProducts = new ArrayList<>(shoppingCart.getCartItems().keySet());
                order customerOrder = new order((customer)loggedinuser, selectedProducts);
                double discountedPrice = customerOrder.processOrder(new discountapp(),shoppingCart);
                String ch=paymentop();
                String ch1=shippingops() ;
                shippingmethd(ch1);

                

                // Display order details
                System.out.println("\n*           Order Processed              *");
                System.out.println("Total Price: TND" + discountedPrice);
                System.out.println("payment option :"+ch);
                System.out.println("shipping option :"+ch1);
                System.out.println("Thank you for purchasiing !!");
                shoppingCart.clearCart(); // Clear the shopping cart after checkout
            }
        } else {
            System.out.println("You need to log in first!");
        }}catch(Exception e){System.out.println("the app is not responding please restart !");}
    }

    private static void displayprods(ArrayList<product> products) {
        for (product p : products) {
            System.out.println("- " + p.getname() + " - TND" + p.getprice());
        }
    }
}


    

