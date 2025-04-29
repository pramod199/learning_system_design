package lld.design_library_management_system;

import lld.design_library_management_system.enums.BookStatus;
import lld.design_library_management_system.enums.ReservationStatus;

import java.util.Calendar;
import java.util.Date;

public class BookIssueService {

    FineService fineService = new FineService();

    NotificationService notificationService = new NotificationService();

    public BookReservationDetail getReservationDetail(BookItem bookItem) {
        return Database.getReservation(bookItem.getBarcode());
    }

    public void updateReservationDetail(BookReservationDetail reservationDetail) {
        Database.saveReservation(reservationDetail);
    }

    public BookReservationDetail reserveBook(BookItem bookItem, SystemUser user) {
        BookReservationDetail detail = new BookReservationDetail();
        detail.bookItem = bookItem;
        detail.startDate = new Date();
        detail.user = user;
        detail.status = ReservationStatus.WAITING;
        bookItem.setStatus(BookStatus.RESERVED);
        Database.saveReservation(detail);
        return detail;
    }

    public BookIssueDetail issueBook(BookItem bookItem, SystemUser user) {
        BookIssueDetail issueDetail = new BookIssueDetail();
        issueDetail.bookItem = bookItem;
        issueDetail.user = user;
        issueDetail.startDate = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 14); // 2 weeks
        issueDetail.dueDate = c.getTime();
        bookItem.setStatus(BookStatus.ISSUED);
        Database.saveIssue(issueDetail);

        if (user instanceof Member) {
            ((Member) user).incrementCheckedOut();
        }

        return issueDetail;
    }

    public BookIssueDetail renewBook(BookItem bookItem, SystemUser user) {
        BookIssueDetail issueDetail = Database.getIssue(bookItem.getBarcode());
        if (issueDetail != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(issueDetail.dueDate);
            c.add(Calendar.DATE, 14);
            issueDetail.dueDate = c.getTime();
            Database.saveIssue(issueDetail);
        }
        return issueDetail;
    }

    public void returnBook(BookItem bookItem, SystemUser user) {
        BookIssueDetail issueDetail = Database.getIssue(bookItem.getBarcode());
        if (issueDetail != null) {
            issueDetail.returnDate = new Date();
            bookItem.setStatus(BookStatus.AVAILABLE);

            Fine fine = fineService.calculateFine(bookItem, issueDetail.dueDate, user);
            if (fine.getFineValue() > 0) {
                System.out.println("Fine to pay: Rs " + fine.getFineValue());
            }
            Database.removeIssue(bookItem.getBarcode());

            if (user instanceof Member) {
                ((Member) user).decrementCheckedOut();
            }

            notificationService.notifyUser(user, "book returned");
        }
    }
}
