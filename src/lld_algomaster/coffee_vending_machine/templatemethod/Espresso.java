package lld_algomaster.coffee_vending_machine.templatemethod;

import lld_algomaster.coffee_vending_machine.decorator.Coffee;
import lld_algomaster.coffee_vending_machine.enums.CoffeeType;
import lld_algomaster.coffee_vending_machine.enums.Ingredient;

import java.util.Map;

public class Espresso extends Coffee {
    public Espresso() {
        this.coffeeType = CoffeeType.ESPRESSO.name();
    }

    @Override
    protected void addCondiments() { /* No extra condiments for espresso */ }

    @Override
    public int getPrice() {
        return 150;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.WATER, 30);
    }
}