package lld.design_library_management_system;

public class Librarian extends SystemUser {
    Search searchObj;
    BookIssueService issueService;

    public Librarian(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phone = phoneNumber;
        this.searchObj = new Search();
        this.issueService = new BookIssueService();
    }

    public boolean addBookItem(BookItem bookItem) {
        Database.addBookItem(bookItem);
        return true;
    }

    public BookItem deleteBookItem(String barcode) {
        return Database.removeBookItem(barcode);
    }

    public BookItem editBookItem(BookItem bookItem) {
        Database.updateBookItem(bookItem);
        return bookItem;
    }
}
