package lld.DesignUberOla;

import java.util.UUID;

// main class.
public class Trip {
    Rider rider;
    Driver driver;
    Location srcLoc;
    Location destLoc;
    TRIP_STATUS status;
    String tripId;
    double price;
    PricingStrategy pricingStrategy;
    DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Rider rider, Driver driver, Location srcLoc, Location destLoc,
                PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy, Double price) {
        this.rider = rider;
        this.driver = driver;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.tripId = generateTripId();
        this.price = price;
    }

    private String generateTripId() {
        return UUID.randomUUID().toString();
    }

    public void displayTripDetails() {
        System.out.print("Trip ID: " + tripId);
        System.out.print(", Rider: " + rider.getName());
        System.out.print(", Driver: " + driver.getName());
        System.out.print(", Source: " + srcLoc.getLatitude() + ", " + srcLoc.getLongitude());
        System.out.print(", Destination: " + destLoc.getLatitude() + ", " + destLoc.getLongitude());
        System.out.print(", Status: " + status);
        System.out.print(", Price: " + price);
    }

    public String getTripId() {
        return tripId;
    }
}
