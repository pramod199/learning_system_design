package lld_algomaster.bookmyshow.strategy.pricing;


import lld_algomaster.bookmyshow.entities.ShowSeat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<ShowSeat> seats);
}
