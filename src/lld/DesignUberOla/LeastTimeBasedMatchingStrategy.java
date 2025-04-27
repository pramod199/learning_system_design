package lld.DesignUberOla;

import java.util.Map;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(TripMetadata tripMetadata) {
        DriverManager driverManager = DriverManager.getInstance();
        Map<String, Driver> drivers = driverManager.getDrivers();

        if (drivers.isEmpty()) {
            System.out.println("No drivers available");
            return null;
        }
        System.out.println("using quadtree to find the nearest driver");
        Driver driver1 = drivers.get("Driver1");
        tripMetadata.setDriverRating(driver1.getRating());
        return driver1;
    }
}
