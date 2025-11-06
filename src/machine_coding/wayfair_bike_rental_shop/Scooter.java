package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.ScooterStyle;
import machine_coding.wayfair_bike_rental_shop.enums.VehicleType;

class Scooter extends Vehicle {
    ScooterStyle style;
    String brand;

    public Scooter(Long id, ScooterStyle style, String brand, Shop shop) {
        super(id, VehicleType.SCOOTER, shop);
        this.style = style;
        this.brand = brand;
    }
}
