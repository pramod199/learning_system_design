package lld.design_vending_machine.VendingStates.impl;

import lld.design_vending_machine.Coin;
import lld.design_vending_machine.Item;
import lld.design_vending_machine.VendingMachine;
import lld.design_vending_machine.VendingStates.State;

import java.util.List;

public class HasMoneyState implements State {
    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        System.out.println("Currently Vending machine is in HasMoneyState");
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoinButton() {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton() {
        vendingMachine.setVendingState(new SelectionState(vendingMachine));
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Accepted the coin");
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(int codeNumber) {
        throw new RuntimeException("you need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) {
        throw new RuntimeException("you can not get change in hasMoney state");
    }

    @Override
    public Item dispenseProduct(int codeNumber) {
        throw new RuntimeException("product can not be dispensed in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney() {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();

    }

    @Override
    public void updateInventory(Item item, int codeNumber) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }
}
