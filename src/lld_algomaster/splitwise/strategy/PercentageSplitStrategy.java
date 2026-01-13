package lld_algomaster.splitwise.strategy;

import lld_algomaster.splitwise.entities.Split;
import lld_algomaster.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> calculateSplit(double totalAmount, User paidBy, List<User> participants, List<Double> splitValues) {
        if (participants.size() != splitValues.size()) {
            throw new IllegalArgumentException("Number of participants and split values must match.");
        }
        double percentageSum = 0;
        for (Double splitValue : splitValues) {
            percentageSum += splitValue;
        }

        if (percentageSum != 100){
            throw new IllegalArgumentException("Number of participants and split values must match.");
        }

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            double amount = (totalAmount * splitValues.get(i)) / 100.0;
            splits.add(new Split(participants.get(i), amount));
        }
        return splits;
    }
}
