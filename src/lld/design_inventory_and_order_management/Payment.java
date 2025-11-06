package lld.design_inventory_and_order_management;


public class Payment {
    PaymentMode paymentMode;

    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean makePayment(double amount, String paymentDetails) {
        return paymentMode.makePayment(amount, paymentDetails);
    }
}
