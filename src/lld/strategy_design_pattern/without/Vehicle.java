package lld.strategy_design_pattern.without;

/*
sports vehicle, off-road vehicle, passenger vehicle, goods vehicle

sports vehicle and off-road vehicle have the same drive capability different from base class vehicle, so code are duplicated.
 */
public class Vehicle {
    public void drive() {
        System.out.println("Normal drive capability");
    }
}
