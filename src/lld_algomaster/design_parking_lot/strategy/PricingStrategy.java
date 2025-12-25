package lld_algomaster.design_parking_lot.strategy;

import lld_algomaster.design_parking_lot.entity.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}

