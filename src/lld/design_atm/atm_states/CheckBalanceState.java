package lld.design_atm.atm_states;

import lld.design_atm.ATM;
import lld.design_atm.Card;

public class CheckBalanceState extends ATMState {
    public CheckBalanceState(ATM atm) {
        super(atm);
    }

    @Override
    public void displayBalance(Card card){
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit();
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
