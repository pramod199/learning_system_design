package machine_coding.wayfair_bike_rental_shop.pricing_strategy;

import machine_coding.wayfair_bike_rental_shop.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PricingStrategy {
    BigDecimal calculatePrice(Vehicle vehicle, LocalDateTime start, LocalDateTime end);
}
