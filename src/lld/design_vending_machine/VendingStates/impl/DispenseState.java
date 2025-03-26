package lld.design_vending_machine.VendingStates.impl;

import lld.design_vending_machine.Coin;
import lld.design_vending_machine.Item;
import lld.design_vending_machine.VendingMachine;
import lld.design_vending_machine.VendingStates.State;
import lld.design_vending_machine.VendingStates.impl.IdleState;

import java.util.List;

public class DispenseState implements State {

    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        this.vendingMachine = vendingMachine;
        dispenseProduct(codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton() {
        throw new RuntimeException("insert coin button can not clicked on Dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton() {
        throw new RuntimeException("product selection buttion can not be clicked in Dispense state");
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new RuntimeException("coin can not be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(int codeNumber) throws Exception {
        throw new Exception("product can not be choosen in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) {
        throw new RuntimeException("change can not returned in Dispense state");
    }

    @Override
    public Item dispenseProduct(int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return item;

    }

    @Override
    public List<Coin> refundFullMoney() {
        throw new RuntimeException("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(Item item, int codeNumber) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }
}
