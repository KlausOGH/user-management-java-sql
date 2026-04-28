package Tag_8;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static Tag_8.UserOutput.userOutput;

public class Main {

    static void main(String[] args) {

//        // Benutzer erstellung
//        Benutzer benutzer1 = new Benutzer("Calle", "calle@skvalle.dk", "fraen");
//
//        Benutzer benutzer2 = new Benutzer("Klaus", "klaus_m_olesen@hotmail.com", "test");
//
//        Benutzer benutzer3 = new Benutzer("Batman", "nananan@batman.com", "batmobil");
//
//        // info() Aufruf
//        benutzer1.info();
//        benutzer2.info();
//        benutzer3.info();
//
//        // re-set email und pw
//        benutzer1.setEmail("76_moellehjul@ham_den_tynde.dk");
//        benutzer1.setPasswort("67_4_life");
//
//        // benutzer1 erneuter info() Aufruf
//        benutzer1.info();
//
//        // Admin-Erstellung
//        Benutzer admin1 = new Admin("KMO", "klausmeyer.olesen@gfn.education", "1234", true);
//
//        // Gast-Erstellung
//        Benutzer gast1 = new Gast("anna_guest", "anna123@yahoo.com", "geh_heim", 3);
//
//        // Admin & Gast - info() Aufruf
//        admin1.info();
//
//        gast1.info();

        // Array-Liste
        ArrayList<Benutzer> list = new ArrayList<>();
        list.add(new Benutzer("Klaus", "klaus@olesen.dk", "test123", true));
        list.add(new Benutzer("Lisa", "lisa@hallo.de", "hallohallotesttest", true));
        list.add(new Admin("KMO", "klausmeyer.olesen@gfn.education", "123", true));
        list.add(new Gast("Trommel-Peter", "trommel@wacken.de", "hinnack", 5));
//
//        // Funktionstest
//        IO.println(list.get(1));

        // Datenbankverbindung-Erstellung
        try {
            Connection conn = verbindung();


            // Menü - While-Schleife
            Scanner scanner = new Scanner(System.in);

            while (true) {
                IO.print("=============== Benutzerverwaltung ==============="
                        + "\n1) Benutzerliste anzeigen"
                        + "\n2) Benutzer hinzufügen"
                        + "\n3) Benutzer löschen"
                        + "\n4) Benutzer suchen"
                        + "\n5) Benutzer bearbeiten"
                        + "\n6) Spezialfunktionen"
                        + "\n0) Programm beenden"
                        + "\n--------------------------------------------------"
                        + "\nAuswahl: ");
                String input = scanner.nextLine();
                try {
                    int menueAuswahl = Integer.parseInt(input);
                    switch (menueAuswahl) {

// Case 0               // Abbrechen
                        case 0:
                            IO.println("\nAuf wiedersehen!");
                            scanner.close();
                            conn.close(); // verbindung() schließen
                            return;

// Case 1               // Benutzer Auflistung
                        case 1:
                            IO.println("\nBenutzerliste:\n");
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM benutzer;");

                            while (rs.next()) {
                                userOutput(rs);
                            }
//                            // Struktur von Array-List-Abfrage zum vergleich/nachbauen aus Benutzer-Klasse eingefügt
//                            IO.println("Benutzer: "
//                                    + benutzername
//                                    + " (" + email
//                                    + ")\nAktiv: "
//                                    + aktiv
//                                    + "\n");

//                            // Array-List
//                            if (list.isEmpty()) {
//                                IO.println("Die Benutzerliste ist leer!\n");
//                            } else {
//                                for (Benutzer benutzer : list) {
//                                    benutzer.info();
//                                    IO.println();
//                                }
//                            }
                            break;

// Case 2               Benutzer hinzufügen (erstmal die Basics üben, später dann schlauere Abfragungsmethoden)
                        case 2:
                            while (true) {
                                IO.print("\nBenutzer hinzufügen:\n"
                                        + "\n=============== Typ angeben ==============="
                                        + "\n1) Benutzer"
                                        + "\n2) Admin"
                                        + "\n3) Gast"
                                        + "\n0) Zurück!"
                                        + "\n-------------------------------------------"
                                        + "\nAuswahl: ");
                                String hinzfuegenInput = scanner.nextLine();
                                try {
                                    int hinzufuegenAuswahl = Integer.parseInt(hinzfuegenInput);
                                    if (hinzufuegenAuswahl >= 0 && hinzufuegenAuswahl <= 3) {
                                        if (hinzufuegenAuswahl == 0) { // Zurück
                                            IO.println();
                                            break;
                                        } else if (hinzufuegenAuswahl == 1) {                           // Benutzer hinzufügen
                                            IO.println("\nBenutzer hinzufügen\n");

                                            // Benutzernamen-Angabe
                                            String nameBenutzer = "";
                                            while (nameBenutzer.isBlank()) {
                                                IO.print("Wie lautet der Benutzername?: ");
                                                nameBenutzer = scanner.nextLine();
                                                if (nameBenutzer.isBlank()) {
                                                    IO.println("\nEs muss ein Benutzername eingegeben werden!\n");
                                                }
                                            }

                                            // Email-Adressen-Angabe
                                            String emailBenutzer = "";
                                            while (emailBenutzer.isBlank()) {
                                                IO.print("Wie lautet die Email-Adresse?: ");
                                                emailBenutzer = scanner.nextLine();
                                                if (emailBenutzer.isBlank()) {
                                                    IO.println("\nEs muss eine Email-Adresse angegeben werden!\n");
                                                }
                                            }

                                            // Passwort-Angabe
                                            String passwortBenutzer = "";
                                            while (passwortBenutzer.isBlank()) {
                                                IO.print("Wie lautet das Passwort?: ");
                                                passwortBenutzer = scanner.nextLine();
                                                if (passwortBenutzer.isBlank()) {
                                                    IO.println("\nEs muss ein Passwort angegeben werden!\n");
                                                }
                                            }

                                            // Status-Angabe
                                            Boolean statusBenutzer = false;
                                            while (true) {
                                                IO.print("Ist der Benutzer aktiv (ja/nein)?: ");
                                                String eingabeStatusBenutzer = scanner.nextLine();
                                                if (eingabeStatusBenutzer.equals("ja")) {
                                                    statusBenutzer = true;
                                                    break;
                                                } else if (eingabeStatusBenutzer.equals("nein")) {
                                                    statusBenutzer = false;
                                                    break;
                                                } else {
                                                    IO.println("\nBitte 'ja' oder 'nein' angeben!\n");
                                                }
                                            }
                                            PreparedStatement psBenutzer = conn.prepareStatement("INSERT INTO benutzer(typ, name, email, passwort, aktiv) VALUES(?, ?, ?, ?, ?)");
                                            psBenutzer.setString(1, "benutzer");
                                            psBenutzer.setString(2, nameBenutzer);
                                            psBenutzer.setString(3, emailBenutzer);
                                            psBenutzer.setString(4, passwortBenutzer);
                                            psBenutzer.setBoolean(5, statusBenutzer);
                                            psBenutzer.executeUpdate();
//                                            // Array-List-Eintrag-hinzufügen
//                                            list.add(new Benutzer(nameBenutzer, emailBenutzer, passwortBenutzer, statusBenutzer));

                                            // Bestätigung
                                            IO.println("\nBenutzer wurde hinzugefügt!");

                                        } else if (hinzufuegenAuswahl == 2) {                               // Admin hinzufügen
                                            IO.println("\nAdmin hinzufügen\n");

                                            // Adminnamen-Angabe
                                            String nameAdmin = "";
                                            while (nameAdmin.isBlank()) {
                                                IO.print("Wie lautet der Adminname?: ");
                                                nameAdmin = scanner.nextLine();
                                                if (nameAdmin.isBlank()) {
                                                    IO.println("\nEs muss ein Adminname angegeben werden!\n");
                                                }
                                            }

                                            // Email-Adressen-Angabe
                                            String emailAdmin = "";
                                            while (emailAdmin.isBlank()) {
                                                IO.print("Wie lautet die Email-Adresse?: ");
                                                emailAdmin = scanner.nextLine();
                                                if (emailAdmin.isBlank()) {
                                                    IO.println("\nEs muss eine Email-Adresse angegeben werden!\n");
                                                }
                                            }

                                            // Passwort-Angabe
                                            String passwortAdmin = "";
                                            while (passwortAdmin.isBlank()) {
                                                IO.print("Wie lautet das Passwort?: ");
                                                passwortAdmin = scanner.nextLine();
                                                if (passwortAdmin.isBlank()) {
                                                    IO.println("\nEs muss ein Passwort angegeben werden!\n");
                                                }
                                            }

                                            // superAdmin-Angabe
                                            Boolean istSuperAdmin = false;
                                            while (true) {
                                                IO.print("Is superAdmin (ja/nein)?: ");
                                                String inputIstSuperAdmin = scanner.nextLine();
                                                if (inputIstSuperAdmin.equals("ja")) {
                                                    istSuperAdmin = true;
                                                    break;
                                                } else if (inputIstSuperAdmin.equals("nein")) {
                                                    istSuperAdmin = false;
                                                    break;
                                                } else {
                                                    IO.println("\nBitte 'ja' oder 'nein' angeben!\n");
                                                }
                                            }


                                            PreparedStatement psAdmin = conn.prepareStatement("INSERT INTO benutzer(typ, name, email, passwort, ist_super_admin) VALUES(?, ?, ?, ?, ?)");
                                            psAdmin.setString(1, "admin");
                                            psAdmin.setString(2, nameAdmin);
                                            psAdmin.setString(3, emailAdmin);
                                            psAdmin.setString(4, passwortAdmin);
                                            psAdmin.setBoolean(5, istSuperAdmin);
                                            psAdmin.executeUpdate();
//
//                                            // Array-List-Eintrag-hinzufügen
//                                            list.add(new Admin(nameAdmin, emailAdmin, passwortAdmin, istSuperAdmin));

                                            // Bestätigung
                                            IO.println("\nAdmin wurde hinzugefügt!");

                                        } else if (hinzufuegenAuswahl == 3) {                               // Gast hinzufügen
                                            IO.println("\nGast hinzufügen\n");

                                            // Gastnamen-Angabe
                                            String nameGast = "";
                                            while (nameGast.isBlank()) {
                                                IO.print("Wie lautet der Gastname?: ");
                                                nameGast = scanner.nextLine();
                                                if (nameGast.isBlank()) {
                                                    IO.println("\nEs muss ein Gastname angegeben werden!\n");
                                                }
                                            }

                                            // Email-Adressen-Angabe
                                            String emailGast = "";
                                            while (emailGast.isBlank()) {
                                                IO.print("Wie lautet die Email-Adresse?: ");
                                                emailGast = scanner.nextLine();
                                                if (emailGast.isBlank()) {
                                                    IO.println("\nEs muss eine Email-Adresse angegeben werden!\n");
                                                }
                                            }

                                            // Passwort-Angabe
                                            String passwortGast = "";
                                            while (passwortGast.isBlank()) {
                                                IO.print("Wie lautet das Passwort?: ");
                                                passwortGast = scanner.nextLine();
                                                if (passwortGast.isBlank()) {
                                                    IO.println("\nEs muss ein Passwort angegeben werden!\n");
                                                }
                                            }

                                            // Gültig bis
                                            String inputGueltigBisTagGast = "";
                                            int gueltigBisTagGast = 0;
                                            while (gueltigBisTagGast <= 0) {
                                                IO.print("Wie viele Tage ist der Gast-Zugang noch gültig?: ");
                                                inputGueltigBisTagGast = scanner.nextLine();
                                                try {
                                                    int parsedGueltigBisTagGast = Integer.parseInt(inputGueltigBisTagGast);
                                                    if (parsedGueltigBisTagGast > 0) {
                                                        gueltigBisTagGast = parsedGueltigBisTagGast;
                                                        break;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    IO.println("\nBitte verwende eine Zahl!\n");
                                                }
                                            }
                                            PreparedStatement psGast = conn.prepareStatement("INSERT INTO benutzer(typ, name, email, passwort, gueltig_bis_tage) VALUES(?, ?, ?, ?, ?)");
                                            psGast.setString(1, "gast");
                                            psGast.setString(2, nameGast);
                                            psGast.setString(3, emailGast);
                                            psGast.setString(4, passwortGast);
                                            psGast.setInt(5, gueltigBisTagGast);
                                            psGast.executeUpdate();

//                                            // Array-List-Eintrag-hinzufügen
//                                            list.add(new Gast(nameGast, emailGast, passwortGast, gueltigBisTagGast));

                                            // Bestätigung
                                            IO.println("\nGast wurde hinzugefügt!");
                                        }
                                    } else {
                                        IO.println("\nBitte verwende eine Zahl zwischen 0 und 3!\n");
                                    }
                                } catch (NumberFormatException e) {
                                    IO.println("\nBitte verwende eine gültige Zahl zwischen 0 und 3!\n");
                                }
                            }
                            break;
// Case 3
                        case 3:
                            IO.println("\nBenutzer löschen:\n");

                            // E-Mail-Adressen-Abfragung
                            IO.print("Wie lautet die E-Mail-Adresse des Benutzers?: ");
                            String zuLoeschendeEMail = scanner.nextLine();

                            // Listen-Eintrag-Vergleichs-Schleife
                            boolean emailGefunden = false;

                            PreparedStatement psDelFind = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                            psDelFind.setString(1, zuLoeschendeEMail);
                            ResultSet rsDel = psDelFind.executeQuery();
                            while (rsDel.next()) {
                                PreparedStatement psDel = conn.prepareStatement("DELETE FROM benutzer where email = ?;");
                                psDel.setString(1, zuLoeschendeEMail);
                                psDel.executeUpdate();
                                emailGefunden = true;
                                IO.println("\nDer Benutzer mit der E-Mail-Adresse: >>" + zuLoeschendeEMail + "<<, wurde erfolgreich gelöscht!\n");
                            }

//                            // Array-List-Bearbeitung
//                            for (int i = 0; i < list.size(); i++) {
//                                Benutzer zuLoeschendesObjekt = list.get(i);
//                                if (zuLoeschendesObjekt.getEmail().equals(zuLoeschendeEMail)) {
//                                    String geloeschtesObjekt = zuLoeschendesObjekt.getEmail();
//                                    list.remove(i);
//                                    IO.println("\nDer Benutzer mit der E-Mail-Adresse: >>" + geloeschtesObjekt + "<<, wurde erfolgreich gelöscht!\n");
//                                    emailGefunden = true;
//                                    break;
//                            }

                            if (emailGefunden == false) {
                                IO.println("\nDie E-Mail-Adresse konnte nicht gefunden werden!\n");
                            }
                            break;
// Case 4
                        case 4:
                            IO.println("\nBenutzer suchen:\n");

                            // E-Mail-Adressen-Abfragung
                            IO.print("Wie lautet die E-Mail-Adresse des Benutzers?: ");
                            String zuSuchendeEmail = scanner.nextLine();

                            // Listen-Eintrag-Vergleichs-Schleife
                            Boolean zuSuchendeEmailVorhanden = false;
                            // Benutzer gefundenesObjekt = null; // Array-List-Objekt

                            Statement stmtSeek = conn.createStatement();
                            ResultSet rsSeek = stmtSeek.executeQuery("SELECT * FROM benutzer;");
                            while (rsSeek.next()) {
                                String zuVergleichendeEmail = rsSeek.getString("email");
                                if (zuSuchendeEmail.equals(zuVergleichendeEmail)) {
                                    userOutput(rsSeek);
                                    zuSuchendeEmailVorhanden = true;
                                }
                            }

//                            // Array-List-Suche
//                            for (int i = 0; i < list.size(); i++) {
//                                Benutzer zuSuchendesObjekt = list.get(i);
//                                if (zuSuchendesObjekt.getEmail().equals(zuSuchendeEmail)) {
//                                    zuSuchendeEmailVorhanden = true;
//                                    gefundenesObjekt = zuSuchendesObjekt;
//                                }
//                            }

                            // Falls NICHT vorhanden
                            if (zuSuchendeEmailVorhanden == false) {
                                IO.println("\nDie E-Mail-Adresse konnte nicht gefunden werden!\n");
                                break;
                            }

//                            // Array-List-Ausgabe
//                            // Falls vorhanden
//                            if (zuSuchendeEmailVorhanden == true) {
//                                IO.println("\nFolgende Infos sind über den Benutzer vorhanden:\n");
//                                gefundenesObjekt.info();

                            break;
// Case 5
                        case 5:
                            IO.println("\nBenutzer bearbeiten:\n");

                            // E-Mail-Adressen-Abfragung
                            IO.print("Wie lautet die E-Mail-Adresse des Benutzers?: ");
                            String zuVerarbeitendeEmail = scanner.nextLine();

                            // Listen-Eintrag-Vergleichs-Schleife
                            Boolean zuVerarbeitendeEmailVorhanden = false;
                            String zuVergleichendeEmail;

                            Statement stmtEmailAenderung = conn.createStatement();
                            ResultSet rsEmailAenderung = stmtEmailAenderung.executeQuery("SELECT * FROM benutzer;");
                            while (rsEmailAenderung.next()) {
                                zuVergleichendeEmail = rsEmailAenderung.getString("email");
                                if (zuVerarbeitendeEmail.equals(zuVergleichendeEmail)) {
                                    zuVerarbeitendeEmailVorhanden = true;
                                }

//                            // Array-List-Email-Vergleich
//                            int verarbeitungsEmailListenIndex = -1;
//                            Benutzer verarbeitungsObjekt = null;
//
//                            for (int i = 0; i < list.size(); i++) {
//                                Benutzer zuSuchendesObjekt = list.get(i);
//                                if (zuSuchendesObjekt.getEmail().equals(zuVerarbeitendeEmail)) {
//                                    verarbeitungsEmailListenIndex = i;
//                                    zuVerarbeitendeEmailVorhanden = true;
//                                    verarbeitungsObjekt = zuSuchendesObjekt;
//                                }
                            }

                            if (zuVerarbeitendeEmailVorhanden == false) {
                                IO.println("\nDie E-Mail-Adresse konnte nicht gefunden werden!\n");
                                break;
                            }

                            if (zuVerarbeitendeEmailVorhanden == true) {
                                IO.println();
                                while (true) {
                                    IO.print("Benutzer Bearbeiten:"
                                            + "\n=============== Optionen ==============="
                                            + "\n1) Name ändern"
                                            + "\n2) E-Mail ändern"
                                            + "\n3) Passwort ändern"
                                            + "\n0) Abbrechen"
                                            + "\n----------------------------------------"
                                            + "\nAuswahl: ");
                                    String zuVerarbeitendeEmailVorhandenInputAuswahl = scanner.nextLine();
                                    int convertZuVerarbeitendeEmailVorhandenInputAuswahl;
                                    try {
                                        convertZuVerarbeitendeEmailVorhandenInputAuswahl = Integer.parseInt(zuVerarbeitendeEmailVorhandenInputAuswahl);
                                    } catch (NumberFormatException e) {
                                        IO.println("\nBitte eine gültige Zahl eingeben!\n");
                                        continue;
                                    }
                                    int parsedZuVerarbeitendeEmailVorhandenInputAuswahl = convertZuVerarbeitendeEmailVorhandenInputAuswahl;
                                    if (parsedZuVerarbeitendeEmailVorhandenInputAuswahl == 0) {
                                        break;
                                    } else if (parsedZuVerarbeitendeEmailVorhandenInputAuswahl == 1) {
                                        while (true) {
                                            IO.print("\nWie lautet der neue Name?: ");
                                            String neuerName = scanner.nextLine();
                                            if (neuerName.isBlank()) {
                                                continue;
                                            } else {
                                                // Alter-Name-Anzeigen
                                                PreparedStatement psAlterName = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                                psAlterName.setString(1, zuVerarbeitendeEmail);
                                                ResultSet rsAlterName = psAlterName.executeQuery();
                                                if (rsAlterName.next()) {
                                                    IO.println("\nAlter Name:");
                                                    userOutput(rsAlterName);
                                                }

                                                // Änderung-Name
                                                PreparedStatement psNameAendern = conn.prepareStatement("UPDATE benutzer SET name = ? WHERE email = ?;");
                                                psNameAendern.setString(1, neuerName);
                                                psNameAendern.setString(2, zuVerarbeitendeEmail);
                                                psNameAendern.executeUpdate();

                                                // Neuer-Name-Anzeigen
                                                PreparedStatement psNeuerName = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                                psNeuerName.setString(1, zuVerarbeitendeEmail);
                                                ResultSet rsNeuerName = psNeuerName.executeQuery();
                                                if (rsNeuerName.next()) {
                                                    IO.println("Neuer Name:");
                                                    userOutput(rsNeuerName);
                                                }
                                                break;
                                            }
//                                                // Array-List-Änderung
//                                                String alterName = verarbeitungsObjekt.getBenutzername(); // Speicherung des alten Namens zu sichtbaren Vergleich
//                                                verarbeitungsObjekt.setBenutzername(neuerName); // Speicherung des neuen Namens
//                                                IO.println("\nDer alte Benutzername: "
//                                                        + alterName
//                                                        + ", wurde erfolgreich auf: "
//                                                        + neuerName
//                                                        + " geändert!\n");
//                                                verarbeitungsObjekt.info();

                                        }

                                    } else if (parsedZuVerarbeitendeEmailVorhandenInputAuswahl == 2) {
                                        while (true) {
                                            IO.print("\nWie lautet die neue Email?: ");
                                            String neueEmail = scanner.nextLine();
                                            if (neueEmail.isBlank()) {
                                                continue;
                                            } else {
                                                // Alte-Email-Anzeigen
                                                PreparedStatement psAlteEmail = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                                psAlteEmail.setString(1, zuVerarbeitendeEmail);
                                                ResultSet rsAlteEmail = psAlteEmail.executeQuery();
                                                if (rsAlteEmail.next()) {
                                                    IO.println("Alte Email:");
                                                    userOutput(rsAlteEmail);
                                                }

                                                // Änderung-Email
                                                PreparedStatement psEmailAendern = conn.prepareStatement("UPDATE benutzer SET email = ? WHERE email = ?;");
                                                psEmailAendern.setString(1, neueEmail);
                                                psEmailAendern.setString(2, zuVerarbeitendeEmail);
                                                psEmailAendern.executeUpdate();

                                                // Neue-Email-Anzeigen
                                                PreparedStatement psNeueEmail = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                                psNeueEmail.setString(1, neueEmail);
                                                ResultSet rsNeueEmail = psNeueEmail.executeQuery();
                                                if (rsNeueEmail.next()) {
                                                    IO.println("\nNeue Email:");
                                                    userOutput(rsNeueEmail);
                                                }
                                                break;
                                            }

//                                        // Array-List-Änderung
//                                        while (true) {
//                                            IO.print("\nWie lautet die neue E-Mail-Adresse?: ");
//                                            String neueEmail = scanner.nextLine();
//                                            if (neueEmail.isBlank()) {
//                                                continue;
//                                            } else {
//                                                String alteEmail = verarbeitungsObjekt.getEmail();
//                                                verarbeitungsObjekt.setEmail(neueEmail);
//                                                IO.println("\nDie alte E-Mail-Adresse: "
//                                                        + alteEmail
//                                                        + ", wurde erfolgreich auf: "
//                                                        + neueEmail
//                                                        + " geändert!\n");
//                                                verarbeitungsObjekt.info();
//                                                break;
//                                            }
                                        }
                                    } else if (parsedZuVerarbeitendeEmailVorhandenInputAuswahl == 3) {
                                         while (true) {
                                            IO.print("\nWie lautet das neue Passwort?: ");
                                            String neuesPasswort = scanner.nextLine();
                                            if (neuesPasswort.isBlank()) {
                                                continue;
                                            } else {
                                                // Altes-Passwort-Anzeigen
                                                PreparedStatement psAltesPasswort = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                                psAltesPasswort.setString(1, zuVerarbeitendeEmail);
                                                ResultSet rsAltesPasswort = psAltesPasswort.executeQuery();
                                                if (rsAltesPasswort.next()) {
                                                    IO.println("\nAltes Passwort: ********");
                                                    userOutput(rsAltesPasswort);
                                                }

                                                // Änderung-Passwort
                                                PreparedStatement psPasswortAendern = conn.prepareStatement("UPDATE benutzer SET passwort = ? WHERE email = ?;");
                                                psPasswortAendern.setString(1, neuesPasswort);
                                                psPasswortAendern.setString(2, zuVerarbeitendeEmail);
                                                psPasswortAendern.executeUpdate();

                                                // Neues-Passwort-Anzeigen
                                                PreparedStatement psNeuesPasswort = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                                psNeuesPasswort.setString(1, zuVerarbeitendeEmail);
                                                ResultSet rsNeuesPasswort = psNeuesPasswort.executeQuery();
                                                if (rsNeuesPasswort.next()) {
                                                    IO.println("\nNeues Passwort: ********");
                                                    userOutput(rsNeuesPasswort);
                                                }
                                                break;
                                            }
//
//                                                // Array-List-Änderung
//                                                String altesPasswort = verarbeitungsObjekt.getPasswort();
//                                                verarbeitungsObjekt.setPasswort(neuesPasswort);
//                                                IO.println("\nDas alte Passwort: "
//                                                        + altesPasswort
//                                                        + ", wurde erfolgreich auf: "
//                                                        + neuesPasswort
//                                                        + " geändert!\n");
//                                                verarbeitungsObjekt.info();
//                                                break;
//                                            }
                                        }
                                    } else {
                                        IO.println("\nBitte eine gültige Zahl verwenden!\n");
                                    }
                                }
                            }
                            break;
// Case 6
                        case 6:
                            while (true) {
                                IO.print("\n========== Spezialfunktionen =========="
                                        + "\n1) Nur Admins anzeigen"
                                        + "\n2) Nur Gäste anzeigen"
                                        + "\n3) Mehrere Benutzer löschen"
                                        + "\n4) Gast: Namen ändern"
                                        + "\n0) Zurück"
                                        + "\n---------------------------------------"
                                        + "\nAuswahl: ");

                                String inputSpezialfunktion = scanner.nextLine();
                                int convertInputSpezialfunktion;

                                // Eingabe-Fehler-Fangen
                                try {
                                    convertInputSpezialfunktion = Integer.parseInt(inputSpezialfunktion);
                                } catch (NumberFormatException e) {
                                    IO.println("Bitte eine gültige Zahl eingeben!");
                                    continue;
                                }
                                if (convertInputSpezialfunktion == 0) {
                                    break;

                                // Admins anzeigen
                                } else if (convertInputSpezialfunktion == 1) {
                                    IO.println("\nAdmins:\n");
                                    PreparedStatement psAdminAnzeigen = conn.prepareStatement("SELECT * FROM benutzer WHERE typ = ?;");
                                    psAdminAnzeigen.setString(1, "admin");
                                    ResultSet rsAdminAnzeigen = psAdminAnzeigen.executeQuery();
                                    while (rsAdminAnzeigen.next()) {
                                        userOutput(rsAdminAnzeigen);
                                    }

//                                    // Array-List-Syntax
//                                    for (int i = 0; i < list.size(); i++) {
//                                        if (list.get(i) instanceof Admin) {
//                                            Admin adminObjekt = (Admin) list.get(i); // Benutzer zu Admin casten
//                                            adminObjekt.info();
//                                            IO.println();
//                                        }
//                                    }

                                // Gäste anzeigen
                                } else if (convertInputSpezialfunktion == 2) {
                                    IO.println("\nGäste:\n");
                                    PreparedStatement psGaesteAnzeigen = conn.prepareStatement("SELECT * FROM benutzer WHERE typ = ?;");
                                    psGaesteAnzeigen.setString(1, "gast");
                                    ResultSet rsGaesteAnzeigen = psGaesteAnzeigen.executeQuery();
                                    while (rsGaesteAnzeigen.next()) {
                                        userOutput(rsGaesteAnzeigen);
                                    }

//                                    // Array-List-Syntax
//                                    for (int i = 0; i < list.size(); i++) {
//                                        if (list.get(i) instanceof Gast) {
//                                            Gast gastObjekt = (Gast) list.get(i); // Benutzer zu Gast casten
//                                            gastObjekt.info();
//                                            IO.println();
//                                        }
//                                    }

                                // Mehrere Benutzer gleichzeitig löschen
                                } else if (convertInputSpezialfunktion == 3) {
                                    IO.println("\nMehrere Benutzer löschen:\n"
                                            + "\nZu löschende Emails (getrennt durch Leerzeile):\n");
                                    String zuLoeschendeEmails = scanner.nextLine();
                                    String regex = "[ \\,\\s]";
                                    String[] emailListe = zuLoeschendeEmails.split(regex);
                                    IO.println("\nGefundene Email(s):");
                                    for (String email : emailListe) {
                                        PreparedStatement psPruefen = conn.prepareStatement("SELECT * FROM benutzer WHERE email = ?;");
                                        psPruefen.setString(1, email);
                                        ResultSet rsPruefen = psPruefen.executeQuery();
                                        if (rsPruefen.next()) {
                                            PreparedStatement psDel = conn.prepareStatement("DELETE FROM benutzer WHERE email = ?;");
                                            psDel.setString(1, email);
                                            psDel.executeUpdate();
                                            IO.println("User mit Email: "
                                                    + email
                                                    + ", wurde erfolgreich gelöscht!");
                                        } else {
                                            IO.println("User mit Email: "
                                                    + email
                                                    + ", wurde NICHT gefunden!");
                                        }

                                    }

//                                    // Array-List-Syntax
//                                    ArrayList<Integer> loeschIndex = new ArrayList();
//                                    for (String email : emailListe) {
//                                        IO.println("Gesuchte Email: " + email);
//                                        Boolean emailVorhanden = false;
//                                        for (int i = 0; i < list.size(); i++) {
//                                            Benutzer zuVergleichendesEmail = list.get(i);
//                                            if (email.equals(zuVergleichendesEmail.getEmail())) {
//                                                loeschIndex.add(i);
//                                                emailVorhanden = true;
//                                            }
//                                        }
//                                        if (emailVorhanden == false) {
//                                            IO.println("Die Email wurde nicht gefunden!\n");
//                                        }
//                                    }
//                                    if (loeschIndex.isEmpty()) {
//                                        IO.println("Es wurden keine Benutzer gelöscht!");
//                                    } else {
//                                        IO.println(loeschIndex);
//                                        Collections.sort(loeschIndex, (a, b) -> b - a);
//                                        for (int index : loeschIndex) {
//                                            list.remove(index);
//                                        }
//                                    }

                                // Gast-Namen-Ändern
                                } else if (convertInputSpezialfunktion == 4) {
                                    IO.print("\nACHTUNG!!! IGNORIERT REDUNDANZ!! (überschreibt alle identische Einträge)"
                                            + "\nWelcher Name soll geändert werden? (Name, nicht Email angeben!): ");
                                    String alterName = scanner.nextLine();

                                    PreparedStatement psAlterName = conn.prepareStatement("SELECT * FROM benutzer WHERE name = ?;");
                                    psAlterName.setString(1, alterName);
                                    ResultSet rsAlterName = psAlterName.executeQuery();
                                    if (rsAlterName.next()) {
                                        IO.print("\nWie soll der neue Name lauten?: ");
                                        String neuerName = scanner.nextLine();
                                        IO.println("\nDer alte Name: ");
                                        userOutput(rsAlterName);

                                        PreparedStatement psNameAendern = conn.prepareStatement("UPDATE benutzer SET name = ? WHERE name = ?;");
                                        psNameAendern.setString(1, neuerName);
                                        psNameAendern.setString(2, alterName);
                                        psNameAendern.executeUpdate();

                                        PreparedStatement psNeuerName = conn.prepareStatement("SELECT * FROM benutzer WHERE name = ?;");
                                        psNeuerName.setString(1, neuerName);
                                        ResultSet rsNeuerName = psNeuerName.executeQuery();
                                        if (rsNeuerName.next()) {
                                            IO.println("Der neue Name: ");
                                            userOutput(rsNeuerName);
                                        }
                                    } else {
                                        IO.println("Der Name wurde nicht gefunden!");
                                    }

                                    // Array-List-Syntax (überkompliziert weil ich do while üben wollte)
//                                    Boolean zuEintragen = true;
//                                    while (zuEintragen) {
//                                        String zuAendernerName;
//                                        String neuerName;
//                                        Gast zuAendernerGast = null;
//                                        int gastIndex = -1;
//                                        Boolean zuAendernerNameGefunden = false;
//                                        Boolean classCastException = false;
//                                        Boolean abbrechen = false;
//                                        do {
//                                            zuAendernerNameGefunden = false; // zurücksetzen
//                                            classCastException = false; // zurücksetzen
//                                            IO.print("\n\nGast: Namen ändern\n"
//                                                    + "\nWie lautet der Name des Gastes?: ");
//                                            zuAendernerName = scanner.nextLine();
//                                            for (int i = 0; i < list.size(); i++) {
//                                                if (zuAendernerName.equals(list.get(i).getBenutzername())) {
//                                                    try {
//                                                        zuAendernerGast = (Gast) list.get(i);
//                                                        gastIndex = i;
//                                                        zuAendernerNameGefunden = true;
//                                                        break;
//                                                    } catch (ClassCastException e) {
//                                                        classCastException = true;
//                                                        IO.println("Der gefundene Benutzer ist kein Gast!");
//                                                        abbrechen = true;
//                                                    }
//                                                }
//                                            }
//                                            if (zuAendernerNameGefunden == false && classCastException == false) {
//                                                IO.println("Der gegebene Gast wurde nicht gefunden!");
//                                                abbrechen = true;
//                                            }
//                                        } while ((zuAendernerName.isBlank() || zuAendernerNameGefunden == false) && !abbrechen);
//                                        if (abbrechen) {
//                                            break; // zurück zu case 6
//                                        }
//                                        do { // Neuer-Name-Angeben
//                                            IO.print("Wie lautet der neue Name?: ");
//                                            neuerName = scanner.nextLine();
//                                            if (neuerName.isBlank()) {
//                                                IO.println("Der Name darf nicht leer sein!");
//                                            } else {
//                                                zuAendernerGast.setBenutzername(neuerName);
//                                            }
//                                        } while (neuerName.isBlank());
//                                        IO.println("\nDer alte Gastname: " + zuAendernerName
//                                                + "\nDer neue Gastname: " + neuerName
//                                                +"\n");
//                                        list.get(gastIndex).info();
//                                        IO.println();
//                                        zuEintragen = false;
//                                    }
                                }
                            }
                            break;
                        default:
                        IO.println("\nBitte nur Zahlen zwischen 0 und 6 verwenden!\n");
                    }
                } catch (NumberFormatException e) {
                    IO.println("\nBitte verwende eine gültige Zahl zwischen 0 und 6!\n");
                }
            }
        } catch (SQLException e) {
            IO.println("Datenbankfehler: " + e.getMessage());
        }
    }
    // SQL-Datenbank-Verbindung
    // Hinweis: In Produktion würden Zugangsdaten aus Umgebungsvariablen geladen
    static Connection verbindung() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/benutzerverwaltung_db",
            "root",
            ""
        );
    }
}
