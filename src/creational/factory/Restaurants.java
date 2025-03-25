package creational.factory;

// client
public class Restaurants {

    /*
     Problem: when things change we have to open this code and modify - which violates open closed principle.
     Also we will endup writing same piece of code at several places.
     */
/*    public Burger orderBurger(String request) {
        Burger burger = null;
        if ("PIZZA".equals(request)) {
            burger = new PizzaBurger();
        } else if("AALU".equals(request)) {
            burger = new AlooPattyBurger();
        }
        burger.prepare();
        return burger;
    }*/

    public Burger orderBurger(String request) {
        SimpleBurgerFactory factory = new SimpleBurgerFactory();
        Burger burger = factory.createBurger(request);
        burger.prepare();
        return burger;
    }

}
