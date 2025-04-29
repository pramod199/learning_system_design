package lld.design_zomato.delivery_partner_matching_strategy;


import lld.design_zomato.delivery.DeliveryMetaData;

public class StrategyManager {
    private static StrategyManager strategyManagerInstance;

    private StrategyManager() {}

    public static StrategyManager getStrategyManager() {
        if (strategyManagerInstance == null) {
            synchronized (StrategyManager.class) {
                if (strategyManagerInstance == null) {
                    strategyManagerInstance = new StrategyManager();
                }
            }
        }
        return strategyManagerInstance;
    }

    public IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData metaData) {
        System.out.println("Based on location, weather and other factors, setting partner strategy");
        return new LocBasedDeliveryPartnerMatchingStrategy(); // Assuming you will create this class separately
    }
}
