package lld_algomaster.design_parking_lot.strategy;

import lld_algomaster.design_parking_lot.ParkingLot;
import lld_algomaster.design_parking_lot.vehicle.Vehicle;
import lld_algomaster.design_parking_lot.entity.ParkingSpot;

public interface ParkingStrategy {
    ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle);
}