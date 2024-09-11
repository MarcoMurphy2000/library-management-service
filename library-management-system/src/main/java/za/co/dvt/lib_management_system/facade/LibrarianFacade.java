package za.co.dvt.lib_management_system.facade;

import za.co.dvt.lib_management_system.services.librarian.AddBook;
import za.co.dvt.lib_management_system.services.librarian.AddMember;
import za.co.dvt.lib_management_system.services.librarian.ListBooks;
import za.co.dvt.lib_management_system.services.librarian.ListMembers;
import za.co.dvt.lib_management_system.services.librarian.RemoveBook;
import za.co.dvt.lib_management_system.services.librarian.RemoveMember;

// LibrarianFacade.java
public class LibrarianFacade {
    private AddBook addBookService;
    private AddMember addMemberService;
    private ListBooks listBooksService;
    private ListMembers listMembersService;
    private RemoveBook removeBookService;
    private RemoveMember removeMemberService;

    public LibrarianFacade() {
        addBookService = new AddBook();
        addMemberService = new AddMember();
        listBooksService = new ListBooks();
        listMembersService = new ListMembers();
        removeBookService = new RemoveBook();
        removeMemberService = new RemoveMember();
    }

    public void addBook(String title, String author, String category, String bookId) {
        addBookService.addBook(title, author, category, bookId);
    }

    public void addMember(String name, String memberId) {
        addMemberService.addMember(name, memberId);
    }

    public void listBooks() {
        listBooksService.listBooks();
    }

    public void listMembers() {
        listMembersService.listMembers();
    }

    public void removeBook(String bookId) {
        removeBookService.removeBook(bookId);
    }

    public void removeMember(String memberId) {
        removeMemberService.removeMember(memberId);
    }
}

