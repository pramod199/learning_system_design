package lld.design_inventory_and_order_management;

public class CardPaymentMode implements PaymentMode {
    @Override
    public boolean makePayment(double amount, String paymentDetails) {
        System.out.println("paid through card");
        return true;
    }
}
