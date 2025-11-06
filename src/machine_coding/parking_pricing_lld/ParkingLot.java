package machine_coding.parking_pricing_lld;

import java.time.LocalDateTime;
import java.util.HashMap;

class ParkingLot {

    private final PricingStrategyFactory strategyFactory;

    public ParkingLot(PricingStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }


    public double calculateFee(LocalDateTime exitTime, LocalDateTime entryTime) {
        return strategyFactory.getStrategy(exitTime).calculate(entryTime, exitTime);
    }
}
