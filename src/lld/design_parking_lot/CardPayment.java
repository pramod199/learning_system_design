package lld.design_parking_lot;

class CardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[CARD] Paid " + amount);
        return true;
    }
}