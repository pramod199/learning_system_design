package lld.solid_principles.liscov_substitution;

public class Bicycle implements Bike {

    @Override
    public void turnOnEngine() {
        throw new UnsupportedOperationException("Bicycle does not have engine"); // this has changed behaviour, it violates Liskov Substitution Principle
    }

    @Override
    public void accelerate() {

    }
}
