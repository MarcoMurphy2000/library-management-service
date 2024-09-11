package za.co.dvt.lib_management_system.facade;

import za.co.dvt.lib_management_system.services.member.AddBookToWishlist;
import za.co.dvt.lib_management_system.services.member.CheckoutBook;
import za.co.dvt.lib_management_system.services.member.ReturnBook;

// MemberFacade.java
public class MemberFacade {
    private AddBookToWishlist addBookToWishlistService;
    private CheckoutBook checkoutBookService;
    private ReturnBook returnBookService;

    public MemberFacade() {
        addBookToWishlistService = new AddBookToWishlist();
        checkoutBookService = new CheckoutBook();
        returnBookService = new ReturnBook();
    }

    public void addBookToWishlist(String memberId, String bookId) {
        addBookToWishlistService.addBookToWishlist(memberId, bookId);
    }

    public void checkoutBook(String memberId, String bookId) {
        checkoutBookService.checkoutBook(memberId, bookId);
    }

    public void returnBook(String memberId, String bookId) {
        returnBookService.returnBook(memberId, bookId);
    }
}

