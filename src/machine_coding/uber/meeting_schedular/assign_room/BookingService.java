package machine_coding.uber.meeting_schedular.assign_room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookingService {
    TreeMap<String, Room> rooms = new TreeMap<>(); // to ensure lexicographically assignment of room
    Map<String, Booking> bookings = new HashMap<>(); // need for cancellation, global booking lookup, bookingId vs booking

    public BookingService(List<String> roomIds) {
        for (String roomId : roomIds) {
            rooms.put(roomId, new Room(roomId));
        }
    }

    String bookMeeting(String meetingId, int start, int end) {
        if (start < 0 || start >= end) {
            System.out.println("invalid time range");
            return null;
        }

        for (Room room : rooms.values()) {
            // acquire WRITE lock because availability + add must be atomic
            room.lock.writeLock().lock();
            try {
                if (room.calendar.canFit(start, end)) {

                    Booking booking = new Booking(meetingId, room.roomId, start, end);
                    room.calendar.addBooking(booking);
                    bookings.put(meetingId, booking);

                    System.out.println(
                            "Booked room " + room.roomId +
                                    " for booking " + meetingId);

                    return room.roomId;
                }
            } finally {
                room.lock.writeLock().unlock();
            }
        }

        System.out.println("No room available");
        return null;
    }

    boolean cancelMeeting(String meetingId) {
        Booking event = bookings.get(meetingId);
        if (event == null) {
            System.out.println("booking not found");
            return false;
        }

        Room room = rooms.get(event.roomId);

        room.lock.writeLock().lock();
        try {
            room.calendar.removeBooking(event.start);
            bookings.remove(meetingId);

            System.out.println("Cancelled event " + meetingId);
            return true;
        } finally {
            room.lock.writeLock().unlock();
        }
    }

    // for reschedule check MeetingRoomScheduler. same logic



}
