package lld_algomaster.atm.state;

import lld_algomaster.atm.enums.OperationType;

public interface ATMState {
    void insertCard (String cardNumber);
    void enterPin (String pin);
    void selectOperation (OperationType op, int... args);

    void ejectCard ();
}
