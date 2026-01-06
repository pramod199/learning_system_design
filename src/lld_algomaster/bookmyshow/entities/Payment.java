package lld_algomaster.bookmyshow.entities;

import lld_algomaster.bookmyshow.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private String id;
    private Booking booking;
    private PaymentStatus status;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paidAt;
    private String transactionId;

    public Payment(double amount, PaymentStatus status, String transactionId, String paymentMethod) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.status = status;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getStatus() { return status; }
}