package authentification.accesslvls;

import product.*;

public class user {
    private String username;
    private String password;
    private String role;

    public user(String u, String p, String r) {
        username = u;
        password = p;
        role = r;
    }

    public String getuname() {
        return username;
    }

    public String getpass() {
        return password;
    }

    public String getrole() {
        return role;
    }

    public void affinfo() {
        System.out.println("User Information:");
        System.out.println("Username: " + getuname());
        System.out.println("Role: " + getrole());
    }
}