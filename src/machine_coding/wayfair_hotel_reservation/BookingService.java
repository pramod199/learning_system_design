package machine_coding.wayfair_hotel_reservation;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

class User {
    Long id;
    String name;
    public User(Long id, String name) { this.id = id; this.name = name; }
}

class Hotel {
    Long id;
    String name;
    String location;
    public Hotel(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}

class RoomType {
    Long id;
    String name;
    double defaultPrice;
    Hotel hotel;
    Map<LocalDate, Double> dateToPrice = new HashMap<>();

    public RoomType(Long id, String name, double defaultPrice, Hotel hotel) {
        this.id = id;
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.hotel = hotel;
    }

    public double getPriceForDate(LocalDate date) {
        return dateToPrice.getOrDefault(date, defaultPrice);
    }

    public void setPrice(LocalDate date, double price) {
        dateToPrice.put(date, price);
    }
}

class Room {
    Long id;
    String roomNumber;
    RoomType roomType;

    public Room(Long id, String roomNumber, RoomType roomType) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public Hotel getHotel() {
        return roomType.hotel;
    }
}

class Booking {
    Long id;
    Room room;
    User customer;
    LocalDate checkIn;
    LocalDate checkOut;
    double totalPrice;

    public Booking(Long id, Room room, User customer, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
        this.id = id;
        this.room = room;
        this.customer = customer;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }
}

class BookingService {
    private final Map<Long, Room> rooms = new HashMap<>();
    private final Map<Long, List<Booking>> roomBookings = new HashMap<>();
    private final AtomicLong bookingIdGenerator = new AtomicLong(1);

    public void addRoom(Room room) {
        rooms.put(room.id, room);
        roomBookings.put(room.id, new ArrayList<>());
    }

    public synchronized Booking bookRoom(Long roomId, User customer, LocalDate checkIn, LocalDate checkOut) {
        Room room = rooms.get(roomId);
        if (room == null) throw new RuntimeException("Room not found");

        for (Booking booking : roomBookings.get(roomId)) {
            if (!(checkOut.isBefore(booking.checkIn) || checkIn.isAfter(booking.checkOut.minusDays(1)))) {
                throw new RuntimeException("Room already booked in this period.");
            }
        }

        double totalPrice = 0.0;
        LocalDate date = checkIn;
        while (!date.isEqual(checkOut)) {
            totalPrice += room.roomType.getPriceForDate(date);
            date = date.plusDays(1);
        }

        Booking booking = new Booking(bookingIdGenerator.getAndIncrement(), room, customer, checkIn, checkOut, totalPrice);
        roomBookings.get(roomId).add(booking);
        return booking;
    }

    public List<Booking> getBookings(Long roomId) {
        return roomBookings.get(roomId);
    }

    public List<Room> searchRooms(String location, LocalDate checkIn, LocalDate checkOut, double minPrice, double maxPrice) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            Hotel hotel = room.getHotel();
            if (!hotel.location.equalsIgnoreCase(location)) continue;

            boolean isAvailable = true;
            for (Booking booking : roomBookings.get(room.id)) {
                if (!(checkOut.isBefore(booking.checkIn) || checkIn.isAfter(booking.checkOut.minusDays(1)))) {
                    isAvailable = false;
                    break;
                }
            }

            if (!isAvailable) continue;

            double totalPrice = 0;
            LocalDate date = checkIn;
            while (!date.isEqual(checkOut)) {
                double price = room.roomType.getPriceForDate(date);
                if (price < minPrice || price > maxPrice) {
                    totalPrice = -1;
                    break;
                }
                totalPrice += price;
                date = date.plusDays(1);
            }

            if (totalPrice != -1) availableRooms.add(room);
        }
        return availableRooms;
    }
}
