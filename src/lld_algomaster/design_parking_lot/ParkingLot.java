package lld_algomaster.design_parking_lot;

import lld_algomaster.design_parking_lot.entity.ParkingFloor;
import lld_algomaster.design_parking_lot.entity.ParkingSpot;
import lld_algomaster.design_parking_lot.entity.Ticket;
import lld_algomaster.design_parking_lot.factory.PaymentMethod;
import lld_algomaster.design_parking_lot.strategy.FirstAvailableParkingStrategy;
import lld_algomaster.design_parking_lot.strategy.ParkingStrategy;
import lld_algomaster.design_parking_lot.strategy.PricingStrategy;
import lld_algomaster.design_parking_lot.strategy.SimpleHourlyPricingStrategy;
import lld_algomaster.design_parking_lot.vehicle.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static volatile ParkingLot instance;

    private final List<ParkingFloor> parkingFloors = new ArrayList<>();
    private final Map<String, Ticket> activeTickets;

    private PricingStrategy pricingStrategy;
    private ParkingStrategy parkingStrategy;

    private ParkingLot() {
        this.pricingStrategy = new SimpleHourlyPricingStrategy(30.0);
        this.parkingStrategy = new FirstAvailableParkingStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
    }

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

    public void addFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public List<ParkingFloor> getFloors() { return parkingFloors; }

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
