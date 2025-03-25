package creational.factory.factory_method;

import creational.factory.Burger;
import creational.factory.PizzaBurger;

public class PizzaBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        return new PizzaBurger();
    }
}
