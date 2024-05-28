package authentification.accesslvls;

public class admin extends user {
    public admin(String username, String password) {
        super(username, password, "admin");
    }

    public void affloggedin(authe a) {
        System.out.println("Currently logged-in users for admin only!:");
        a.getcurrent();
    }

    public void affinfo(authe a) {
        System.out.println("All users information for admin only!:");
        for (user u : a.getUsers().values()) {
            u.affinfo();
            System.out.println("Password: " + u.getpass());
        }
    }
}