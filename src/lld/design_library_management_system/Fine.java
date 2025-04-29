package lld.design_library_management_system;

import java.util.Date;

public class Fine {
    Date fineDate;
    BookItem bookItem;
    SystemUser user;
    Double fineValue;

    public Fine(Date fineDate, BookItem bookItem, SystemUser user, Double fineValue) {
        this.fineDate = fineDate;
        this.bookItem = bookItem;
        this.user = user;
        this.fineValue = fineValue;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public SystemUser getUser() {
        return user;
    }

    public Double getFineValue() {
        return fineValue;
    }
}
