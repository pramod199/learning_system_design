package behavioural.strategy.fix;

public interface PaymentStrategy {
    void collectPaymentDetails();

    boolean validatePaymentDetails();

    void pay(int amount);
}
