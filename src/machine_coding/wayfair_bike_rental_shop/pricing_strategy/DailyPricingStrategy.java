package machine_coding.wayfair_bike_rental_shop.pricing_strategy;

import machine_coding.wayfair_bike_rental_shop.Vehicle;
import machine_coding.wayfair_bike_rental_shop.enums.VehicleType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class DailyPricingStrategy implements PricingStrategy {
    private final Map<VehicleType, BigDecimal> dailyRates;

    public DailyPricingStrategy(Map<VehicleType, BigDecimal> dailyRates) {
        this.dailyRates = dailyRates;
    }

    @Override
    public BigDecimal calculatePrice(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        long days = Math.max(1, java.time.Duration.between(start, end).toDays());
        BigDecimal rate = dailyRates.get(vehicle.type);
        return rate.multiply(BigDecimal.valueOf(days));
    }
}
