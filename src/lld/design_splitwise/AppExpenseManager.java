package lld.design_splitwise;

import lld.design_splitwise.expense.Expense;
import lld.design_splitwise.expense.ExpenseController;
import lld.design_splitwise.expense.ExpenseSplitType;
import lld.design_splitwise.expense.split.Split;
import lld.design_splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class AppExpenseManager {
    private List<Expense> appExpenses;
    private ExpenseController expenseController;

    public AppExpenseManager() {
        appExpenses = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public Expense createAppExpense(String expenseId, String description, double expenseAmount,
                                    User paidBy, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, paidBy, expenseSplitType, splitDetails);
        appExpenses.add(expense);
        return expense;
    }

    public List<Expense> getAppExpenses() {
        return appExpenses;
    }
}
