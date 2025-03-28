package lld.design_atm.atm_states;

import lld.design_atm.ATM;
import lld.design_atm.Card;
import lld.design_atm.amount_withdrawl.CashWithdrawProcessor;
import lld.design_atm.amount_withdrawl.FiveHundredWithdrawProcessor;
import lld.design_atm.amount_withdrawl.OneHundredWithdrawProcessor;
import lld.design_atm.amount_withdrawl.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState(ATM atm) {
        super(atm);
    }

    public void cashWithdrawal(Card card, int withdrawalAmountRequest) {

        if (atm.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit();
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit();
        } else {

            card.withdraw(withdrawalAmountRequest);
            atm.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atm, withdrawalAmountRequest);
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
