package lld_algomaster.bookmyshow;

import lld_algomaster.bookmyshow.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InMemorySeatLockService implements SeatLockService {
    // Map<showId, Map<showSeatId, SeatLock>>
    private final Map<String, Map<String, SeatLock>> locks = new HashMap<>(); // show -> Map<SeatId, seatLock>
    private final int LOCK_TIMEOUT_SECONDS = 300; // 5 minutes

    @Override
    public synchronized void lockSeats(Show show, List<ShowSeat> seats, User user) {
        for (ShowSeat seat : seats) {
            if (isSeatLocked(show, seat)) {
                throw new RuntimeException("Seat already locked: " + seat.getId());
            }
        }
        for (ShowSeat seat : seats) {
            locks.computeIfAbsent(show.getId(), k -> new HashMap<>())
                    .put(seat.getId(), new SeatLock(show, seat, user, LOCK_TIMEOUT_SECONDS));
        }
        System.out.println("Locked seats " + seats.stream().map(ShowSeat::getId).collect(Collectors.toList())
                + " for user " + user.getName());
    }

    @Override
    public synchronized void unlockSeats(Show show, List<ShowSeat> seats, User user) {
        Map<String, SeatLock> showLocks = locks.get(show.getId());
        if (showLocks == null) return;

        for (ShowSeat seat : seats) {
            SeatLock lock = showLocks.get(seat.getId());
            if (lock != null && lock.getLockedBy().getId().equals(user.getId())) {
                showLocks.remove(seat.getId());
            }
        }
        System.out.println("Unlocked seats " + seats.stream().map(ShowSeat::getId).collect(Collectors.toList())
                + " for user " + user.getName());
    }

    @Override
    public synchronized void validateLock(Show show, List<ShowSeat> seats, User user) {
        for (ShowSeat seat : seats) {
            Map<String, SeatLock> showLocks = locks.get(show.getId());
            if (showLocks == null) {
                throw new RuntimeException("Seat not locked: " + seat.getId());
            }
            SeatLock lock = showLocks.get(seat.getId());
            if (lock == null || lock.isLockExpired() || !lock.getLockedBy().getId().equals(user.getId())) {
                throw new RuntimeException("Invalid lock for seat: " + seat.getId());
            }
        }
    }

    private boolean isSeatLocked(Show show, ShowSeat seat) {
        Map<String , SeatLock> showLocks = locks.get(show.getId());
        if (showLocks == null) return false;

        SeatLock lock = showLocks.get(seat.getId());
        if (lock == null) return false;

        if (lock.isLockExpired()) {
            showLocks.remove(seat.getId());
            return false;
        }
        return true;
    }
}