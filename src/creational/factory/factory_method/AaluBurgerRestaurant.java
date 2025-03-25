package creational.factory.factory_method;

import creational.factory.AlooPattyBurger;
import creational.factory.Burger;

public class AaluBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new AlooPattyBurger();
    }
}
