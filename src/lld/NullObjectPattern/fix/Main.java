package lld.NullObjectPattern.fix;


public class Main {
    public static void main(String[] args) {
        Vehicle vehicle =  VehicleFactory.getVehicle("Car");
        printVehicleDetails(vehicle);

        Vehicle bike = VehicleFactory.getVehicle("Bike");
        printVehicleDetails(bike);

    }

    public static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
    }
}
