package lld.design_splitwise.expense.split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit {
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        //validate total amount in splits of each user is equal and overall equals to totalAmount or not
        double totalAmountInSplits = 0;
        for(Split split: splitList) {
            totalAmountInSplits += split.getAmountOwe();
        }
        if(totalAmountInSplits != totalAmount) {
            //throw exception
            throw new RuntimeException("Amount should be equal for all users");
        }
    }
}
