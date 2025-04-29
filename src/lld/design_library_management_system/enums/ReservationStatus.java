package lld.design_library_management_system.enums;

public enum ReservationStatus {
    WAITING, // The user has requested a reservation, but the book is not yet available (maybe it's currently issued to someone else). The reservation is queued and waiting.
    RESERVED, // The book is available and successfully reserved for the user. The user is expected to pick it up or issue it.
    COMPLETED, // The reservation was fulfilled — meaning the user successfully issued the reserved book. The reservation is now finished.
    CANCELED // The reservation was canceled — either by the user or automatically (e.g., user didn't collect the book in time).
}
