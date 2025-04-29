package lld.design_library_management_system;

import java.util.Date;

public class FineService {
    public Fine calculateFine(BookItem bookItem, Date dueDate, SystemUser user) {
        // calculate fine based on bookItem, dueDate and user
        long currentTime = new Date().getTime();
        long dueTime = dueDate.getTime();
        if (currentTime <= dueTime) return new Fine(new Date(), bookItem, user, 0.0);

        long diffDays = (currentTime - dueTime) / (1000 * 60 * 60 * 24);
        double fineValue = diffDays * 5.0; // 5 units per day fine

        return new Fine(new Date(), bookItem, user, fineValue);
    }
}
