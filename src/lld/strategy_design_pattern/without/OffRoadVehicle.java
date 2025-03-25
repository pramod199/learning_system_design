package lld.strategy_design_pattern.without;

public class OffRoadVehicle extends Vehicle {
    @Override
    public void drive() {
        // different drive logic - same as sports vehicle
        System.out.println("Sports drive capability");
    }
}
