package lld.design_zoom_car;

import lld.design_zoom_car.product.Vehicle;
import lld.design_zoom_car.product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int id;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicleInventoryManagement.getVehicles();
    }

    //addVehicles, update vehicles, use inventory management to update those.

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(String reservationID) {

        //take out the reservation from the list and call complete the reservation method.
        return true;
    }

    //update reservation





}
