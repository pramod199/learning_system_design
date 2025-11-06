package machine_coding.wayfair_bike_rental_shop;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
    static Map<Long, Vehicle> vehicleMap = new HashMap<>();
    static Map<Long, Customer> customerMap = new HashMap<>();
    static Map<Long, Rental> rentalMap = new HashMap<>();
    static Map<Long, Reservation> reservationMap = new HashMap<>();
    static Long vehicleIdCounter = 1L;
    static Long customerIdCounter = 1L;
    static Long rentalIdCounter = 1L;
    static Long reservationIdCounter = 1L;
}
