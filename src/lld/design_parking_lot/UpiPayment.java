package lld.design_parking_lot;

class UpiPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[UPI] Paid " + amount);
        return true;
    }
}