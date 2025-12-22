package lld.design_parking_lot;

class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[CASH] Paid " + amount);
        return true;
    }
}