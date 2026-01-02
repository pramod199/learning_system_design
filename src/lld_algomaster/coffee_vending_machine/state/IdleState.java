package lld_algomaster.coffee_vending_machine.state;

import lld_algomaster.coffee_vending_machine.CoffeeVendingMachine;
import lld_algomaster.coffee_vending_machine.decorator.Coffee;

public class IdleState extends VendingMachineState {

    public IdleState(CoffeeVendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        vendingMachine.setSelectedCoffee(coffee);
        vendingMachine.setState(new CoffeeSelectedState(vendingMachine));
        System.out.println(coffee.getCoffeeType() + " selected. Price: " + coffee.getPrice());
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Please select coffee first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please select and pay first.");

    }

    @Override
    public void cancel() {
        System.out.println("Noting to cancel");

    }
}
