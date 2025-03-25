package creational.factory;

public class PizzaBurger extends Burger {
    @Override
    public void prepare() {
        System.out.println("pizza burger is being prepared");
        return;
    }
}
