package machine_coding.uber.meeting_schedular;

import java.util.Set;
/*
https://codezym.com/question/44
https://codezym.com/question/45
https://codezym.com/question/29

https://chatgpt.com/share/6981e24c-19e4-8008-bf34-7a58656334d9
https://leetcode.com/discuss/post/5016546/low-level-design-for-meeting-room-by-dun-1cy6/
 */
public class MeetingSchedulerDemo {
    public static void main(String[] args) {
        // 3 rooms: 0,1,2
        // 5 employees: 0..4
        MeetingRoomScheduler scheduler = new MeetingRoomScheduler(3, 5);

        // ---- Booking ----
        Set<Integer> attendees1 = Set.of(0, 1);
        scheduler.bookRoom("B1", attendees1, 0, 10, 20);

        Set<Integer> attendees2 = Set.of(2, 3);
        scheduler.bookRoom("B2", attendees2, 0, 21, 30);

        Set<Integer> attendees3 = Set.of(1, 4);
        scheduler.bookRoom("B3", attendees3, 1, 15, 25);

        // ---- Availability ----
        System.out.println("Available rooms [5,9]: "
                + scheduler.getAvailableRooms(5, 9));

        System.out.println("Available rooms [18,22]: "
                + scheduler.getAvailableRooms(18, 22));

        // ---- List by Room ----
        System.out.println("Room 0 bookings: "
                + scheduler.listBookingsForRoom(0));

        System.out.println("Room 1 bookings: "
                + scheduler.listBookingsForRoom(1));

        // ---- List by Employee ----
        System.out.println("Employee 1 bookings: "
                + scheduler.listBookingsForEmployee(1));

        // ---- Cancel ----
        scheduler.cancelBooking("B1");
        System.out.println("Room 0 after cancel: "
                + scheduler.listBookingsForRoom(0));

        System.out.println("Employee 1 after cancel: "
                + scheduler.listBookingsForEmployee(1));

    }

}
