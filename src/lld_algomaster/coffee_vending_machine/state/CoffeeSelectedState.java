package lld_algomaster.coffee_vending_machine.state;

import lld_algomaster.coffee_vending_machine.CoffeeVendingMachine;
import lld_algomaster.coffee_vending_machine.decorator.Coffee;

public class CoffeeSelectedState extends VendingMachineState {

    public CoffeeSelectedState(CoffeeVendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        System.out.println("Already selected. Please pay or cancel.");
    }

    @Override
    public void insertMoney(int amount) {
        vendingMachine.setMoneyInserted(vendingMachine.getMoneyInserted() + amount);
        System.out.println("Inserted " + amount + ". Total: " + vendingMachine.getMoneyInserted());
        if (vendingMachine.getMoneyInserted() >= vendingMachine.getSelectedCoffee().getPrice()) {
            vendingMachine.setState(new PaidState(vendingMachine));
        }
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please insert enough money first.");
    }

    @Override
    public void cancel() {
        System.out.println("Transaction cancelled. Refunding " + vendingMachine.getMoneyInserted());
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
