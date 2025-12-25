package lld_algomaster.design_online_shopping_service.service;

import lld_algomaster.design_online_shopping_service.strategy.PaymentStrategy;

public class PaymentService {

    public boolean processPayment(PaymentStrategy strategy, double amount) {
        return strategy.pay(amount);
    }
}
