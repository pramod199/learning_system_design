package lld.design_atm.amount_withdrawl;

import lld.design_atm.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor next) {
        super(next);
    }

    public void withdraw(ATM atm, int remainingAmount) {

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (required-atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }

}
