package behavioural.strategy.fix;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        // the strategy can now be easily picked up at runtime
        paymentService.setPaymentStrategy(new PaymentByPayPal());
        paymentService.processOrder();
    }
}
