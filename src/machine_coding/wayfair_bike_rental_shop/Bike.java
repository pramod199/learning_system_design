package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.HumanSize;
import machine_coding.wayfair_bike_rental_shop.enums.VehicleType;

class Bike extends Vehicle {
    HumanSize size;
    String brand;

    public Bike(Long id, HumanSize size, String brand, Shop shop) {
        super(id, VehicleType.BIKE, shop);
        this.size = size;
        this.brand = brand;
    }
}
