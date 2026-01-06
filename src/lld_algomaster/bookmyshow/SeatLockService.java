package lld_algomaster.bookmyshow;

import lld_algomaster.bookmyshow.entities.Show;
import lld_algomaster.bookmyshow.entities.ShowSeat;
import lld_algomaster.bookmyshow.entities.User;

import java.util.List;

public interface SeatLockService {
    void lockSeats(Show show, List<ShowSeat> seats, User user);
    void unlockSeats(Show show, List<ShowSeat> seats, User user);
    void validateLock(Show show, List<ShowSeat> seats, User user);
}
