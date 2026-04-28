Vorbereitungsaufgabe: Klasse *Benutzer*
=======================================

Ziel der Aufgabe
----------------

Diese Aufgabe dient als Vorbereitung auf ein späteres User‑Verwaltungssystem.


-   Klassen und Objekte
-   Attribute
-   Methoden
-   Kapselung (private, Getter/Setter)
-   Konstruktoren (überladen und verkettet)

* * * * *

Aufgabe: Erstelle eine Klasse `Benutzer`
========================================

Schritt 1: Attribute anlegen
----------------------------

Erstelle die Klasse `Benutzer` mit folgenden **privaten** Attributen:

-   `String benutzername`
-   `String email`
-   `String passwort`
-   `boolean aktiv`

Das Attribut `aktiv` soll speichern, ob ein Benutzerkonto aktiv ist.

* * * * *

Schritt 2: Konstruktoren erstellen
----------------------------------

Definiere zwei Konstruktoren:

### Hauptkonstruktor

Nimmt folgende Parameter entgegen:

-   `benutzername`
-   `email`
-   `passwort`

Setzt `aktiv` automatisch auf `true`.

### Überladener Konstruktor

Nimmt alle vier Attribute entgegen:

-   `benutzername`
-   `email`
-   `passwort`
-   `aktiv`


* * * * *

Schritt 3: Getter und Setter (Kapselung)
----------------------------------------

Erstelle:

-   Getter für alle Attribute
-   Setter für
    -   `email`
    -   `passwort`

Kein Setter für:

-   `benutzername` (soll nicht nachträglich geändert werden)
-   `aktiv` (soll nur intern gesetzt werden)

* * * * *

Schritt 4: Methode `info()`
---------------------------

Implementiere eine Methode:



public void info()



Sie soll die Benutzerdaten wie folgt ausgeben:

```
Benutzer: Tim (tim@test.de)
Aktiv: true

```

Das Passwort darf nicht ausgegeben werden.

* * * * *

Schritt 5: Test im `main`
-------------------------

In einer `main`‑Methode:

1.  Erstelle drei Benutzerobjekte über beide Konstruktoren
2.  Gib jedes Objekt mit `info()` aus
3.  Ändere bei einem Benutzer die Email und das Passwort über Setter
4.  Gib diesen Benutzer erneut aus