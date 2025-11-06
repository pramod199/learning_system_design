package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.HumanSize;
import machine_coding.wayfair_bike_rental_shop.enums.ScooterStyle;
import machine_coding.wayfair_bike_rental_shop.enums.VehicleType;
import machine_coding.wayfair_bike_rental_shop.pricing_strategy.DailyPricingStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BikeRentalDemo {
    public static void main(String[] args) {
        Shop shop = new Shop(1L, "Gojek Wheels", "Bangalore");

        // Pricing setup
        Map<VehicleType, BigDecimal> rateMap = new HashMap<>();
        rateMap.put(VehicleType.BIKE, new BigDecimal("100"));
        rateMap.put(VehicleType.SCOOTER, new BigDecimal("150"));
        rateMap.put(VehicleType.CAR, new BigDecimal("300"));

        RentalService rentalService = new RentalService(new DailyPricingStrategy(rateMap));

        // Add vehicles
        Vehicle bike = VehicleFactory.createBike( InMemoryDB.vehicleIdCounter++, HumanSize.MEDIUM, "Hero", shop);
        Long bikeId = rentalService.addVehicle(bike);

        Vehicle scooter = VehicleFactory.createScooter(InMemoryDB.vehicleIdCounter++, ScooterStyle.ELECTRIC, "Honda", shop);
        Long scooterId = rentalService.addVehicle(scooter);

        // Add customer
        Long custId = rentalService.addCustomer("Pramod", "9999999999", HumanSize.MEDIUM);

        // Reserve vehicle
        LocalDateTime start = LocalDateTime.now().plusDays(1);
        LocalDateTime end = start.plusDays(2);
        Long reservationId = rentalService.reserveVehicle(custId, bikeId, start, end);

        System.out.println("Reservation successful! Reservation ID: " + reservationId);

        Long rentalId = rentalService.rentVehicle(custId, bikeId, start, end);
        System.out.println("Rental successful! Rental ID: " + rentalId);
    }
}
