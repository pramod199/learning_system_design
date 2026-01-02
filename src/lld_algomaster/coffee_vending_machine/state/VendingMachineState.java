package lld_algomaster.coffee_vending_machine.state;

import lld_algomaster.coffee_vending_machine.CoffeeVendingMachine;
import lld_algomaster.coffee_vending_machine.decorator.Coffee;

public abstract class VendingMachineState {
    CoffeeVendingMachine vendingMachine;

    public VendingMachineState(CoffeeVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void selectCoffee(Coffee coffee);

    public abstract void insertMoney(int amount);

    public abstract void dispenseCoffee();

    public abstract void cancel();

}
