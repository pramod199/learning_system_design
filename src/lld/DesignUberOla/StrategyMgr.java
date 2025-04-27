package lld.DesignUberOla;

public class StrategyMgr {
    private static StrategyMgr instance;

    private StrategyMgr() {
        // private constructor to prevent instantiation
    }

    public static StrategyMgr getInstance() {
        if (instance == null) {
            synchronized (StrategyMgr.class) {
                if (instance == null) { // double-checked locking
                    instance = new StrategyMgr();
                }
            }
        }
        return instance;
    }

    public DriverMatchingStrategy determineDriverMatchingStrategy(TripMetadata tripMetadata) {
        // logic to get the appropriate driver matching strategy
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }

    public PricingStrategy determinePricingStrategy(TripMetadata tripMetadata) {
        // logic to get the appropriate pricing strategy
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new RatingBasedPricingStrategy();
    }

}
