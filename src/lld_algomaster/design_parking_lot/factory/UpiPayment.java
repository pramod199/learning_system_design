package lld_algomaster.design_parking_lot.factory;

public class UpiPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[UPI] Paid " + amount);
        return true;
    }
}