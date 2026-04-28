# User Management System

A console-based user management application built with Java and MySQL.

## Features

- Add, delete, search and edit users
- Three user types: User, Admin, Guest
- OOP principles: inheritance and polymorphism
- MySQL database integration via JDBC
- Input validation and error handling

## Tech Stack

- Java
- MySQL
- JDBC

## Setup

1. Create a MySQL database named `benutzerverwaltung_db`
2. Create a table named `benutzer` with the following columns:
   - `id` INT AUTO_INCREMENT PRIMARY KEY
   - `typ` VARCHAR(50)
   - `name` VARCHAR(100)
   - `email` VARCHAR(100)
   - `passwort` VARCHAR(100)
   - `aktiv` BOOLEAN
   - `ist_super_admin` BOOLEAN
   - `gueltig_bis_tage` INT
3. Update the database credentials in `Main.java` if needed
4. Run `Main.java`
