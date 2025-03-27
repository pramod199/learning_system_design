package lld.design_library_management_system;

import lld.design_library_management_system.enums.BookType;

import java.util.List;

public class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> author; // can have many authors
    private BookType bookType;


}
