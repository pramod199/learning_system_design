package behavioural.strategy.fix;

import behavioural.strategy.issue.CreditCard;

public class PaymentByCreditCard implements PaymentStrategy {

    private CreditCard card;

    @Override
    public void collectPaymentDetails() {
        // pop up to collect card details
        card = new CreditCard("card number", "expiryDate", "cvv");
    }

    @Override
    public boolean validatePaymentDetails() {
        // validate credit card..
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using credit card");
        card.setAmount(card.getAmount() - amount);
    }
}
