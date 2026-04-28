package Tag_8;

public class Gast extends Benutzer {

    private int gueltigBisTag;

    public Gast(String benutzername, String email, String passwort, int gueltigBisTag) {
        super(benutzername, email, passwort);
        this.gueltigBisTag = gueltigBisTag;
    }

    @Override
    public void info() {
        IO.println("Gast: "
                + getBenutzername()
                + ", gültig bis Tag "
                + gueltigBisTag
                + "\nAktiv: "
                + isAktiv());
    }
}
