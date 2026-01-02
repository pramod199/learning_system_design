package lld_algomaster.atm.state;

import lld_algomaster.atm.ATMSystem;
import lld_algomaster.atm.enums.OperationType;

public class IdleState implements ATMState {
    private ATMSystem atmSystem;
    public IdleState(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("\nCard has been inserted.");
        atmSystem.
    }

    @Override
    public void enterPin(String pin) {

    }

    @Override
    public void selectOperation(OperationType op, int... args) {

    }

    @Override
    public void ejectCard() {

    }
}
