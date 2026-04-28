package Tag_8;

public class Admin extends Benutzer {

    private boolean superAdmin;

    public Admin(String benutzername, String email, String passwort, boolean superAdmin) {
        super(benutzername, email, passwort);
        this.superAdmin = true;
    }

    @Override
    public void info() {
        IO.println("Admin: "
                + getBenutzername()
                + " (" + getEmail()
                + "), SuperAdmin: "
                + superAdmin
                + "\nAktiv: "
                + isAktiv());
    }
}
