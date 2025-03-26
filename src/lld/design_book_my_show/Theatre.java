package lld.design_book_my_show;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    public int theatreId; // to avoid getter setter intentionally made public
    public String theatreName;
    public City city;
//    public int totalSeats;
//    public int availableSeats;
//    public int movieId;
//    public int showId;
//    public int screenId;

    List<Show> shows = new ArrayList<>();
    List<Screen> screens = new ArrayList<>();

    // other details like show timings, etc.

    // getter/ setters
}
