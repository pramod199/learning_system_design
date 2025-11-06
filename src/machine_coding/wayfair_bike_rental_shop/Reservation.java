package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.ReservationStatus;

import java.time.LocalDateTime;

class Reservation {
    Long id;
    Vehicle vehicle;
    Customer customer;
    LocalDateTime reservationTime;
    LocalDateTime startTime;
    LocalDateTime endTime;
    ReservationStatus status;

    public Reservation(Long id, Vehicle vehicle, Customer customer, LocalDateTime reservationTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.customer = customer;
        this.reservationTime = reservationTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = ReservationStatus.ACTIVE;
    }
}
