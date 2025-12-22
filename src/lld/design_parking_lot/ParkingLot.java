package lld.design_parking_lot;

import lld.design_parking_lot.entity.Level;
import lld.design_parking_lot.entity.ParkingSpot;
import lld.design_parking_lot.entity.Ticket;
import lld.design_parking_lot.strategy.ParkingStrategy;
import lld.design_parking_lot.strategy.PricingStrategy;
import lld.design_parking_lot.vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private static volatile ParkingLot instance;

    private final List<Level> levels = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    private PricingStrategy pricingStrategy;
    private ParkingStrategy parkingStrategy;

    private ParkingLot() {}

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public List<Level> getLevels() { return levels; }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    // ENTRY
    public Ticket parkVehicle(Vehicle vehicle) {
        if (parkingStrategy == null) {
            throw new IllegalStateException("Parking strategy not set");
        }
        ParkingSpot spot = parkingStrategy.findSpot(this, vehicle);
        if (spot == null) {
            throw new RuntimeException("No available spot for vehicle " + vehicle.getLicensePlate());
        }
        spot.park(vehicle);
        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, spot, System.currentTimeMillis());
        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    // EXIT
    public double exitVehicle(String ticketId, PaymentMethod paymentMethod) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket");

        ticket.markExit(System.currentTimeMillis());
        if (pricingStrategy == null) {
            throw new IllegalStateException("Pricing strategy not set");
        }

        double fee = pricingStrategy.calculateFee(ticket);
        boolean success = paymentMethod.pay(fee);
        if (success) {
            ticket.getSpot().vacate();
            activeTickets.remove(ticketId);
        } else {
            System.out.println("Payment failed!");
        }
        return fee;
    }
}
