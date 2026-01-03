package lld_algomaster.atm.entities;

import lld_algomaster.atm.chainofresponsibility.NoteDispenser;

public class CashDispenser {
    private final NoteDispenser chain;
    public CashDispenser(NoteDispenser chain) {
        this.chain = chain;
    }

    public synchronized void dispenseCash(int amount) {
        chain.dispense(amount);
    }

    public synchronized boolean canDispenseCash(int amount) {
        if (amount % 10 != 0) {
            return false;
        }
        return chain.canDispense(amount);
    }
}
