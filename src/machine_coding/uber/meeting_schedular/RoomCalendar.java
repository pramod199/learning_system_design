package machine_coding.uber.meeting_schedular;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class RoomCalendar {
    TreeMap<Integer, Booking> bookings = new TreeMap<>(); // startTime vs booking

    boolean canFit(int start, int end) {
        Map.Entry<Integer, Booking> prev = bookings.floorEntry(start);
        if (prev != null && prev.getValue().end >= start){
            return false;
        }
        Map.Entry<Integer, Booking> next = bookings.ceilingEntry(start);
        if (next != null && next.getValue().start <= end) {
            return false;
        }
        return true;
    }

    void  addBooking(Booking b){
        bookings.put(b.start, b);
    }

    void removeBooking(int start) {
        bookings.remove(start);
    }

    Collection<Booking> listBooking(){
        return  bookings.values();
    }
}
