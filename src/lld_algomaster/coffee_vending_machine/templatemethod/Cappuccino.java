package lld_algomaster.coffee_vending_machine.templatemethod;

import lld_algomaster.coffee_vending_machine.decorator.Coffee;
import lld_algomaster.coffee_vending_machine.enums.CoffeeType;
import lld_algomaster.coffee_vending_machine.enums.Ingredient;

import java.util.Map;

public class Cappuccino extends Coffee {
    public Cappuccino() {
        this.coffeeType = CoffeeType.CAPPUCCINO.name();
    }

    @Override
    protected void addCondiments() {
        System.out.println("- Adding steamed milk and foam.");
    }

    @Override
    public int getPrice() {
        return 250;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(
                Ingredient.COFFEE_BEANS, 7,
                Ingredient.WATER, 30,
                Ingredient.MILK, 100
        );
    }
}