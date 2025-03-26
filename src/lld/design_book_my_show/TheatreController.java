package lld.design_book_my_show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre = new HashMap<>();
    List<Theatre> allTheatre = new ArrayList<>();

    void addTheatre(Theatre theatre, City city) {

        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }


    public Map<Theatre, List<Show>> getAllShows(Movie interestedMovie, City userCity) {
        // get ALl theater of this city
        List<Theatre> theatres = cityVsTheatre.get(userCity);

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        for(Theatre theatre : theatres) {
            List<Show> shows = new ArrayList<>();

            for(Show show : theatre.shows) {
                if(show.movie.movieId == interestedMovie.movieId) {
                    shows.add(show);
                }
            }
            if (!shows.isEmpty()) {
                theatreVsShows.put(theatre, shows);
            }
        }
        return theatreVsShows;
    }
}
