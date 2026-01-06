package lld_algomaster.bookmyshow.strategy.pricing;


import lld_algomaster.bookmyshow.entities.ShowSeat;

import java.util.List;

public class WeekendPricingStrategy implements PricingStrategy {
    private static final double WEEKEND_SURCHARGE = 1.2; // 20% surcharge

    @Override
    public double calculatePrice(List<ShowSeat> seats) {
        double basePrice = seats.stream().mapToDouble(showSeat -> showSeat.getSeat().getSeatType().getPrice()).sum();
        return basePrice * WEEKEND_SURCHARGE;
    }
}
