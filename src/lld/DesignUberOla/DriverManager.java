package lld.DesignUberOla;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private Map<String, Driver> drivers;
    private static DriverManager instance;
    private DriverManager() {
        // private constructor to prevent instantiation
        drivers = new HashMap<>();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) { // double-checked locking
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getName(), driver);
    }

    public Driver getDriver(String driverId) {
        return drivers.get(driverId);
    }

    public Map<String, Driver> getDrivers() {
        return drivers;
    }
}
