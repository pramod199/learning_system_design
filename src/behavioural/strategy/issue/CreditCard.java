package behavioural.strategy.issue;

public class CreditCard {
    String cardNumber;
    String expiryDate;
    String cvv;
    int amount;
    public CreditCard(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
