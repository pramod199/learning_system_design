package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.HumanSize;
import machine_coding.wayfair_bike_rental_shop.enums.VehicleStatus;
import machine_coding.wayfair_bike_rental_shop.pricing_strategy.PricingStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class RentalService {
    private final PricingStrategy pricingStrategy;

    public RentalService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public Long addVehicle(Vehicle vehicle) {

        InMemoryDB.vehicleMap.put(vehicle.id, vehicle);
        return vehicle.id;
    }

    public Long addCustomer(String name, String phone, HumanSize size) {
        Customer customer = new Customer(InMemoryDB.customerIdCounter++, name, phone, size);
        InMemoryDB.customerMap.put(customer.id, customer);
        return customer.id;
    }

    public Long rentVehicle(Long customerId, Long vehicleId, LocalDateTime start, LocalDateTime end) {
        Vehicle vehicle = InMemoryDB.vehicleMap.get(vehicleId);
        if (vehicle == null || (vehicle.status != VehicleStatus.AVAILABLE && vehicle.status != VehicleStatus.RESERVED)){
            throw new RuntimeException("Vehicle not available");
        }
        Customer customer = InMemoryDB.customerMap.get(customerId);
        if (vehicle instanceof Bike && ((Bike) vehicle).size != customer.size){
            throw new RuntimeException("Size mismatch");
        }

        BigDecimal amount = pricingStrategy.calculatePrice(vehicle, start, end);
        Rental rental = new Rental(InMemoryDB.rentalIdCounter++, vehicle, customer, start, end, amount);
        InMemoryDB.rentalMap.put(rental.id, rental);

        vehicle.status = VehicleStatus.RENTED;
        return rental.id;
    }

    public Long reserveVehicle(Long customerId, Long vehicleId, LocalDateTime start, LocalDateTime end) {
        Vehicle vehicle = InMemoryDB.vehicleMap.get(vehicleId);
        if (vehicle == null || vehicle.status != VehicleStatus.AVAILABLE){
            throw new RuntimeException("Vehicle not available");
        }
        Customer customer = InMemoryDB.customerMap.get(customerId);

        Reservation reservation = new Reservation(InMemoryDB.reservationIdCounter++, vehicle, customer, LocalDateTime.now(), start, end);
        InMemoryDB.reservationMap.put(reservation.id, reservation);

        vehicle.status = VehicleStatus.RESERVED;
        return reservation.id;
    }

}
