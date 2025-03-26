package lld.design_vending_machine.VendingStates.impl;

import lld.design_vending_machine.Coin;
import lld.design_vending_machine.Item;
import lld.design_vending_machine.VendingMachine;
import lld.design_vending_machine.VendingStates.State;

import java.util.List;

public class IdleState implements State {

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Currently Vending machine is in IdleState");
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoinButton() {
        vendingMachine.setVendingState(new HasMoneyState(vendingMachine));
    }

    @Override
    public void clickOnStartProductSelectionButton() {
        throw new RuntimeException("Please insert coin first");
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new RuntimeException("Please insert coin first");
    }

    @Override
    public void chooseProduct(int codeNumber) {
        throw new RuntimeException("you can not choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) {
        throw new RuntimeException("Please insert coin first");
    }

    @Override
    public Item dispenseProduct(int codeNumber) {
        throw new RuntimeException("Please insert coin first");
    }

    @Override
    public List<Coin> refundFullMoney() {
        throw new RuntimeException("you can not get change in idle state");
    }

    @Override
    public void updateInventory(Item item, int codeNumber) throws Exception {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
