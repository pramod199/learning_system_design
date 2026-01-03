package lld_algomaster.atm.state;

import lld_algomaster.atm.ATMSystem;
import lld_algomaster.atm.enums.OperationType;

public class HasCardState implements ATMState {
    private ATMSystem atmSystem;
    public HasCardState(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Error: A card is already inserted. Cannot insert another card.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Authenticating PIN...");
        boolean isAuthenticated = atmSystem.authenticate(pin);;

        if (isAuthenticated) {
            System.out.println("Authentication successful.");
            atmSystem.changeState(new AuthenticatedState(atmSystem));
        } else {
            System.out.println("Authentication failed: Incorrect PIN.");
            ejectCard();
        }
    }

    @Override
    public void selectOperation(OperationType op, int... args) {
        System.out.println("Error: Please enter your PIN first to select an operation.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card has been ejected. Thank you for using our ATM.");
        atmSystem.setCurrentCard(null);
        atmSystem.changeState(new IdleState(atmSystem));
    }
}
