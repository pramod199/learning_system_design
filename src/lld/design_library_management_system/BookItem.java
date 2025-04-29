package lld.design_library_management_system;

import lld.design_library_management_system.enums.BookFormat;
import lld.design_library_management_system.enums.BookStatus;

import java.util.Date;

public class BookItem {

    private Book book;
    private BookStatus status;
    private String barcode;
    Date publicationDate;
    Rack rackLocation;
    private BookFormat bookFormat;
    Date issuedDate; // important to keep track of when the book was issued

    public BookItem(Book book, BookStatus status, String barcode, Date publicationDate, Rack rackLocation,
                    BookFormat bookFormat) {
        this.book = book;
        this.status = status;
        this.barcode = barcode;
        this.publicationDate = publicationDate;
        this.rackLocation = rackLocation;
        this.bookFormat = bookFormat;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Rack getRackLocation() {
        return rackLocation;
    }

    public void setRackLocation(Rack rackLocation) {
        this.rackLocation = rackLocation;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(BookFormat bookFormat) {
        this.bookFormat = bookFormat;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
}
