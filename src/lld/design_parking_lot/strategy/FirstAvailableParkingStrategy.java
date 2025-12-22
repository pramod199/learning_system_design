package lld.design_parking_lot.strategy;

import lld.design_parking_lot.ParkingLot;
import lld.design_parking_lot.vehicle.Vehicle;
import lld.design_parking_lot.entity.Level;
import lld.design_parking_lot.entity.ParkingSpot;

import java.util.List;

public class FirstAvailableParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
        for (Level level : lot.getLevels()) {
            List<ParkingSpot> spots = level.getAvailableSpotsFor(vehicle);
            if (!spots.isEmpty()) {
                return spots.get(0);
            }
        }
        return null; // or throw exception
    }
}