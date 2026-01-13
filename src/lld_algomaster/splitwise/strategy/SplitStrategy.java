package lld_algomaster.splitwise.strategy;

import lld_algomaster.splitwise.entities.Split;
import lld_algomaster.splitwise.entities.User;

import java.util.List;

public interface SplitStrategy {

    List<Split> calculateSplit(double totalAmount, User paidBy, List<User> participants, List<Double> splitValues);

}
