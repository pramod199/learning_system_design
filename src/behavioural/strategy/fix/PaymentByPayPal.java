package behavioural.strategy.fix;

public class PaymentByPayPal implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void collectPaymentDetails() {
        // pop up to collect paypal details
        email = "email";
        password = "password";
    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        // validate paypal..
        System.out.println("Paying " + amount + " using paypal");
    }
}
