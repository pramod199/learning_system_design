package machine_coding.uber.meeting_schedular;

import java.util.Set;

public class Booking {
    String bookingId;
    int roomId;
    Set<Integer> attendees;
    int start;
    int end;

    public Booking(String bookingId, int roomId, Set<Integer> attendees, int start, int end) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.attendees = attendees;
        this.start = start;
        this.end = end;
    }
}

