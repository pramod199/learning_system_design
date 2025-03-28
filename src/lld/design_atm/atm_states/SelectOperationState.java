package lld.design_atm.atm_states;

import lld.design_atm.ATM;
import lld.design_atm.Card;
import lld.design_atm.TransactionType;

public class SelectOperationState extends ATMState {
    public SelectOperationState(ATM atm) {
        super(atm);
        showOperations();
    }

    @Override
    public void selectOperation(Card card, TransactionType txnType){

        switch (txnType) {

            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawalState(atm));
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceState(atm));
                break;
            default: {
                System.out.println("Invalid Option");
                exit();
            }

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

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showALlTransactionType();
    }


}
