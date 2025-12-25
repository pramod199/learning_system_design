package lld_algomaster.design_parking_lot.factory;

import lld_algomaster.design_parking_lot.factory.PaymentMethod;

class CardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[CARD] Paid " + amount);
        return true;
    }
}