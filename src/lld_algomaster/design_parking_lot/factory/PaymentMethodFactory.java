package lld_algomaster.design_parking_lot.factory;

import lld_algomaster.design_parking_lot.factory.CardPayment;
import lld_algomaster.design_parking_lot.factory.CashPayment;
import lld_algomaster.design_parking_lot.factory.PaymentMethod;
import lld_algomaster.design_parking_lot.factory.UpiPayment;

class PaymentMethodFactory {
    public static PaymentMethod get(String type) {
        return switch (type.toUpperCase()) {
            case "CARD" -> new CardPayment();
            case "UPI"  -> new UpiPayment();
            case "CASH" -> new CashPayment();
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }
}