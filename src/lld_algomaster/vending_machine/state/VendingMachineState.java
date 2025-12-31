package lld_algomaster.vending_machine.state;

import lld_algomaster.vending_machine.VendingMachine;
import lld_algomaster.vending_machine.enums.Coin;

/*
 idle state -> item selected state -> has money state->

 Idle
 ↓ selectItem
ItemSelected
 ↓ insertCoin
HasMoney
 ↓ dispense
Dispensing
 ↓ (auto)
Idle

 */
public abstract class VendingMachineState {
    VendingMachine machine;

    VendingMachineState(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();
}
