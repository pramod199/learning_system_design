package lld.design_library_management_system;

import java.util.Date;

public class Member extends SystemUser {
    private Date dateOfMembership;
    private int totalBookCheckedOut = 0;
    private static final int MAX_BOOKS_ALLOWED = 5;
    Search searchObj;
    BookIssueService issueService;

    public Member(String id, String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phone = phoneNumber;
        this.dateOfMembership = new Date();
        this.searchObj = new Search();
        this.issueService = new BookIssueService();
    }

    public boolean canCheckout() {
        return totalBookCheckedOut < MAX_BOOKS_ALLOWED;
    }

    public void incrementCheckedOut() {
        totalBookCheckedOut++;
    }

    public void decrementCheckedOut() {
        totalBookCheckedOut--;
    }

}
