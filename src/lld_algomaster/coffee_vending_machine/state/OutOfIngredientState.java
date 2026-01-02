package lld_algomaster.coffee_vending_machine.state;

import lld_algomaster.coffee_vending_machine.CoffeeVendingMachine;
import lld_algomaster.coffee_vending_machine.decorator.Coffee;

public class OutOfIngredientState extends VendingMachineState {

    public OutOfIngredientState(CoffeeVendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        System.out.println("Sorry, the machine is out of ingredients.");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Sorry, the machine is out of ingredients. Money refunded.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Sorry, the machine is out of ingredients.");
    }

    @Override
    public void cancel() {
        System.out.println("Refunding " + vendingMachine.getMoneyInserted());
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
