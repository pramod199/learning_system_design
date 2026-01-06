package lld_algomaster.bookmyshow.entities;

import lld_algomaster.bookmyshow.enums.SeatType;

public class Seat {
    private String id;
    private String row;
    private int seatNumber;
    private SeatType seatType;
    private Screen screen;

    public Seat(String id, String row, int seatNumber, SeatType seatType, Screen screen) {
        this.id = id;
        this.row = row;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.screen = screen;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public String getId() {
        return id;
    }
}