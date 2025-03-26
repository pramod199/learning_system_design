package lld.design_vending_machine;

import lld.design_vending_machine.VendingStates.State;
import lld.design_vending_machine.VendingStates.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private State vendingState;

    private Inventory inventory;

    private List<Coin> coinList;

    public VendingMachine() {
        this.vendingState = new IdleState(this);
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }

    public State getVendingState() {
        return vendingState;
    }

    public void setVendingState(State vendingState) {
        this.vendingState = vendingState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
