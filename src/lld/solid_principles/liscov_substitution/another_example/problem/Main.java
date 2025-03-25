package lld.solid_principles.liscov_substitution.another_example.problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new MotorCycle());
        vehicles.add(new Bicycle()); // this will throw null pointer exception as it is violating the liscov substitution principle

     for (Vehicle vehicle : vehicles) {
            System.out.println("Number of wheels: " + vehicle.getNumberOfWheels());
            System.out.println("Has engine: " + vehicle.hasEngine().toString()); // due to bicycle class, it will throw null pointer exception
        }
    }
}
