package lld.design_parking_lot;

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