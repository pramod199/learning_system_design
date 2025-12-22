package lld.design_parking_lot;

import lld.design_parking_lot.entity.Level;
import lld.design_parking_lot.entity.ParkingSpot;
import lld.design_parking_lot.entity.Ticket;
import lld.design_parking_lot.strategy.FirstAvailableParkingStrategy;
import lld.design_parking_lot.strategy.SimpleHourlyPricingStrategy;
import lld.design_parking_lot.vehicle.Car;
import lld.design_parking_lot.vehicle.Vehicle;

import java.util.List;

public class ParkingLotDemo {
    public static void main(String[] args) throws InterruptedException {
        // Setup parking lot (Singleton)
        ParkingLot lot = ParkingLot.getInstance();

        // Level 0 with 3 spots
        List<ParkingSpot> level0Spots = List.of(
            new ParkingSpot("L0-S1", SpotType.COMPACT),
            new ParkingSpot("L0-S2", SpotType.LARGE),
            new ParkingSpot("L0-S3", SpotType.BIKE)
        );
        Level level0 = new Level(0, level0Spots);
        lot.addLevel(level0);

        // Strategies
        lot.setPricingStrategy(new SimpleHourlyPricingStrategy(50.0)); // ₹50 per hour
        lot.setParkingStrategy(new FirstAvailableParkingStrategy());

        // Vehicle arrives (ENTRY)
        Vehicle car = new Car("KA01AB1234");
        Ticket ticket = lot.parkVehicle(car);
        System.out.println("Ticket issued: " + ticket.getTicketId()
                + ", Spot: " + ticket.getSpot().getId());

        // Simulate parking time
        Thread.sleep(2000); // 2 seconds, still rounds to 1 hour

        // EXIT with UPI payment
        PaymentMethod payment = new UpiPayment(); // this is the payment STRATEGY
        double fee = lot.exitVehicle(ticket.getTicketId(), payment);

        System.out.println("Total fee charged: " + fee);
    }
}
