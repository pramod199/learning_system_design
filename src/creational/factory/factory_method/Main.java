package creational.factory.factory_method;

import creational.factory.Burger;

public class Main {
    public static void main(String[] args) {
        Restaurant pizzaBurgerRestaurant = new PizzaBurgerRestaurant();
        Burger burger = pizzaBurgerRestaurant.createBurger();

        Restaurant aaluBurgerRestaurant = new AaluBurgerRestaurant();
        Burger burger1 = aaluBurgerRestaurant.createBurger();
    }
}
