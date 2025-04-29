package lld.design_book_my_show;

import java.util.ArrayList;
import java.util.List;

public class Show {

    int showId;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookedSeatIds = new ArrayList<>();

    public boolean bookSeat(int seatNumber) {
        if(!this.bookedSeatIds.contains(seatNumber)){
            this.bookedSeatIds.add(seatNumber);
            System.out.println("Seat booked successfully");
            return true;
        } else{
            System.out.println("Seat already booked");
            return false;
        }
    }
}
