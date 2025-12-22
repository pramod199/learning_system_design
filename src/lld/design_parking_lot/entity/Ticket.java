package lld.design_parking_lot.entity;

import lld.design_parking_lot.vehicle.Vehicle;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimeMillis;
    private Long exitTimeMillis;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot, long entryTimeMillis) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimeMillis = entryTimeMillis;
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public long getEntryTimeMillis() { return entryTimeMillis; }
    public Long getExitTimeMillis() { return exitTimeMillis; }

    public void markExit(long exitTimeMillis) {
        this.exitTimeMillis = exitTimeMillis;
    }
}
