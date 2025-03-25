package creational.factory.factory_method;

import creational.factory.Burger;

// abstract the restaurant class.
public abstract class Restaurant {

    public Burger orderBurger() { // notice: this method is no longer dependent on request object.
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger(); // this is factory method.

    /*
    when to use creational.factory method:
    1. Use it if you have no idea of the exact type of object your code will work with.
    2. it make easy to extend the product construction code independently from the rest of application
    3. allows introducing new product without breaking existing code.
    4. Centralize the product creation code in one place in the program.
     */
}
