package za.co.dvt.lib_management_system.ui;

import za.co.dvt.lib_management_system.facade.LibrarianFacade;
import za.co.dvt.lib_management_system.facade.MemberFacade;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private MemberFacade memberFacade;
    private LibrarianFacade librarianFacade;

    public Menu() {
        scanner = new Scanner(System.in);
        memberFacade = new MemberFacade();
        librarianFacade = new LibrarianFacade();
    }

    public void displayMenu() {
        System.out.println("===== Welcome to Library Management System =====");
        System.out.println("Please choose your role:");
        System.out.println("1. Member");
        System.out.println("2. Librarian");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                memberMenu();
                break;
            case 2:
                librarianMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private void memberMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Member Menu =====");
            System.out.println("1. Add Book to Wishlist");
            System.out.println("2. Checkout a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    memberFacade.addBookToWishlist(memberId, bookId);
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    memberFacade.checkoutBook(memberId, bookId);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    memberFacade.returnBook(memberId, bookId);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void librarianMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Librarian Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. List Books");
            System.out.println("4. List Members");
            System.out.println("5. Remove Book");
            System.out.println("6. Remove Member");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    librarianFacade.addBook(title, author, category, bookId);
                    break;
                case 2:
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    librarianFacade.addMember(name, memberId);
                    break;
                case 3:
                    librarianFacade.listBooks();
                    break;
                case 4:
                    librarianFacade.listMembers();
                    break;
                case 5:
                    System.out.print("Enter ID of the Book to Remove: ");
                    bookId = scanner.nextLine();
                    librarianFacade.removeBook(bookId);
                    break;
                case 6:
                    System.out.print("Enter ID of Member to Remove: ");
                    memberId = scanner.nextLine();
                    librarianFacade.removeMember(memberId);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Menu menuSystem = new Menu();
        menuSystem.displayMenu();
    }
}


