package za.co.dvt.lib_management_system.services.member;

import za.co.dvt.lib_management_system.entity.book.Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddBookToWishlist {
    private static final String BOOKS_FILE = "books.txt";

    public static void addBookToWishlist(String memberId, String bookId) {
        List<Book> availableBooks = readBooksFromFile(BOOKS_FILE);

        Book bookToCheckout = findBookById(availableBooks, Integer.parseInt(bookId));

        String wishlistFileName = memberId + "_wishlist.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(wishlistFileName))) {
            writer.write(bookToCheckout.toString());
            writer.newLine();
            System.out.println("Book added to wishlist successfully!");
        } catch (IOException e) {
            System.out.println("Failed to add book to wishlist: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Book findBookById(List<Book> books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
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
}
