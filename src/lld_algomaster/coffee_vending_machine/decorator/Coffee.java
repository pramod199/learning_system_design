package lld_algomaster.coffee_vending_machine.decorator;

import lld_algomaster.coffee_vending_machine.enums.Ingredient;

import java.util.Map;

public abstract class Coffee {
    protected String coffeeType = "Unknown Coffee";

    public String getCoffeeType() {
        return coffeeType;
    }

    // the template method
    public void prepare() {
        System.out.println("\n Preparing your " + this.coffeeType + "...");
        grindBeans();
        brew();
        addCondiments(); // the hook for base coffee
        pourIntoCup();
        System.out.println(this.coffeeType + " is ready!");
    }


    // common steps
    private void grindBeans() {
        System.out.println("- Grinding fresh coffee beans.");
    }

    private void brew() {
        System.out.println("- Brewing coffee with hot water.");
    }

    private void pourIntoCup() {
        System.out.println("- Pouring into a cup.");
    }

    // Abstract step to be implemented by subclasses
    protected abstract void addCondiments();

    public abstract int getPrice();

    public abstract Map<Ingredient, Integer> getRecipe();


}
