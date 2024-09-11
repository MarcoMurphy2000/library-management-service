package za.co.dvt.lib_management_system.services.member;

import za.co.dvt.lib_management_system.entity.book.Book;
import za.co.dvt.lib_management_system.entity.member.Member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutBook {
    private static final String BOOKS_FILE = "books.txt";
    private static final String ASSIGNMENTS_FILE = "book_assignments.txt";
    private static final String MEMBERS_FILE = "members.txt";

    public static void checkoutBook(String memberId, String bookId) {
        // Read available books from books.txt
        List<Book> availableBooks = readBooksFromFile(BOOKS_FILE);

        // Find the book with the given ID
        Book bookToCheckout = findBookById(availableBooks, Integer.parseInt(bookId));

        // Find the member with the given ID
        Member member = findMemberById(Integer.parseInt(memberId));

        if (bookToCheckout != null && bookToCheckout.isAvailable() && member != null) {
            // Update book status to not available
            bookToCheckout.setAvailable(false);

            // Update assignments file
            updateAssignmentsFile(member, bookToCheckout);

            // Update books file
            updateBooksFile(availableBooks);

            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Book is not available for checkout or member does not exist.");
        }
    }

    private static List<Book> readBooksFromFile(String filename) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String category = parts[2];
                int id = Integer.parseInt(parts[3]);
                boolean available = Boolean.parseBoolean(parts[4]);
                Book book = new Book(title, author, category, id);
                book.setAvailable(available);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static Book findBookById(List<Book> books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    private static Member findMemberById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int memberId = Integer.parseInt(parts[2]);
                if (memberId == id) {
                    String name = parts[0];
                    String surname = parts[1];
                    return new Member(name, surname, id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void updateAssignmentsFile(Member member, Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ASSIGNMENTS_FILE, true))) {
            writer.write(member.toString() + "," + book.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateBooksFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}