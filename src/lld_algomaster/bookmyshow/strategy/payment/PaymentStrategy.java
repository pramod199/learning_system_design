package lld_algomaster.bookmyshow.strategy.payment;


import lld_algomaster.bookmyshow.entities.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
