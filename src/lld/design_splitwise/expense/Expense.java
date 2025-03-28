package lld.design_splitwise.expense;

import lld.design_splitwise.user.User;
import lld.design_splitwise.expense.split.Split;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidBy;
    ExpenseSplitType expenseSplitType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount,
                   User paidBy, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidBy = paidBy;
        this.expenseSplitType = expenseSplitType;
        this.splitDetails.addAll(splitDetails);
    }



}
