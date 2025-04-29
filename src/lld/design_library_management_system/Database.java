package lld.design_library_management_system;

import lld.design_library_management_system.enums.BookType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {
    private static Map<String, BookItem> bookItems = new HashMap<>(); // barcode vs bookitem
    private static Map<String, BookReservationDetail> reservations = new HashMap<>(); // barcode vs reservation
    private static Map<String, BookIssueDetail> issues = new HashMap<>();

    public static void addBookItem(BookItem bookItem) {
        bookItems.put(bookItem.getBarcode(), bookItem);
    }

    public static BookItem removeBookItem(String barcode) {
        return bookItems.remove(barcode);
    }

    public static void updateBookItem(BookItem bookItem) {
        bookItems.put(bookItem.getBarcode(), bookItem);
    }

    public static BookReservationDetail getReservation(String barcode) {
        return reservations.get(barcode);
    }

    public static void saveReservation(BookReservationDetail detail) {
        reservations.put(detail.bookItem.getBarcode(), detail);
    }

    public static void saveIssue(BookIssueDetail detail) {
        issues.put(detail.bookItem.getBarcode(), detail);
    }

    public static BookIssueDetail getIssue(String barcode) {
        return issues.get(barcode);
    }

    public static void removeIssue(String barcode) {
        issues.remove(barcode);
    }

    public static List<BookItem> searchByTitle(String title) {
        List<BookItem> result = new ArrayList<>();
        for (BookItem bookItem : bookItems.values()) {
            if (bookItem.getBook().getTitle().equalsIgnoreCase(title)) {
                result.add(bookItem);
            }
        }
        return result;
    }

    public static List<BookItem> searchByAuthor(Author author) {
        List<BookItem> result = new ArrayList<>();
        for (BookItem bookItem : bookItems.values()) {
            if (bookItem.getBook().getAuthor().equals(author)) {
                result.add(bookItem);
            }
        }
        return result;
    }

    public static List<BookItem> searchByType(BookType type) {
        List<BookItem> result = new ArrayList<>();
        for (BookItem bookItem : bookItems.values()) {
            if (bookItem.getBook().getBookType() == type) {
                result.add(bookItem);
            }
        }
        return result;
    }

    public static List<BookItem> searchBySubject(String subject) {
        List<BookItem> result = new ArrayList<>();
        for (BookItem bookItem : bookItems.values()) {
            if (bookItem.getBook().getSubject().equalsIgnoreCase(subject)) {
                result.add(bookItem);
            }
        }
        return result;
    }
}
