package lld_algomaster.bookmyshow.strategy.pricing;


import lld_algomaster.bookmyshow.entities.ShowSeat;

import java.util.List;

public class WeekdayPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(List<ShowSeat> seats) {
        return seats.stream().mapToDouble(showSeat -> showSeat.getSeat().getSeatType().getPrice()).sum();
    }
}
