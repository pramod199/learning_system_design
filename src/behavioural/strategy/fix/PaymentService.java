package behavioural.strategy.fix;

public class PaymentService {
    private int cost;
    private boolean includeDelivery;

    private PaymentStrategy paymentStrategy;

    public void processOrder() { // this class has no vivibility of how payment is being conducted as it is making use of the strategy interface
        paymentStrategy.collectPaymentDetails();
        if(paymentStrategy.validatePaymentDetails()) {
            paymentStrategy.pay(getTotalCost());
        }
    }

    private int getTotalCost() {
        return cost + (includeDelivery ? 10 : 0);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
