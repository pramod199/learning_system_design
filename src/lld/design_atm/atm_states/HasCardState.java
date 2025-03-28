package lld.design_atm.atm_states;

import lld.design_atm.ATM;
import lld.design_atm.Card;

public class HasCardState extends ATMState {
    public HasCardState(ATM atm) {
        super(atm);
    }

    @Override
    public void authenticatePin(Card card, String pin){
        boolean isCorrectPinEntered = card.isPinValid(pin);

        if(isCorrectPinEntered) {
            atm.setCurrentATMState(new SelectOperationState(atm));
        } else {
            System.out.println("Invalid PIN Number");
            exit();
        }
    }

    @Override
    public void exit(){
        returnCard();
        atm.setCurrentATMState(new IdleState(atm));
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

}
