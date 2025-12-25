package lld_algomaster.design_parking_lot.factory;

import lld_algomaster.design_parking_lot.factory.PaymentMethod;

class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[CASH] Paid " + amount);
        return true;
    }
}