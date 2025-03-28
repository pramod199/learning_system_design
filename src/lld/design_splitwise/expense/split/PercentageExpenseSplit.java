package lld.design_splitwise.expense.split;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        //validate total percentage in splits of each user is equal to 100 %
        double totalPercentage = 0;
        for(Split split: splitList) {
            totalPercentage += split.getAmountOwe();
        }
        if(totalPercentage != 100) {
            //throw exception
            throw new RuntimeException("Percentage should be equal to 100");
        }
    }
}
