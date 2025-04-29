package lld.design_library_management_system;

import lld.design_library_management_system.enums.BookType;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public List<BookItem> getBookByTitle(String title) {
        return Database.searchByTitle(title);
    }

    public List<BookItem> getBookByAuthor(Author author) {
        return Database.searchByAuthor(author);
    }

    public List<BookItem> getBookByType(BookType bookType) {
        return Database.searchByType(bookType);
    }

    public List<BookItem> getBookBySubject(String subject) {
        return Database.searchBySubject(subject);
    }
}
