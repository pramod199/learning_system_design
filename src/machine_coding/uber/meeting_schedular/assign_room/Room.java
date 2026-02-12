package machine_coding.uber.meeting_schedular.assign_room;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Room {
    String roomId;
    RoomCalendar calendar;
    ReadWriteLock lock;

    public Room(String roomId) {
        this.roomId = roomId;
        calendar = new RoomCalendar();
        lock = new ReentrantReadWriteLock();
    }

}
