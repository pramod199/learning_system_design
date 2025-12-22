package lld.design_parking_lot.strategy;

import lld.design_parking_lot.entity.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}

