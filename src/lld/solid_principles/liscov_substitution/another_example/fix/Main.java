package lld.solid_principles.liscov_substitution.another_example.fix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new MotorCycle());
        vehicles.add(new Car());
        vehicles.add(new Bicycle());

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getNumberOfWheels().toString()); // we can only call method which is available or visible at vehicle.
//            System.out.println(vehicle.hasEngine().toString()); // hasEngine is not available in Vehicle class, so it will throw error
        }

        List<EngineVehicle> engineVehicles = new ArrayList<>();
        engineVehicles.add(new MotorCycle());
        engineVehicles.add(new Car());
//        engineVehicles.add(new Bicycle()); // Bicycle is not an EngineVehicle, so it will throw error

    }

}
