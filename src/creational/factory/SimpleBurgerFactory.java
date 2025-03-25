package creational.factory;

public class SimpleBurgerFactory {
    /*
    this class is following single responsibility principle,
    however this class is still open for modification.
     */
    public Burger createBurger(String request) {
        Burger burger = null;
        if ("PIZZA".equals(request)) {
            burger = new PizzaBurger();
        } else if("AALU".equals(request)) {
            burger = new AlooPattyBurger();
        }
        return burger;
    }

}
