import za.co.dvt.lib_management_system.entity.member.Member;
import za.co.dvt.lib_management_system.entity.book.Book;
import za.co.dvt.lib_management_system.services.member.CheckoutBook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String BOOKS_FILE = "books.txt";
    private static final String MEMBERS_FILE = "members.txt";

    public static void main(String[] args) {
        // Initialize sample data
        initialize();
    }

    public static void initialize() {
        // Initialize sample books
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            writer.write("Introduction to Java,John Doe,Programming,101,true");
            writer.newLine();
            writer.write("The Great Gatsby,F. Scott Fitzgerald,Fiction,102,true");
            writer.newLine();
            writer.write("Data Structures and Algorithms,Jane Smith,Programming,103,true");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize sample members
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERS_FILE))) {
            writer.write("John,Doe,1001");
            writer.newLine();
            writer.write("Jane,Smith,1002");
            writer.newLine();
            writer.write("Bob,Johnson,1003");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
