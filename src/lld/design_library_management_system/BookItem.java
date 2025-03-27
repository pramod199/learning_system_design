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

}
