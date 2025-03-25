package lld.decorator_design_pattern;

import lld.decorator_design_pattern.decorator.ExtraCheeseDecorator;
import lld.decorator_design_pattern.decorator.MushroomDecorator;

public class PizzaShop {
    public static void main(String[] args) {
        // margherita + extra cheese

        BasePizza margherita = new Margherita();

         BasePizza margheritaWithCheese = new ExtraCheeseDecorator(margherita);

         BasePizza pizza = new MushroomDecorator(margheritaWithCheese);

        System.out.println(pizza.cost());

    }
}
