package lld.design_library_management_system;

public class BookIssueService {

    FineService fineService; // to decouple the fine service from the book issue service

    public BookReservationDetail getReservationDetail(BookItem bookItem) {
        return new BookReservationDetail();
    }

    public void updateReservationDetail(BookReservationDetail reservationDetail) {
    }

    public BookReservationDetail reserveBook(BookItem bookItem, SystemUser user) {
        return new BookReservationDetail();
    }

    public BookIssueDetail issueBook(BookItem bookItem, SystemUser user) {
        return new BookIssueDetail();
    }

    public BookIssueDetail renewBook(BookItem bookItem, SystemUser user) {
        return new BookIssueDetail();
    }

    public void returnBook(BookItem bookItem, SystemUser user) {
    }
}
