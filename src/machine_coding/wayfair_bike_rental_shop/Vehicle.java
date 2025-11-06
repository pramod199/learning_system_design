package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.VehicleStatus;
import machine_coding.wayfair_bike_rental_shop.enums.VehicleType;

public abstract class Vehicle {
    Long id;
    public VehicleType type;
    VehicleStatus status;
    Shop shop;

    public Vehicle(Long id, VehicleType type, Shop shop) {
        this.id = id;
        this.type = type;
        this.status = VehicleStatus.AVAILABLE;
        this.shop = shop;
    }
}
