package lld_algomaster.coffee_vending_machine.factory;

import lld_algomaster.coffee_vending_machine.decorator.Coffee;
import lld_algomaster.coffee_vending_machine.enums.CoffeeType;
import lld_algomaster.coffee_vending_machine.templatemethod.Cappuccino;
import lld_algomaster.coffee_vending_machine.templatemethod.Espresso;
import lld_algomaster.coffee_vending_machine.templatemethod.Latte;

public class CoffeeFactory {

    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO:
                return new Espresso();
            case LATTE:
                return new Latte();
            case CAPPUCCINO:
                return new Cappuccino();
            default:
                throw new IllegalArgumentException("Unsupported coffee type: " + type);
        }
    }
}
