Benutzer Vererbung (auf Basis deiner `Benutzer`‑Klasse)
----------------------------------------------------------------

### Aufgabe 1: Basisklasse `Benutzer` (bereits vorhanden)

Verwende deine vorhandene Klasse `Benutzer` unverändert:

-   Attribute: `private String benutzername`, `private String email`, `private String passwort`, `private boolean aktiv`
-   Konstruktoren:
    -   `Benutzer(String benutzername, String email, String passwort)` setzt `aktiv = true`
    -   `Benutzer(String benutzername, String email, String passwort, boolean aktiv)`
-   Getter/Setter (für `email`, `passwort`) und `info()` mit Ausgabe inkl. Aktiv-Status

Hinweis: Da die Attribute `private` sind, greifen Unterklassen über Getter (`getBenutzername()`, `getEmail()`, `isAktiv()`) zu -- nicht direkt auf Felder.

* * * * *

### Aufgabe 2: Unterklasse `Admin`

-   Erbt von `Benutzer`
-   Zusätzliches Attribut: `private boolean superAdmin`
-   Konstruktoren:
    -   `Admin(String benutzername, String email, String passwort, boolean superAdmin)` → ruft `super(benutzername, email, passwort)`
    -   Optional: `Admin(String benutzername, String email, String passwort, boolean aktiv, boolean superAdmin)` → ruft `super(benutzername, email, passwort, aktiv)`
-   Überschreibe `info()`:
    -   Beispielausgabe: `Admin: max123 (max@test.de), SuperAdmin: true`
    -   Aktiv-Status zusätzlich ausgeben (z. B. in separater Zeile)

* * * * *

### Aufgabe 3: Unterklasse `Gast`

-   Erbt von `Benutzer`
-   Zusätzliches Attribut: `private int gueltigBisTag`
-   Konstruktoren:
    -   `Gast(String benutzername, String email, String passwort, int gueltigBisTag)` → ruft `super(benutzername, email, passwort)`
    -   Optional: `Gast(String benutzername, String email, String passwort, boolean aktiv, int gueltigBisTag)` → ruft `super(benutzername, email, passwort, aktiv)`
-   Überschreibe `info()`:
    -   Beispielausgabe: `Gast: anna_guest, gültig bis Tag 20`
    -   Aktiv-Status zusätzlich ausgeben

* * * * *

### Aufgabe 4: Testklasse `VererbungAufgaben`

-   Erzeuge je ein `Admin`- und ein `Gast`-Objekt
-   Rufe jeweils `info()` auf