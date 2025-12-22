package lld.design_parking_lot.strategy;

import lld.design_parking_lot.ParkingLot;
import lld.design_parking_lot.vehicle.Vehicle;
import lld.design_parking_lot.entity.ParkingSpot;

public interface ParkingStrategy {
    ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle);
}