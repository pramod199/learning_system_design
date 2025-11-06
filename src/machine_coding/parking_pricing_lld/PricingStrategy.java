package machine_coding.parking_pricing_lld;

import java.time.LocalDateTime;

interface PricingStrategy {
    double calculate(LocalDateTime entry, LocalDateTime exit);
}
