package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.RentalStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class Rental {
    Long id;
    Vehicle vehicle;
    Customer customer;
    LocalDateTime startTime;
    LocalDateTime endTime;
    BigDecimal totalAmount;
    RentalStatus status;

    public Rental(Long id, Vehicle vehicle, Customer customer, LocalDateTime startTime, LocalDateTime endTime, BigDecimal totalAmount) {
        this.id = id;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalAmount = totalAmount;
        this.status = RentalStatus.ONGOING;
    }
}
