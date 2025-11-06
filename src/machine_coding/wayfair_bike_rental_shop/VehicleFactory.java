package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.HumanSize;
import machine_coding.wayfair_bike_rental_shop.enums.ScooterStyle;


public class VehicleFactory {
    public static Vehicle createBike(Long id, HumanSize size, String brand, Shop shop) {
        return new Bike(id, size, brand, shop);
    }
    public static Vehicle createScooter(Long id, ScooterStyle style, String brand, Shop shop) {
        return new Scooter(id, style, brand, shop);
    }

}
