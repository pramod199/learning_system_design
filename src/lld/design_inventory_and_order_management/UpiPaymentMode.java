package lld.design_inventory_and_order_management;

public class UpiPaymentMode implements PaymentMode {
    @Override
    public boolean makePayment(double amount, String paymentDetails) {
        System.out.println("payment done through upi.");
        return true;
    }
}
