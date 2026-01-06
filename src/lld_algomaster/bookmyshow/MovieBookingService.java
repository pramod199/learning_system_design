package lld_algomaster.bookmyshow;

import lld_algomaster.bookmyshow.entities.*;
import lld_algomaster.bookmyshow.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MovieBookingService {
    private static volatile MovieBookingService instance;

    private final Map<String, City> cities;
    private final Map<String, Theatre> theatres;
    private final Map<String, Movie> movies;
    private final Map<String, User> users;
    private final Map<String, Show> shows;

    // core service
    private final SeatLockService seatLockService;
    private final BookingService bookingService;


    private MovieBookingService() {
        this.cities = new ConcurrentHashMap<>();
        this.theatres = new ConcurrentHashMap<>();
        this.movies = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
        this.shows = new ConcurrentHashMap<>();

        this.seatLockService = new InMemorySeatLockService();
        this.bookingService = new BookingService(seatLockService);
    }

    public static MovieBookingService getInstance() {
        if (instance == null) {
            synchronized (MovieBookingService.class) {
                if (instance == null) {
                    instance = new MovieBookingService();
                }
            }
        }
        return instance;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    // data management methods

    public City addCity(String id, String name) {
        City city = new City(id, name);
        cities.put(city.getId(), city);
        return city;
    }

    public Theatre addTheater(String id, String name, String cityId, String address, List<Screen> screens) {
        City city = cities.get(cityId);
        Theatre cinema = new Theatre(id, name, address, city, screens);
        theatres.put(cinema.getId(), cinema);
        return cinema;
    }
    public void addMovie(Movie movie) {
        this.movies.put(movie.getId(), movie);
    }

    public Show addShow(String id, Movie movie, Screen screen, LocalDateTime startTime, PricingStrategy pricingStrategy) {
        Show show = new Show(id, movie, screen, startTime, startTime.plusMinutes(movie.getDurationInMinutes()), pricingStrategy);
        shows.put(show.getId(), show);
        return show;
    }

    public ShowSeat addShowSeat(Show show, Seat seat) {
        return new ShowSeat(seat.getId(), show, seat);
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }


    public Booking bookTickets(String userId, String showId, List<ShowSeat> desiredSeats) {
        return bookingService.createBooking(
                users.get(userId),
                shows.get(showId),
                desiredSeats
        );
    }

    public void confirmBooking(Booking booking, Payment payment) {
        bookingService.confirmBooking(booking, payment);
    }

    // --- Search Functionality ---
    public List<Show> findShows(String movieTitle, String cityName) {
        List<Show> result = new ArrayList<>();
        shows.values().stream()
                .filter(show -> show.getMovie().getTitle().equalsIgnoreCase(movieTitle))
                .filter(show -> {
                    Theatre cinema = findTheatresForShow(show);
                    return cinema != null && cinema.getCity().getName().equalsIgnoreCase(cityName);
                })
                .forEach(result::add);
        return result;
    }

    private Theatre findTheatresForShow(Show show) {
        // This is inefficient. In a real system, shows would have a direct link to the cinema.
        // For this example, we traverse the cinema list.
        return theatres.values().stream()
                .filter(cinema -> cinema.getScreens().contains(show.getScreen()))
                .findFirst()
                .orElse(null);
    }

}
