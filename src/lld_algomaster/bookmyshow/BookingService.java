package lld_algomaster.bookmyshow;

import lld_algomaster.bookmyshow.entities.*;
import lld_algomaster.bookmyshow.enums.BookingStatus;
import lld_algomaster.bookmyshow.enums.PaymentStatus;
import lld_algomaster.bookmyshow.enums.ShowSeatStatus;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private final SeatLockService seatLockService;

    public BookingService(SeatLockService seatLockService) {
        this.seatLockService = seatLockService;
    }

    public Booking createBooking(User user, Show show, List<ShowSeat> seats) {
        // 1. Lock the seats
        try {
            seatLockService.lockSeats(show, seats, user);
        } catch (Exception e) {
            System.out.println("unable to lock seat");
            return null;
        }

        double totalAmount = show.getPricingStrategy().calculatePrice(seats);

        Booking booking = new Booking(UUID.randomUUID().toString(), user, show, seats, totalAmount);
        System.out.println("Created booking: " + booking);
        return booking;
    }

    public void confirmBooking(Booking booking, Payment payment) {
        if (payment.getStatus() != PaymentStatus.SUCCESS) {
            booking.setStatus(BookingStatus.CANCELED);
            System.out.println("Booking " + booking.getId() + " cancelled due to payment failure.");
            return;
        }

        booking.setPayment(payment);
        booking.setStatus(BookingStatus.CONFIRMED);
        for (ShowSeat seat : booking.getShowSeats()) {
            seat.setStatus(ShowSeatStatus.BOOKED);
        }
        System.out.println("Booking confirmed: " + booking);
    }

}
