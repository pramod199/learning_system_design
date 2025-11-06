package machine_coding.parking_pricing_lld;

import java.time.LocalDateTime;

class PricingStrategyFactory {
    private final PricingStrategy morningStrategy;
    private final PricingStrategy eveningStrategy;

    public PricingStrategyFactory(PricingStrategy morningStrategy, PricingStrategy eveningStrategy) {
        this.morningStrategy = morningStrategy;
        this.eveningStrategy = eveningStrategy;
    }

    public PricingStrategy getStrategy(LocalDateTime exitTime) {
        int hour = exitTime.getHour();
        if (hour >= 6 && hour < 18) {
            return morningStrategy;
        } else {
            return eveningStrategy;
        }
    }
}
