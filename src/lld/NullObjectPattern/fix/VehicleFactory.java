package lld.NullObjectPattern.fix;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {

        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        }

        return new NullVehicle(); // earlier return null;
    }
}
