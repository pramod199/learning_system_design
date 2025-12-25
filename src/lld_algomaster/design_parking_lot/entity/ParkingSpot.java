package lld_algomaster.design_parking_lot.entity;

import lld_algomaster.design_parking_lot.SpotType;
import lld_algomaster.design_parking_lot.vehicle.Vehicle;

public class ParkingSpot {
    private final String id;
    private final SpotType type;
    private boolean free;

    private Vehicle parkedVehicle;

    public ParkingSpot(String id, SpotType type) {
        this.id = id;
        this.type = type;
        this.free = true;
    }

    public boolean isFree() { return free; }
    public SpotType getType() { return type; }
    public String getId() { return id; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }

    public void park(Vehicle v) {
        if (!free) throw new IllegalStateException("Spot already occupied");
        this.parkedVehicle = v;
        this.free = false;
    }

    public void vacate() {
        this.parkedVehicle = null;
        this.free = true;
    }

    @Override
    public String toString() {
        return "Spot{" + id + ", type=" + type + ", free=" + free + "}";
    }
}
