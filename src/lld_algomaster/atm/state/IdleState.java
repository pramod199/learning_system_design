package lld_algomaster.atm.state;

import lld_algomaster.atm.ATMSystem;
import lld_algomaster.atm.entities.Card;
import lld_algomaster.atm.enums.OperationType;

public class IdleState implements ATMState {
    private ATMSystem atmSystem;
    public IdleState(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("\nCard has been inserted.");
        Card card = atmSystem.getCard(cardNumber);

        if (card == null) {
            ejectCard();
        } else {
            atmSystem.setCurrentCard(card);
            atmSystem.changeState(new HasCardState(atmSystem));
        }
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Error: Please insert a card first.");
    }

    @Override
    public void selectOperation(OperationType op, int... args) {
        System.out.println("Error: Please insert a card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Error: Card not found.");
        atmSystem.setCurrentCard(null);
    }
}
