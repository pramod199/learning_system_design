package lld.design_library_management_system;

import java.util.Date;

public class Member extends SystemUser {
    Date dateOfMembership;
    int totalBookCheckedOut; // needed to keep track of particular user can't borrow more than 5 bok
    Search searchObj;
    BookIssueService issueService;
}
