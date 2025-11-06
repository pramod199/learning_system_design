package lld.design_inventory_and_order_management;

public interface PaymentMode {
    boolean makePayment(double amount, String paymentDetails);
}
