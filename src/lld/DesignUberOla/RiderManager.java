package lld.DesignUberOla;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    private Map<String, Rider> riders;

    private static RiderManager instance;
    private RiderManager() {
        // private constructor to prevent instantiation
        riders = new HashMap<>();
    }

    public static RiderManager getInstance() {
        if (instance == null) {
            synchronized (RiderManager.class) {
                if (instance == null) { // double-checked locking
                    instance = new RiderManager();
                }
            }
        }
        return instance;
    }

    public void addRider(Rider rider) {
        // logic to register a rider
        riders.put(rider.getName(), rider);
    }

    public Rider getRider(String riderId) {
        // logic to unregister a rider
        return riders.get(riderId);
    }

}
