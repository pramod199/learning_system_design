package lld.design_zoom_car;


import lld.design_zoom_car.product.Vehicle;

import java.util.Date;

public class Reservation {
    String reservationId;
    String userId;
    String vehicleId;
    Date bookingDate;
    Date bookedFrom;
    Date bookedTo;
    String pickupLocation;
    String dropLocation;
    ReservationStatus status;
    ReservationType reservationType;

    public Reservation() {

    }

    public Reservation(String reservationId, String userId, String vehicleId, Date bookingDate,
                       Date bookedFrom, Date bookedTo, String pickupLocation, String dropLocation,
                       ReservationStatus status, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.bookingDate = bookingDate;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = status;
        this.reservationType = reservationType;
    }

    public String createReserve(User user, Vehicle vehicle){

        //generate new id
        this.reservationId = "12232";
        this.userId=user.userId;
        this.vehicleId = vehicle.getVehicleId();
        reservationType = ReservationType.DAILY;
        status = ReservationStatus.SCHEDULED;

        return reservationId;
    }

    // crud operations

}
