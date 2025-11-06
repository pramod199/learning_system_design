package machine_coding.parking_pricing_lld;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PricingStrategy morning = new MorningPricingStrategy(15); // $15/hr
        PricingStrategy evening = new EveningPricingStrategy(8);  // $8/hr
        PricingStrategyFactory strategyFactory = new PricingStrategyFactory(morning, evening);

        ParkingLot lot = new ParkingLot(strategyFactory);

        double v = lot.calculateFee(LocalDateTime.of(2023, 10, 1, 20, 0), LocalDateTime.of(2023, 10, 1, 10, 0));
        System.out.println("Total fee: " + v); // Should print 120.0
    }
}
