package lld.design_library_management_system;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=es4uliuvrTI
public class Library {
    String name;
    Address address;
    List<BookItem> books;

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }

    public void addBook(BookItem book) {
        books.add(book);
    }

    public void showBooks() {
        for (BookItem bookItem : books) {
            System.out.println("Book: " + bookItem.getBook().getTitle() + ", Author: " + bookItem.getBook().getAuthor());
        }
    }
}
