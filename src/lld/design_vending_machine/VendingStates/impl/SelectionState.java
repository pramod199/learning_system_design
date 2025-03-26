package lld.design_vending_machine.VendingStates.impl;

import lld.design_vending_machine.Coin;
import lld.design_vending_machine.Item;
import lld.design_vending_machine.VendingMachine;
import lld.design_vending_machine.VendingStates.State;

import java.util.List;

public class SelectionState implements State {

    private VendingMachine vendingMachine;

    public SelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void clickOnInsertCoinButton() {
        throw new RuntimeException("you can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton() {
        return;
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new RuntimeException("you can not insert Coin in selection state");
    }

    @Override
    public void chooseProduct(int codeNumber) throws Exception {
        //1. get item of this codeNumber
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        //2. total amount paid by User
        int paidByUser = 0;
        for(Coin coin : vendingMachine.getCoinList()){
            paidByUser = paidByUser + coin.getValue();
        }

        //3. compare product price and amount paid by user
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney();
            throw new Exception("insufficient amount");
        }
        else if(paidByUser >= item.getPrice()) {

            if(paidByUser > item.getPrice()) {
                getChange(paidByUser-item.getPrice());
            }
            vendingMachine.setVendingState(new DispenseState(vendingMachine, codeNumber));
        }

    }

    @Override
    public int getChange(int returnExtraMoney) {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;


    }

    @Override
    public Item dispenseProduct(int codeNumber) {
        throw new RuntimeException("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refundFullMoney() {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
