package practice;

import java.sql.*;
import java.util.*;

public class LibrarySystem {

    // Database Config
    static final String URL = "jdbc:mysql://localhost:3306/lib_mangement";
    static final String USER = "root";
    static final String PASS = ""; // your MySQL password

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\n===== LIBRARY SYSTEM (MySQL Version) =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register User");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1: addBook(); break;
                    case 2: viewBooks(); break;
                    case 3: registerUser(); break;
                    case 4: viewUsers(); break;
                    case 5: issueBook(); break;
                    case 6: returnBook(); break;
                    case 0: System.out.println("Exiting..."); return;
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // -------------------- Add Book --------------------
    static void addBook() throws Exception {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, title);
        ps.setString(2, author);

        ps.executeUpdate();
        con.close();

        System.out.println("Book added successfully!");
    }

    // -------------------- View Books --------------------
    static void viewBooks() throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "SELECT * FROM books";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- Book List ---");
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("title") + " | " +
                rs.getString("author") + " | " +
                (rs.getInt("is_issued") == 1 ? "Issued" : "Available")
            );
        }

        con.close();
    }

    // -------------------- Register User --------------------
    static void registerUser() throws Exception {
        System.out.print("Enter user name: ");
        String name = sc.nextLine();

        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "INSERT INTO users (name) VALUES (?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        ps.executeUpdate();
        con.close();

        System.out.println("User registered successfully!");
    }

    // -------------------- View Users --------------------
    static void viewUsers() throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "SELECT * FROM users";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- User List ---");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("name"));
        }

        con.close();
    }

    // -------------------- Issue Book --------------------
    static void issueBook() throws Exception {
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        // Check if book is already issued
        String check = "SELECT is_issued FROM books WHERE id=?";
        PreparedStatement ps1 = con.prepareStatement(check);
        ps1.setInt(1, bookId);
        ResultSet rs = ps1.executeQuery();

        if (!rs.next()) {
            System.out.println("Book not found!");
            con.close();
            return;
        }

        if (rs.getInt("is_issued") == 1) {
            System.out.println("Book is already issued!");
            con.close();
            return;
        }

        // Mark book as issued
        String updateBook = "UPDATE books SET is_issued=1 WHERE id=?";
        PreparedStatement ps2 = con.prepareStatement(updateBook);
        ps2.setInt(1, bookId);
        ps2.executeUpdate();

        // Insert issue record
        String issue = "INSERT INTO issued_books (user_id, book_id, issue_date) VALUES (?, ?, CURDATE())";
        PreparedStatement ps3 = con.prepareStatement(issue);
        ps3.setInt(1, userId);
        ps3.setInt(2, bookId);
        ps3.executeUpdate();

        con.close();

        System.out.println("Book issued successfully!");
    }

    // -------------------- Return Book --------------------
    static void returnBook() throws Exception {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        // Check if issued
        String check = "SELECT is_issued FROM books WHERE id=?";
        PreparedStatement ps1 = con.prepareStatement(check);
        ps1.setInt(1, bookId);
        ResultSet rs = ps1.executeQuery();

        if (!rs.next()) {
            System.out.println("Book not found!");
            con.close();
            return;
        }

        if (rs.getInt("is_issued") == 0) {
            System.out.println("Book is not issued!");
            con.close();
            return;
        }

        // Mark book as returned
        String updateBook = "UPDATE books SET is_issued=0 WHERE id=?";
        PreparedStatement ps2 = con.prepareStatement(updateBook);
        ps2.setInt(1, bookId);
        ps2.executeUpdate();

        // Update return date
        String updateIssue = "UPDATE issued_books SET return_date=CURDATE() WHERE book_id=? AND return_date IS NULL";
        PreparedStatement ps3 = con.prepareStatement(updateIssue);
        ps3.setInt(1, bookId);
        ps3.executeUpdate();

        con.close();

        System.out.println("Book returned successfully!");
    }
}
