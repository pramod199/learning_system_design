package lld_algomaster.bookmyshow;

import lld_algomaster.bookmyshow.entities.*;
import lld_algomaster.bookmyshow.enums.SeatType;
import lld_algomaster.bookmyshow.enums.ShowSeatStatus;
import lld_algomaster.bookmyshow.strategy.payment.CreditCardPaymentStrategy;
import lld_algomaster.bookmyshow.strategy.payment.PaymentStrategy;
import lld_algomaster.bookmyshow.strategy.pricing.WeekdayPricingStrategy;
import lld_algomaster.bookmyshow.strategy.pricing.WeekendPricingStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BookMyShowDemo {
    public static void main(String[] args) {
        // setup
        MovieBookingService service = MovieBookingService.getInstance();


        City nyc = service.addCity("city1", "New York");
        City la = service.addCity("city2", "Los Angeles");

        // 2. Add movies
        Movie matrix = new Movie("M1", "The Matrix", 120);
        Movie avengers = new Movie("M2", "Avengers: Endgame", 170);
        service.addMovie(matrix);
        service.addMovie(avengers);

        // add seat for a scree
        Screen screen1 = new Screen("S1");
        for (int i = 1; i <= 10; i++) {
            screen1.addSeat(new Seat("A" + i, "1", i, i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM, screen1));
            screen1.addSeat(new Seat("B" + i, "2", i, i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM, screen1));
        }


        Theatre amcNycTheatre = service.addTheater("theatre1", "AMC Times Square", nyc.getId(), "newyork", List.of(screen1));

        LocalDateTime start = LocalDateTime.now().plusHours(2);
        Show matrixShow = service.addShow("show1", matrix, screen1, start, new WeekendPricingStrategy());
        Show avengersShow = service.addShow("show2", avengers, screen1, LocalDateTime.now().plusHours(5), new WeekdayPricingStrategy());

        for (Seat seat : screen1.getSeats()) {
            service.addShowSeat(matrixShow, seat);
            service.addShowSeat(avengersShow, seat);
        }



        // --- User Story: Alice books tickets ---
        User alice = service.createUser("Alice", "alice@example.com");

        System.out.println("\n--- Alice's Booking Flow ---");
        String cityName = "New York";
        String movieTitle = "Avengers: Endgame";

        // 1. Search for shows
        List<Show> availableShows = service.findShows(movieTitle, cityName);
        if (availableShows.isEmpty()) {
            System.out.println("No shows found for " + movieTitle + " in " + cityName);
            return;
        }
        Show selectedShow = availableShows.get(0); // Alice selects the first show


        // 2. View available seats
        List<ShowSeat> availableSeats = selectedShow.getShowSeats().stream()
                .filter(seat -> seat.getStatus() == ShowSeatStatus.AVAILABLE)
                .toList();
        System.out.printf("Available seats for '%s' at %s: %s%n",
                selectedShow.getMovie().getTitle(),
                selectedShow.getStartTime(),
                availableSeats.stream().map(ShowSeat::getId).collect(Collectors.toList()));

        // 3. Select seats
        List<ShowSeat> desiredSeats = List.of(availableSeats.get(2), availableSeats.get(3));
        System.out.println("Alice selects seats: " + desiredSeats.stream().map(ShowSeat::getId).toList());

        // 4. Book Tickets
       Booking booking = service.bookTickets(
                alice.getId(),
                selectedShow.getId(),
                desiredSeats
        );

        PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy("1234-5678-9876-5432", "123");
        Payment payment = paymentStrategy.pay(booking.getTotalAmount());


        service.confirmBooking(booking, payment);

        // 5. Verify seat status after booking
        System.out.println("\nSeat status after Alice's booking:");
        desiredSeats.forEach(seat -> System.out.printf("Seat %s status: %s%n", seat.getId(), seat.getStatus()));




    }
}
