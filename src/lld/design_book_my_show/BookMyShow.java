package lld.design_book_my_show;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        bookMyShow.createBooking(City.Bangalore, "Baahubali");
        bookMyShow.createBooking(City.Bangalore, "Baahubali");

    }

    private void createBooking(City userCity, String movieName) {
        // 1. search movie by my location
        List<Movie> moviesByCity = movieController.getMoviesByCity(userCity);

        // 2. select movie which you want to see
        Movie interestedMovie = null;
        for (Movie movie : moviesByCity) {
            if (movie.movieName.equals(movieName)) {
                interestedMovie = movie;
                break;
            }
        }

        if (interestedMovie == null) {
            System.out.println("Movie not found: " + movieName);
            return;
        }

        // 3. get all the shows of this movie in bangalore location
        Map<Theatre, List<Show>> showTheaterWise = theatreController.getAllShows(interestedMovie, userCity);

        // 4. user select particular show
        Map.Entry<Theatre, List<Show>> entry = showTheaterWise.entrySet().iterator().next();

        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        // 5. user select seats
        int seatNumber = 30;
        boolean isBooked = interestedShow.bookSeat(seatNumber);
        if (isBooked) {
            // start Payment
            Booking booking = new Booking();
            List<Seat> myBookedSeat = new ArrayList<>();
            for (Seat seat : interestedShow.screen.seats) {
                if (seat.id == seatNumber) {
                    myBookedSeat.add(seat);
                    break;
                }
            }
            booking.bookedSeats = myBookedSeat;
            booking.show = interestedShow;
            System.out.println("Booking successful");
        } else {
            System.out.println("Booking failed");
        }

    }


    private void initialize() {
        // create movies
        createMovies();

        // create theatre with screen, seats and shows
        createTheatres();
    }

    private void createTheatres() {
        Movie avengers = movieController.getMovieByName("Avengers");
        Movie baahubali = movieController.getMovieByName("Baahubali");

        Theatre inox = new Theatre();
        inox.theatreId = 1;
        inox.theatreName = "INOX";
        inox.city = City.Bangalore;
        inox.screens = createScreens();
        inox.shows.addAll(createShows(avengers, inox.screens, 8));
        inox.shows.addAll(createShows(baahubali, inox.screens, 16));

        Theatre pvr = new Theatre();
        pvr.theatreId = 2;
        pvr.theatreName = "PVR";
        pvr.city = City.Delhi;
        pvr.screens = createScreens();
        pvr.shows.addAll(createShows(avengers, pvr.screens, 10));
        pvr.shows.addAll(createShows(baahubali, pvr.screens, 18));

        theatreController.addTheatre(inox, City.Bangalore);
        theatreController.addTheatre(pvr, City.Delhi);
    }

    private List<Show> createShows(Movie movie, List<Screen> screens, int timing) {
        List<Show> shows = new ArrayList<>();
        int showId = 1;
        for (Screen screen : screens) {
            Show show = createShow(showId, movie, screen, timing);
            showId++;
            shows.add(show);
        }
        return shows;
    }

    private Show createShow(int showId, Movie movie, Screen screen, int startTime) {
        Show show = new Show();
        show.showId = showId;
        show.movie = movie;
        show.screen = screen;
        show.startTime = startTime;
        return show;
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.screenId = 1;
        screen1.seats = createSeats(100);

        Screen screen2 = new Screen();
        screen2.screenId = 2;
        screen2.seats = createSeats(100);

        screens.add(screen1);
        screens.add(screen2);
        return screens;
    }


    private List<Seat> createSeats(int totalSeat) { // not using total seat but can be used for dynamic seat
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.id = i;
            seat.category = SeatCategory.SILVER;
            seats.add(seat);
        }

        //41 to 70 : GOLD
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.id = i;
            seat.category = SeatCategory.GOLD;
            seats.add(seat);
        }

        //1 to 40 : PLATINUM
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.id = i;
            seat.category = SeatCategory.PLATINUM;
            seats.add(seat);
        }

        return seats;

    }

    private void createMovies() {
        Movie avengers = new Movie();
        avengers.movieId = 1;
        avengers.movieName = "Avengers";
        avengers.movieDurationInMinutes = 180;

        Movie baahubali = new Movie();
        baahubali.movieId = 2;
        baahubali.movieName = "Baahubali";
        baahubali.movieDurationInMinutes = 200;

        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(baahubali, City.Bangalore);
        movieController.addMovie(baahubali, City.Delhi);

    }
}
