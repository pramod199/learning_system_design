package machine_coding.wayfair_hotel_reservation;

import java.time.LocalDate;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        User user = new User(1L, "Alice");

        Hotel h1 = new Hotel(101L, "Bliss Hotel", "Bangalore");
        RoomType deluxe = new RoomType(201L, "Deluxe", 1000.0, h1);
        deluxe.setPrice(LocalDate.of(2024, 6, 10), 1200.0);
        deluxe.setPrice(LocalDate.of(2024, 6, 11), 1100.0);

        Room r1 = new Room(301L, "101", deluxe);
        bookingService.addRoom(r1);

        // Booking
        Booking b = bookingService.bookRoom(301L, user, LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 12));
        System.out.println("Booked Room ID: " + b.room.id + ", Total Price: " + b.totalPrice);

        // Search
        List<Room> available = bookingService.searchRooms("Bangalore", LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 13), 500, 1500);
        System.out.println("Available rooms on 12th June: " + available.size());
    }
}

