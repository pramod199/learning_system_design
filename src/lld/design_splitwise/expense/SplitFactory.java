package lld.design_splitwise.expense;

import lld.design_splitwise.expense.split.EqualExpenseSplit;
import lld.design_splitwise.expense.split.ExpenseSplit;
import lld.design_splitwise.expense.split.PercentageExpenseSplit;
import lld.design_splitwise.expense.split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                throw new IllegalArgumentException("Invalid split type");
        }
    }
}
