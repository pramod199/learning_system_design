package lld.design_parking_lot.strategy;

import lld.design_parking_lot.entity.Ticket;
import lld.design_parking_lot.strategy.PricingStrategy;

public class SimpleHourlyPricingStrategy implements PricingStrategy {
    private final double ratePerHour;

    public SimpleHourlyPricingStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        long end = ticket.getExitTimeMillis();
        long start = ticket.getEntryTimeMillis();
        long durationMillis = end - start;
        double hours = Math.ceil(durationMillis / (1000.0 * 60 * 60)); // round up
        return hours * ratePerHour;
    }
}
