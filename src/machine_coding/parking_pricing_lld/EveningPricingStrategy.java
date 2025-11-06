package machine_coding.parking_pricing_lld;

import java.time.Duration;
import java.time.LocalDateTime;

class EveningPricingStrategy implements PricingStrategy {
    private final double ratePerHour;

    public EveningPricingStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculate(LocalDateTime entry, LocalDateTime exit) {
        long minutes = Duration.between(entry, exit).toMinutes();
        double hours = Math.ceil(minutes / 60.0);
        return hours * ratePerHour;
    }
}
