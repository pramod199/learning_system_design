package lld.design_splitwise.user;

import lld.design_splitwise.UserExpenseBalanceSheet;

public class User {
    String userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;

        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    public String getUserId() {
        return userId;
    }
}
