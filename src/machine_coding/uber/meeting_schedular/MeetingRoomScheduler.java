package machine_coding.uber.meeting_schedular;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MeetingRoomScheduler {

    Map<Integer, Room> roomMap = new HashMap<>();
    Map<Integer, Employee> employeeMap = new HashMap<>();
    ConcurrentHashMap<String, Booking> bookingMap = new ConcurrentHashMap<>(); // booking id vs booking -useful during cancel.
    ConcurrentHashMap<Integer, Set<String>> bookingIdsByEmpMap = new ConcurrentHashMap<>(); // key is empId and value set<bookingId>

    // constructor


    public MeetingRoomScheduler(int roomCount, int employeeCount) {
        for (int i = 0; i < roomCount; i++) {
            roomMap.put(i, new Room(i));
        }

        for (int i = 0; i < employeeCount; i++) {
            employeeMap.put(i, new Employee(i));
        }
    }

    // book room
    public boolean bookRoom(String bookingId, Set<Integer> attendeeIds, int roomId, int start, int end) {
        if (start > end || start < 0) {
            return false;
        }

        Room room = roomMap.get(roomId);
        if (room == null) {
            return false;
        }

        // lock only that room
        room.lock.writeLock().lock();
        try {
            if (!room.calendar.canFit(start, end)) {
                return false;
            }

            Booking booking = new Booking(bookingId, roomId, attendeeIds, start, end);
            room.calendar.addBooking(booking);

            bookingMap.put(bookingId, booking);
            for (int empId : attendeeIds) {
                if (!bookingIdsByEmpMap.containsKey(empId)) {
                    bookingIdsByEmpMap.put(empId, new HashSet<>());
                }
                bookingIdsByEmpMap.get(empId).add(bookingId);
            }
            notifyAttendees(attendeeIds, "Booking confirmed: " + bookingId);
            return true;

        } finally {
            room.lock.writeLock().unlock();
        }
    }

    // ---------------- CANCEL ----------------
    public boolean cancelBooking(String bookingId) {
        Booking booking = bookingMap.get(bookingId);
        if (booking == null) {
            return false;
        }

        Room room = roomMap.get(booking.roomId);
        room.lock.writeLock().lock();
        try {
            // re-check after lock
            if (!bookingMap.containsKey(bookingId)) {
                return false;
            }

            room.calendar.removeBooking(booking.start);
            bookingMap.remove(bookingId);
            for (int emp : booking.attendees) {
                Set<String> bookingIdSet = bookingIdsByEmpMap.get(emp);
                bookingIdSet.remove(bookingId);
            }
            notifyAttendees(booking.attendees, "booking canceled: "+ bookingId);
            return true;

        } finally {
            room.lock.writeLock().unlock();
        }

    }

    /**
     * Reschedule an existing booking.
     */
    public boolean reschedule(int bookingId, int newStart, int newEnd) {
        Booking booking = bookingMap.get(bookingId);
        if (booking == null) {
            return false;
        }
        Room oldRoom = roomMap.get(booking.roomId);
        // temporary remove
        oldRoom.calendar.removeBooking(booking.start);

        // try same room
        if (oldRoom.calendar.canFit(newStart, newEnd)){
            booking.start = newStart;
            booking.end = newEnd;
            oldRoom.calendar.addBooking(booking);
            return true;
        }

//        try other room
        for (Room room : roomMap.values()) {
            if (room.roomId == booking.roomId){
                continue;
            }

            if(room.calendar.canFit(newStart, newEnd)) {
                booking.roomId = room.roomId;
                booking.start = newStart;
                booking.end = newEnd;

                room.calendar.addBooking(booking);
                return true;
            }
        }
        // rollback
        oldRoom.calendar.addBooking(booking);
        return false;
    }

    // ---------------- AVAILABILITY ----------------

    public List<Integer> getAvailableRooms(int start, int end) {

        if (start > end){
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();

        for (Room room : roomMap.values()) {
            room.lock.readLock().lock();
            try {
                if (room.calendar.canFit(start, end)) {
                    res.add(room.roomId);
                }
            } finally {
                room.lock.readLock().unlock();
            }
        }

        Collections.sort(res);
        return res;
    }

    // ---------------- LIST BY ROOM ----------------
    public List<String> listBookingsForRoom(int roomId) {
        Room room = roomMap.get(roomId);
        if (room == null) {
            return Collections.emptyList();
        }
        room.lock.readLock().lock();
        try {

            List<Booking> list =
                    new ArrayList<>(room.calendar.listBooking());

            list.sort(Comparator
                    .comparingInt((Booking b) -> b.start)
                    .thenComparing(b -> b.bookingId));

            List<String> res = new ArrayList<>();
            for (Booking b : list) {
                res.add(b.bookingId);
            }
            return res;

        } finally {
            room.lock.readLock().unlock();
        }
    }

    // ---------------- LIST BY EMPLOYEE ----------------

    public List<String> listBookingsForEmployee(int empId) {

        Set<String> ids =
                bookingIdsByEmpMap.getOrDefault(
                        empId,
                        Collections.emptySet());

        List<Booking> list = new ArrayList<>();

        for (String id : ids) {
            Booking b = bookingMap.get(id);
            if (b != null) list.add(b);
        }

        list.sort(Comparator
                .comparingInt((Booking b) -> b.start)
                .thenComparing(b -> b.bookingId));

        List<String> res = new ArrayList<>();
        for (Booking b : list) {
            res.add(b.bookingId);
        }

        return res;
    }

    // ---------------- Notify ----------------

    private void notifyAttendees(Set<Integer> ids,
                                 String msg) {

        for (int id : ids) {
            Employee e = employeeMap.get(id);
            if (e != null) {
                e.notify(msg);
            }
        }
    }

}
