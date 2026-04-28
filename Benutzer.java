package Tag_8;

public class Benutzer {

    private String benutzername;
    private String email;
    private String passwort;
    private boolean aktiv;

    // Hauptkonstruktor
    public Benutzer(String benutzername, String email, String passwort) {

        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.aktiv = true;
    }

    // Überladener Konstruktor
    public Benutzer(String benutzername, String email, String passwort, boolean aktiv) {
        this(benutzername, email, passwort);
        this.aktiv = aktiv;
    }

    // Getter & Setter

    // benutzername
    public String getBenutzername() {return this.benutzername;}

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    // email
    public String getEmail() {return this.email;}

    public void setEmail(String email) {this.email = email;}

    // passwort
    public String getPasswort() {return passwort;}

    public void setPasswort(String passwort) {this.passwort = passwort;}

    // aktiv
    public boolean isAktiv() {return aktiv;}

    // info()
    public void info() {
        IO.println("Benutzer: "
                + benutzername
                + " (" + email
                + ")\nAktiv: "
                + aktiv
                + "\n");
    }

    @Override
    public String toString() {
        return "Benutzer: " + benutzername + ", email: " + email;
    }
}
