package lld_algomaster.design_parking_lot.strategy;

import lld_algomaster.design_parking_lot.ParkingLot;
import lld_algomaster.design_parking_lot.entity.ParkingFloor;
import lld_algomaster.design_parking_lot.vehicle.Vehicle;
import lld_algomaster.design_parking_lot.entity.ParkingSpot;

import java.util.List;

public class FirstAvailableParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
        for (ParkingFloor parkingFloor : lot.getFloors()) {
            List<ParkingSpot> spots = parkingFloor.getAvailableSpotsFor(vehicle);
            if (!spots.isEmpty()) {
                return spots.get(0);
            }
        }
        return null; // or throw exception
    }
}