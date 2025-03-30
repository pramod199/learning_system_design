package lld.iterator_design_pattern;

public class Book {
    int price;
    String bookName;

    public Book(int price, String bookName) {
        this.price = price;
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public String getBookName() {
        return bookName;
    }
}
