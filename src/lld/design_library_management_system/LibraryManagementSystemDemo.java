package lld.design_library_management_system;

import lld.design_library_management_system.enums.BookFormat;
import lld.design_library_management_system.enums.BookStatus;
import lld.design_library_management_system.enums.BookType;

import java.util.Date;
import java.util.List;

public class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("Librarian A", "lib@gmail.com", "1234567890");
        Member member = new Member("2", "Member A", "member@gmail.com", "9876543210");

        Book book = new Book("isbn_1", "Effective Java", List.of(new Author("Joshua Bloch")));
        BookItem bookItem1 = new BookItem(book, BookStatus.AVAILABLE, "unique_barcode_1", new Date(),  new Rack(1, "R1"), BookFormat.AUDIO_BOOK);
        librarian.addBookItem(bookItem1);

        // Member searches
        List<BookItem> books = member.searchObj.getBookByTitle("Effective Java");
        System.out.println("Books Found: " + books.size());

        // Member issues book
        member.issueService.issueBook(books.get(0), member);

        // Member returns book late
        try { Thread.sleep(2000); } catch (Exception e) {}
        member.issueService.returnBook(books.get(0), member);
    }
}
