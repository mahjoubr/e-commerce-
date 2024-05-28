#### Shopping System Application
This Java application implements a shopping system with user authentication, product inventory, shopping cart functionality, order processing, and payment and shipping options. The system includes different user access levels, such as admin and customer.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

# Project Overview

This project implements a simple authentication and shopping system using Java. Below, I outline my design decisions and the Object-Oriented Programming (OOP) principles employed in the code.


## Design Decisions

1. **Authentication System:**
   - I chose to implement a modular authentication system to handle user registration, login, and logout functionalities.
   - Users can register as either customers or administrators, each with specific roles and permissions.

2. **User Hierarchy:**
   - I implemented a user hierarchy with a base `user` class and subclasses `admin` and `customer` to encapsulate role-specific functionalities.

3. **Inventory and Products:**
   - The system includes an inventory to manage products, allowing users to view, search, and add items to their shopping cart.

4. **Shopping Cart:**
   - A shopping cart (shoppcart) is used to manage the items selected by customers during their shopping session.

5. **Orders and Discounts:**
   - The system supports order processing, where customers can place orders, and administrators can view logged-in users and their information.
   - A simple discount mechanism is applied using the `discountapp` class.

## Object-Oriented Programming (OOP) Implementation

1. **Inheritance:**
   - Inheritance is utilized to create specialized classes (`admin` and `customer`) derived from the base `user` class.

2. **Encapsulation:**
   - The encapsulation principle is followed by encapsulating related functionalities within appropriate classes (e.g., `authe`, `customer`, `admin`).

3. **Polymorphism:**
   - Polymorphism is demonstrated through the `processOrder` method in the `order` class, allowing for different discount strategies.

4. **Abstraction:**
   - Abstraction is achieved by creating abstract classes (`paymentmeth`, `searching`, `filtering`) and interfaces to define common behaviors.

### code infos
# Classes :
----admin (Package: authentification.accesslvls)
Purpose: Represents an admin user with elevated privileges.
Functionalities:
Display currently logged-in users (admin only).
Display information of all users (admin only).


----authe (Package: authentification.accesslvls)
Purpose: Manages user authentication and registration.
Functionalities:
Register users (admin and customer).
Login and logout users.
Display currently logged-in users.


----customer (Package: authentification.accesslvls)
Purpose: Represents a customer user with shopping-related functionalities.
Functionalities:
Add products to a wishlist.
Create orders with selected products and apply discounts.


-----user (Package: authentification.accesslvls)
Purpose: Represents a basic user with common attributes and functionalities.
Functionalities:
Display user information.


-----discountapp (Package: discount)
Purpose: Implements a discount interface for applying discounts on orders.
Functionalities:
Apply a discount based on the total order price.


-----inventory (Package: inventory)
Purpose: Manages product inventory, search, and filtering.
Functionalities:
Add and remove products from the inventory.
Search for products based on keywords.
Filter products by category.


-----order (Package: order)
Purpose: Represents an order made by a customer.
Functionalities:
Calculate the total price of the order.
Process the order by applying discounts.



-----bankcreditcard, cash, edinar, onlineapp (Package: payment)
Purpose: Implement payment methods.
Functionalities:
Process payments based on the chosen method.


-----payment (Package: payment)
Purpose: Represents a payment with an amount and description.


-----paymentmeth (Package: payment)
Purpose: Defines a payment method interface.


-----paymentprocess (Package: payment)
Purpose: Handles the payment process based on the chosen payment method.


-----product (Package: product)
Purpose: Represents a product with attributes like name, category, and price.


-----filtering, searching (Package: search)
Purpose: Define interfaces for searching and filtering products.


-----options, shipping (Package: shipping)
Purpose: Define interfaces and classes for shipping options.


-----shoppcart (Package: shopping)
Purpose: Manages the shopping cart with functionalities to add, update, and remove items.

Note: The code contains various functionalities related to user authentication, product management, order processing, and payment. Ensure proper inputs and follow the instructions prompted during the execution of the program.



## features:

1. User Authentication
2. Product Management
3. Shopping Cart
4. Order Processing
5. Inventory Management
6. Dynamic Product Search and Filtering
7. Payment Processing
8. Discounts and Promotions(extra)
9. Shipping Options(extra)


##  How to Use the Application

Run the application.
Register users (admin or customer).
Login with registered credentials.
Perform actions based on user access level (admin or customer).
Add products to the shopping cart, create orders, and proceed to checkout.


when Running the application:
    Choose an option from the main menu:
        1-Authentication
        2-Exit
If you choose Authentication, you will be presented with the User Authentication Menu.
    Register User
    Login
    Logout
    Admin Operations
    Customer Operations
    Back to Main Menu
Depending on your choice, you can register a new user, log in, log out, perform admin operations (if logged in as admin), or perform customer operations (if logged in as a customer).

**Customer Operations Menu:
        View Products in Inventory
        Search Products in Inventory
        Add Product to Shopping Cart
        View Shopping Cart
        Checkout
        Back to Main Menu
Depending on your choice, you can perform various actions such as viewing products, searching for products, adding products to the shopping cart, viewing the shopping cart, and checking out.

**During the checkout process, you will be prompted to choose a payment option and a shipping method.
Payment Options:
    Credit Card
    Cash on Delivery
    Edinar
    Online Application
Shipping Options:
    Standard Shipping
    Express Shipping
    Next Day Delivery
The application will process the payment and display order details, including the total price, chosen payment option, and chosen shipping method.
Thank you for using the shopping system application!
Note

# The application includes initial product data for testing purposes.
Ensure to provide valid inputs when prompted.
Follow the instructions provided during the execution of the program.
For testing, you can use the initial products such as Laptop, Smartphone, Coffee Maker, and Running Shoes.
Feel free to explore and enjoy shopping!


## credits:
This project was created by Refka Mahjoub GL2-2023