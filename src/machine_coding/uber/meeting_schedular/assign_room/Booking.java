package machine_coding.uber.meeting_schedular.assign_room;


public class Booking {
    public String bookingId;
    public String roomId;
    public int start;
    public int end;

    public Booking(String bookingId, String roomId, int start, int end) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
    }


}
