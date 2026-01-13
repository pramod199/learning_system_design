package lld_algomaster.splitwise.factory;

import lld_algomaster.splitwise.enums.SplitType;
import lld_algomaster.splitwise.strategy.EqualSplitStrategy;
import lld_algomaster.splitwise.strategy.ExactSplitStrategy;
import lld_algomaster.splitwise.strategy.PercentageSplitStrategy;
import lld_algomaster.splitwise.strategy.SplitStrategy;

public class SplitStrategyFactory {

    public static SplitStrategy get(SplitType splitType) {
        SplitStrategy splitStrategy;
        switch (splitType) {
            case EQUAL:
                splitStrategy =new EqualSplitStrategy();
                break;
            case EXACT:
                splitStrategy =new ExactSplitStrategy();
                break;
            case PERCENTAGE:
                splitStrategy = new PercentageSplitStrategy();
                break;
            default:
                throw new IllegalArgumentException("split strategy not implemented");
        }
        return splitStrategy;
    }
}
