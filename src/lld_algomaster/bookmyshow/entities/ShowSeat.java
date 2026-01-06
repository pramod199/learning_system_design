package lld_algomaster.bookmyshow.entities;

import lld_algomaster.bookmyshow.enums.ShowSeatStatus;

public class ShowSeat {
    private String id;
    private Show show;
    private Seat seat;
    private ShowSeatStatus status = ShowSeatStatus.AVAILABLE;
    private int version; // for optimistic locking if using DB

    public ShowSeat(String id, Show show, Seat seat) {
        this.id = id;
        this.show = show;
        this.seat = seat;
        this.status = ShowSeatStatus.AVAILABLE;
        show.addShowSeat(this);
    }

    public void setStatus(ShowSeatStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public Seat getSeat() {
        return seat;
    }

    public ShowSeatStatus getStatus() {
        return status;
    }

    public int getVersion() {
        return version;
    }

}