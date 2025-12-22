package lld.design_parking_lot.entity;

import lld.design_parking_lot.SpotType;
import lld.design_parking_lot.vehicle.Vehicle;
import lld.design_parking_lot.vehicle.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

public class Level {
    private final int levelNumber;
    private final List<ParkingSpot> spots;

    public Level(int levelNumber, List<ParkingSpot> spots) {
        this.levelNumber = levelNumber;
        this.spots = spots;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public List<ParkingSpot> getAvailableSpotsFor(Vehicle vehicle) {
        return spots.stream()
                .filter(ParkingSpot::isFree)
                .filter(s -> isCompatible(vehicle.getType(), s.getType()))
                .collect(Collectors.toList());
    }

    private boolean isCompatible(VehicleType vType, SpotType sType) {
        return switch (vType) {
            case BIKE -> sType == SpotType.BIKE;
            case CAR -> sType == SpotType.COMPACT || sType == SpotType.LARGE || sType == SpotType.HANDICAPPED;
            case TRUCK -> sType == SpotType.LARGE;
        };
    }
}