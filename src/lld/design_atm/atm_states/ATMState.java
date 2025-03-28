package lld.design_atm.atm_states;

import lld.design_atm.ATM;
import lld.design_atm.Card;
import lld.design_atm.TransactionType;

public abstract class ATMState {
    ATM atm;

    public ATMState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard(Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(Card card, String pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(Card card, TransactionType txnType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(Card card, int withdrawAmount){
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(){
        System.out.println("OOPS!! Something went wrong");
    }



}
