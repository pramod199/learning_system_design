package lld_algomaster.coffee_vending_machine.state;

import lld_algomaster.coffee_vending_machine.CoffeeVendingMachine;
import lld_algomaster.coffee_vending_machine.Inventory;
import lld_algomaster.coffee_vending_machine.decorator.Coffee;

public class PaidState extends VendingMachineState {

    public PaidState(CoffeeVendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        System.out.println("Cannot select another coffee now.");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Already paid. Please wait for your coffee.");
    }

    @Override
    public void dispenseCoffee() {
        Inventory inventory = Inventory.getInstance();
        Coffee selectedCoffee = vendingMachine.getSelectedCoffee();
        if (!inventory.hasIngredients(selectedCoffee.getRecipe())){
            System.out.println("Sorry, out of ingredients for " + vendingMachine.getSelectedCoffee().getCoffeeType());
            vendingMachine.setState(new OutOfIngredientState(vendingMachine));
            vendingMachine.getState().cancel();
            return;
        }
        inventory.deductIngredients(selectedCoffee.getRecipe());

        selectedCoffee.prepare();
        int change = vendingMachine.getMoneyInserted() - selectedCoffee.getPrice();
        if (change > 0) {
            System.out.println("Returning Change: "+ change);
        }
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override
    public void cancel() {
        new CoffeeSelectedState(vendingMachine).cancel(); // Same as in SelectingState
    }
}
