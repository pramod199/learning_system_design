package lld_algomaster.bookmyshow.entities;

import lld_algomaster.bookmyshow.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<ShowSeat> showSeats = new ArrayList<>();
    private double totalAmount;
    private BookingStatus status;
    private LocalDateTime createdAt;
    private Payment payment;


    public Booking(String id, User user, Show show, List<ShowSeat> showSeats, double totalAmount) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.showSeats.addAll(showSeats);
        this.createdAt = LocalDateTime.now();
        this.status = BookingStatus.PENDING;
        this.totalAmount = totalAmount;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Show getShow() { return show; }
    public List<ShowSeat> getShowSeats() { return showSeats; }
    public double getTotalAmount() { return totalAmount; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
    public LocalDateTime getCreatedAt() { return createdAt; }

}