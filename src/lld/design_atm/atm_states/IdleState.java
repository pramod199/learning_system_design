package lld.design_atm.atm_states;

import lld.design_atm.ATM;
import lld.design_atm.Card;

public class IdleState extends ATMState {

    public IdleState(ATM atm) {
        super(atm);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState(atm));
    }

}
