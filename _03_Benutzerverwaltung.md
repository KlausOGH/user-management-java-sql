Aufgabenstellung: Benutzerverwaltung mit Menü
=============================================

*(Schritt für Schritt aufgebaut)*

Diese Aufgabe verwendet deine vorhandenen Klassen:

-   `Benutzer`
-   `Admin extends Benutzer`
-   `Gast extends Benutzer`

Du sollst jetzt ein Textmenü programmieren, mit dem man Benutzer verwalten kann.

* * * * *

Schritt 1: ArrayList vorbereiten
================================

1.  Lege in `main()` eine `ArrayList<Benutzer>` an.
2.  Füge ein paar Testobjekte hinzu (z. B. zwei Benutzer, ein Admin, ein Gast).
3.  Gib testweise aus, dass die Liste erfolgreich angelegt wurde.

**Ziel:** Du hast eine funktionierende Liste mit Objekten.

* * * * *

Schritt 2: Eine Endlosschleife für das Menü erstellen
=====================================================

1.  Erstelle eine `while(true)`-Schleife.
2.  In dieser Schleife soll das Menü angezeigt werden.
3.  Nach der Anzeige soll eine Eingabe per `Scanner` eingelesen werden.
4.  Ein `switch` entscheidet, welche Funktion ausgeführt wird.
5.  Bei Eingabe `0` soll die Schleife verlassen werden (`break`).

**Ziel:** Das Menü wird immer wieder angezeigt, bis der Benutzer das Programm beendet.

* * * * *

Schritt 3: Menü anzeigen
========================

Baue in der Schleife folgenden Text ein:

```
=============== Benutzerverwaltung ===============
1) Benutzerliste anzeigen
2) Benutzer hinzufügen
3) Benutzer löschen
4) Benutzer suchen
5) Benutzer bearbeiten
6) Spezialfunktionen
0) Programm beenden
-------------------------------------------------
Auswahl:

```

Mehr passiert hier noch nicht.

**Ziel:** Du hast ein zentrales Menü, das immer wieder erscheint.

* * * * *

Schritt 4: Funktion "Benutzerliste anzeigen"
============================================

1.  Erstelle eine Methode oder schreibe es zunächst direkt in den `case 1`.
2.  Iteriere durch die Liste.
3.  Rufe für jedes Objekt `info()` auf.

**Ziel:** Die Liste wird korrekt ausgegeben.

* * * * *

Schritt 5: Benutzer hinzufügen
==============================

Diese Aufgabe wird in Teilschritte zerlegt:

1.  Frage zuerst im Menü:\
    „Welchen Typ möchtest du hinzufügen?"\
    Auswahl: Benutzer / Admin / Gast
2.  Frage nacheinander benötigte Eingaben ab\
    (Name, Email, Passwort ... je nach Typ).
3.  Erstelle das passende Objekt.
4.  Füge es der ArrayList hinzu.
5.  Gib eine Bestätigung aus.

**Ziel:** Du kannst neue Objekte zur Liste hinzufügen.

* * * * *

Schritt 6: Benutzer löschen
===========================

1.  Frage die E-Mail des zu löschenden Benutzers ab.
2.  Durchsuche die Liste nach einem Objekt mit dieser E-Mail.
3.  Entferne das gefundene Objekt aus der Liste.
4.  Gib aus, ob der Benutzer gefunden und gelöscht wurde.

**Ziel:** Man kann Benutzer anhand ihrer E-Mail löschen.

* * * * *

Schritt 7: Benutzer suchen
==========================

1.  Frage die E-Mail ab.
2.  Suche in der Liste.
3.  Wenn gefunden: `info()` ausgeben.
4.  Wenn nicht: Meldung ausgeben.

**Ziel:** Man kann einzelne Benutzer schnell finden.

* * * * *

Schritt 8: Benutzer bearbeiten
==============================

1.  Frage die E-Mail des Benutzers ab.
2.  Suche den Benutzer.
3.  Wenn gefunden, zeige ein Untermenü:

```
Benutzer bearbeiten:
1) Name ändern
2) E-Mail ändern
3) Passwort ändern
0) Abbrechen

```

1.  Je nach Auswahl:
    -   Name ändern → `setBenutzername()` oder bei Gast `aendereName()`
    -   E-Mail ändern → `setEmail()`
    -   Passwort ändern → `setPasswort()`
2.  Gib aus, dass die Änderung erfolgreich war.

**Ziel:** Daten eines Benutzers lassen sich verändern.

* * * * *

Schritt 9: Spezialfunktionen (Untermenü)
========================================

Wenn im Hauptmenü Punkt 6 gewählt wird:

```
===== Spezialfunktionen =====
1) Nur Admins anzeigen
2) Nur Gäste anzeigen
3) Mehrere Benutzer löschen
4) Gast: Namen ändern
0) Zurück

```

### 1) Nur Admins anzeigen

Iteriere durch die Liste und wähle alle Objekte mit `instanceof Admin`.

### 2) Nur Gäste anzeigen

Gleich wie Admins.

### 3) Mehrere Benutzer löschen

1.  Frage mehrere E-Mails ab (z. B. getrennt durch Leerzeichen oder Komma).
2.  Entferne jeden passenden Benutzer.
3.  Gib die Anzahl der gelöschten Benutzer aus.

### 4) Gast: Namen ändern

1.  Frage E-Mail eines Gastobjekts ab.
2.  Suche ihn.
3.  Ändere den Namen über `aendereName()`.

* * * * *

Schritt 10: Beenden des Programms
=================================

-   Wenn der Benutzer „0" eingibt, brich die Schleife ab.
-   Gib eine Abschiedsnachricht aus.
-   Beende das Programm.

**Ziel:** Das Programm kann sauber beendet werden.

* * * * *

Zusammenfassung (Checkliste)
============================

Arbeite die Schritte nacheinander ab:

1.  ArrayList anlegen
2.  Endlosschleife erstellen
3.  Menü anzeigen
4.  Benutzerliste anzeigen
5.  Benutzer hinzufügen
6.  Benutzer löschen
7.  Benutzer suchen
8.  Benutzer bearbeiten
9.  Spezialmenü
10. Programm beenden

Du kannst jeden Schritt einzeln testen, bevor du weitergehst.