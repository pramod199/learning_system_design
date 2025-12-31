package lld_algomaster.vending_machine;

import lld_algomaster.vending_machine.entities.Inventory;
import lld_algomaster.vending_machine.entities.Item;
import lld_algomaster.vending_machine.enums.Coin;
import lld_algomaster.vending_machine.state.IdleState;
import lld_algomaster.vending_machine.state.VendingMachineState;

public class VendingMachine {
    private final static VendingMachine INSTANCE = new VendingMachine();
    private final Inventory inventory = new Inventory();
    private VendingMachineState currentVendingMachineState;

    private int balance = 0;
    private String selectedItemCode;

    private VendingMachine() {
        currentVendingMachineState = new IdleState(this);
    }

    // getters and setters
    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    public void setState(VendingMachineState vendingMachineState) {
        this.currentVendingMachineState = vendingMachineState;
    }

    public VendingMachineState getState(){
        return this.currentVendingMachineState;
    }

    public Item getSelectedItem() {
        return inventory.getItem(selectedItemCode);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getBalance() {
        return balance;
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    // helper methods
    public void addBalance(int value) {
        balance += value;
    }


    public void reset() {
        selectedItemCode = null;
        balance = 0;
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }

    public void dispenseItem() {
        Item item = inventory.getItem(selectedItemCode);
        if (balance >= item.getPrice()) {
            inventory.reduceStock(selectedItemCode);
            balance -= item.getPrice();
            System.out.println("Dispensed: " + item.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
        setState(new IdleState(this));
    }

    public Item addItem(String code, String name, int price, int quantity) {
        Item item = new Item(code, name, price);
        inventory.addItem(code, item, quantity);
        return item;
    }

    // user actions
    public void selectItem(String code) {
        currentVendingMachineState.selectItem(code);
    }

    public void insertCoin(Coin coin) {
        currentVendingMachineState.insertCoin(coin);
    }

    public void dispense() {
        currentVendingMachineState.dispense();
    }

    public void refund() {
        currentVendingMachineState.refund();
    }
}
