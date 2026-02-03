package machine_coding.uber.meeting_schedular;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Room {
    int roomId;
    RoomCalendar calendar;
    ReadWriteLock lock;

    public Room(int roomId) {
        this.roomId = roomId;
        calendar = new RoomCalendar();
        lock = new ReentrantReadWriteLock();
    }
}
