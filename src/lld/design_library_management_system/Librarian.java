package lld.design_library_management_system;

public class Librarian extends SystemUser {
    Search searchObj;
    BookIssueService issueService;

    public boolean addBookItem(BookItem bookItem) {
        return false;
    }

    public BookItem deleteBookItem(String barcode) {
        return new BookItem();
    }

    public BookItem editBookItem(BookItem bookItem) {
        return bookItem;
    }
}
