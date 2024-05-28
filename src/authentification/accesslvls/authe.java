package authentification.accesslvls;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class authe {
    private Map<String, user> users;//les keys du map sont les noms des personnes
    private ArrayList<user> currentUsers;

    public authe() {
        users = new HashMap<>();
        currentUsers = new ArrayList<>();
    }
    //return the map of the users
    public Map<String, user> getUsers() {
        return users;
    }
    //register method for both admin and customer
    public user register(String uname, String pass, String role) {
        user u;
        if (role.equals("customer")) {
            u = new customer(uname, pass);
        } else if (role.equals("admin")) {
            u = new admin(uname, pass);
        } else {
            
            u = new user(uname, pass, role);
        }
        

        users.put(uname, u);
        System.out.println("Successfully registrated!");
        return(u);
    }

    public boolean login(String uname, String pass) {
        user u = users.get(uname);
        if (u != null && u.getpass().equals(pass)) {
            currentUsers.add(u);
            
            return(true);
        } else {
            System.out.println(uname + " you're not registered yet or incorrect info entered!");
            return(false);
        }
    }

    public void logout(String uname, String pass) {
        user u = users.get(uname);
        if (u != null && u.getpass().equals(pass)) {
            currentUsers.remove(u);
            System.out.println(u.getuname() + " goodbye!");
        }
    }

    public void getcurrent() {
        System.out.println("Currently logged-in users:");
        for (user u : currentUsers) {
            System.out.println(u.getuname());
        }
    }
    public user getlogginuser() {
        for (user u : currentUsers) {
           
                return  u;
           
        }
        return null; // Return null if no customer is logged in
    }
}
