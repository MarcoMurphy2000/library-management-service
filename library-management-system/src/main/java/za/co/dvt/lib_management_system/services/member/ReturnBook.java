package za.co.dvt.lib_management_system.services.member;

import za.co.dvt.lib_management_system.entity.book.Book;
import za.co.dvt.lib_management_system.entity.member.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReturnBook {
    private static final String ASSIGNMENTS_FILE = "book_assignments.txt";
    private static final String BOOKS_FILE = "books.txt";

    public static void returnBook(String memberId, String bookId) {
        // Find the book assignment with the given member ID and book ID
        String assignmentToRemove = findAssignment(memberId, bookId);

        if (assignmentToRemove != null) {
            // Remove the assignment from the assignments file
            removeAssignment(assignmentToRemove);

            // Update the book availability status to true
            updateBookAvailability(Integer.parseInt(bookId), true);

            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book assignment not found for the member.");
        }
    }

    private static String findAssignment(String memberId, String bookId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ASSIGNMENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String member = parts[2];
                String book = parts[6];
                if (member.equals(memberId) && book.equals(bookId)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void removeAssignment(String assignmentToRemove) {
        List<String> assignments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ASSIGNMENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(assignmentToRemove)) {
                    assignments.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rewrite the assignments file without the removed assignment
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ASSIGNMENTS_FILE))) {
            for (String assignment : assignments) {
                writer.write(assignment);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateBookAvailability(int bookId, boolean available) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String category = parts[2];
                int id = Integer.parseInt(parts[3]);
                Book book = new Book(title, author, category, id);
                book.setAvailable(available);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rewrite the books file with updated availability status
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
