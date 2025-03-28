package lld.design_atm.amount_withdrawl;

import lld.design_atm.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor next;

    CashWithdrawProcessor(CashWithdrawProcessor next) {
        this.next = next;
    }

    public void withdraw(ATM atm, int amount) {
        if (next != null) {
            next.withdraw(atm, amount);
        } else {
            System.out.println("something went wrong!");
        }
    }

}
