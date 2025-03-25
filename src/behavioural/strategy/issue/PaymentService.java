package behavioural.strategy.issue;

/*
 background: payment service is a service that allows users to make payments. It has different payment methods
 */
public class PaymentService {
    private int cost;
    private boolean includeDelivery;

    /*
    this works fine if we accept only credit card payments, but what if later we want to access other payment method. need to change code
    violating open close principle
     */
    public void processOrder(){
        // pop up to collect card details
        CreditCard creditCard = new CreditCard("card number", "expiryDate", "cvv");
        // validate credit card..
        System.out.println("Paying total : " + getTotal() + " using credit card");
        creditCard.setAmount(creditCard.getAmount() - getTotal());
    }

    /*
        this violates single responsibility principle: as it is doing more than one thing
        this violates open close principle: as we need to change code to add new payment method
     */
    public void processOrder(String paymentMethod) {
        if ("CreditCard".equals(paymentMethod)) {
            // pop up to collect card details
            CreditCard creditCard = new CreditCard("card number", "expiryDate", "cvv");
            // validate credit card..
            System.out.println("Paying total : " + getTotal() + " using credit card");
            creditCard.setAmount(creditCard.getAmount() - getTotal());

        } else if ("PayPal".equals(paymentMethod)) {
            // pop up to collect paypal details
            System.out.println("Paying total : " + getTotal() + " using paypal");
        } else if ("GooglePay".equals(paymentMethod)) {
            // pop up to collect google pay details
            System.out.println("Paying total : " + getTotal() + " using google pay");
        }
    }



    private int getTotal() {
        return includeDelivery ? cost + 5 : cost;
    }
}
