package lld_algomaster.coffee_vending_machine;

import lld_algomaster.coffee_vending_machine.decorator.CaramelSyrupDecorator;
import lld_algomaster.coffee_vending_machine.decorator.Coffee;
import lld_algomaster.coffee_vending_machine.decorator.ExtraSugarDecorator;
import lld_algomaster.coffee_vending_machine.enums.CoffeeType;
import lld_algomaster.coffee_vending_machine.enums.ToppingType;
import lld_algomaster.coffee_vending_machine.factory.CoffeeFactory;
import lld_algomaster.coffee_vending_machine.state.IdleState;
import lld_algomaster.coffee_vending_machine.state.VendingMachineState;

import java.util.List;

public class CoffeeVendingMachine {
    private static final CoffeeVendingMachine INSTANCE = new CoffeeVendingMachine();
    private VendingMachineState state;
    private Coffee selectedCoffee;
    private int moneyInserted;

    public CoffeeVendingMachine() {
        this.state = new IdleState(this);
        this.moneyInserted = 0;
    }

    public static CoffeeVendingMachine getInstance() {
        return INSTANCE;
    }

    // --- Actions delegated to the current state ---
    public void selectCoffee(CoffeeType type, List<ToppingType> toppings) {
        // 1. Create the base coffee using the factory
        Coffee coffee = CoffeeFactory.createCoffee(type);

        // 2. Wrap it with decorators
        for (ToppingType topping : toppings) {
            switch (topping) {
                case EXTRA_SUGAR:
                    coffee = new ExtraSugarDecorator(coffee);
                    break;
                case CARAMEL_SYRUP:
                    coffee = new CaramelSyrupDecorator(coffee);
                    break;
            }
        }
        // Let the state handle the rest
        this.state.selectCoffee(coffee);
    }

    public void insertMoney(int amount) {
        state.insertMoney(amount);
    }

    public void dispenseCoffee() {
        state.dispenseCoffee();
    }

    public void cancel() {
        state.cancel();
    }

    // --- Getters and Setters used by State objects ---
    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setSelectedCoffee(Coffee selectedCoffee) {
        this.selectedCoffee = selectedCoffee;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    public int getMoneyInserted() {
        return moneyInserted;
    }

    public void reset() {
        this.selectedCoffee = null;
        this.moneyInserted = 0;
    }
}
