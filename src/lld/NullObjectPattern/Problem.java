package lld.NullObjectPattern;

public class Problem {
    public static void main(String[] args) {

    }

    /*
     if vehicle is null then this will throw NPE.
     */
    public static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
    }

    // this has fixed the NPE issue, but in bigger project  having this null check everywhere across the code
    // is not a good practice. how to avoid it.

    public static void printVehicleDetailsFix(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
        }
    }


}
