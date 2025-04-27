package lld.DesignUberOla;

import java.util.HashMap;
import java.util.Map;

public class TripManager {
    Map<String, Trip> tripsInfo;
    Map<String, TripMetadata> tripsMetadataInfo;

    RiderManager riderManager;
    DriverManager driverManager;
    private static TripManager instance;

    private TripManager() {
        // private constructor to prevent instantiation
        tripsInfo = new HashMap<>();
        tripsMetadataInfo = new HashMap<>();
        riderManager = RiderManager.getInstance();
        driverManager = DriverManager.getInstance();
    }

    public static TripManager getInstance() {
        if (instance == null) {
            synchronized (TripManager.class) {
                if (instance == null) { // double-checked locking
                    instance = new TripManager();
                }
            }
        }
        return instance;
    }

    public Map<String, Trip> getTripsInfo() {
        return tripsInfo;
    }

    void createTrip(Rider rider, Location srcLoc, Location destLoc) {
        TripMetadata tripMetadata = new TripMetadata( srcLoc, destLoc, rider.getRating());
        StrategyMgr strategyMgr = StrategyMgr.getInstance();
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineDriverMatchingStrategy(tripMetadata);
        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(tripMetadata);

        Driver driver = driverMatchingStrategy.matchDriver(tripMetadata);
        double tripPrice = pricingStrategy.calculatePrice(tripMetadata);

        Trip trip = new Trip(rider, driver, srcLoc, destLoc, pricingStrategy, driverMatchingStrategy, tripPrice);
        tripsInfo.put(trip.getTripId(), trip);
        tripsMetadataInfo.put(trip.getTripId(), tripMetadata);
    }

}
