package Tag_8;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOutput {


    static void userOutput(ResultSet rs) throws SQLException {

        String typ = rs.getString("typ");
        if (typ.equals("benutzer")) {
            IO.println("Benutzer: "
                    + rs.getString("name")
                    + " (" + rs.getString("email")
                    + ")\nAktiv: "
                    + rs.getBoolean("aktiv")
                    + "\n");
        } else if (typ.equals("admin")) {
            IO.println("Admin: "
                    + rs.getString("name")
                    + " (" + rs.getString("email")
                    + ")\nIst SuperAdmin: "
                    + rs.getBoolean("ist_super_admin")
                    + "\n");
        } else if (typ.equals("gast")) {
            IO.println("Gast: "
                    + rs.getString("name")
                    + " (" + rs.getString("email")
                    + ")\nTage gültig: "
                    + rs.getInt("gueltig_bis_tage")
                    + "\n");
        }
    }
}
