package lld.DesignUberOla;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // -----creating riders and drivers-----

        Rider rider1 = new Rider("Rider1", 5.0);
        Rider rider2 = new Rider("Rider2", 3.0);

        RiderManager riderManager = RiderManager.getInstance();
        riderManager.addRider(rider1);
        riderManager.addRider(rider2);

        Driver driver1 = new Driver("Driver1", 5.0);
        Driver driver2 = new Driver("Driver2", 4.0);
        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(driver1);
        driverManager.addDriver(driver2);

        TripManager tripManager = TripManager.getInstance();

        // -----creating trips-----
        Location srcLoc = new Location("12.9716", "77.5946");
        Location destLoc = new Location("12.2958", "76.6393");

        tripManager.createTrip(rider1, srcLoc, destLoc);

        tripManager.createTrip(rider2, srcLoc, destLoc);

        Map<String, Trip> tripsInfo = tripManager.getTripsInfo();
        for(Map.Entry<String, Trip> entry : tripsInfo.entrySet()) {
            Trip trip = entry.getValue();
            trip.displayTripDetails();
            System.out.println();
        }


    }
}
