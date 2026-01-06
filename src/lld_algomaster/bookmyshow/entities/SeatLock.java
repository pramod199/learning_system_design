package lld_algomaster.bookmyshow.entities;

import java.time.LocalDateTime;

public class SeatLock {
    Show show;
    ShowSeat showSeat;
    User lockedBy;
    LocalDateTime lockTime;
    int lockTimeoutInSeconds;

    public SeatLock(Show show, ShowSeat showSeat, User lockedBy, int lockTimeoutInSeconds) {
        this.show = show;
        this.showSeat = showSeat;
        this.lockedBy = lockedBy;
        this.lockTime = LocalDateTime.now();
        this.lockTimeoutInSeconds = lockTimeoutInSeconds;
    }


    public boolean isLockExpired() {
        return lockTime.plusSeconds(lockTimeoutInSeconds)
                       .isBefore(LocalDateTime.now());
    }

    public User getLockedBy() {
        return lockedBy;
    }
}