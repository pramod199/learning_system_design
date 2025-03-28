package lld.design_atm;

public class Card {
    private String cardNumber;
    private int cvv;
    private String expiryDate;
    private String pin;
    private String name;
    private BankAccount account;

    public Card(String cardNumber, String pin, BankAccount account) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public BankAccount getAccount() {
        return account;
    }

    public boolean isPinValid(String pin) {
        return this.pin.equals(pin);
    }

    public int getBankBalance() {
        return account.balance;
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

}
