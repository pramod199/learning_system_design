package lld.iterator_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Book book1 = new Book(100, "Book1");
        Book book2 = new Book(200, "Book2");
        Book book3 = new Book(300, "Book3");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        Library library = new Library(bookList);
        Iterator iterator = library.createIterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName() + " " + book.getPrice());
        }
    }
}
