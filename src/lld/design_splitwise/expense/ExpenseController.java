package lld.design_splitwise.expense;

import lld.design_splitwise.BalanceSheetController;
import lld.design_splitwise.user.User;
import lld.design_splitwise.expense.split.ExpenseSplit;
import lld.design_splitwise.expense.split.Split;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 User paidBy, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        // validate split
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(expenseSplitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, description, expenseAmount, paidBy, expenseSplitType, splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, splitDetails, expenseAmount); // very important as to update balance sheet for each user.
        return expense;
    }

    // updateExpense() can be also created.
}
