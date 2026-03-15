package lld.bookingtickets;

import lld.bookingtickets.model.Movie;
import lld.bookingtickets.model.Seats;
import lld.bookingtickets.model.Show;
import lld.bookingtickets.service.BookingService;
import lld.bookingtickets.strategy.RegularPricing;

import java.util.Arrays;

public class BookingMain {

    public static void main(String[] args) {

        Movie movie = new Movie("1","Inception");

        Seats s1 = new Seats("A1");
        Seats s2 = new Seats("A2");

        Show show = new Show(movie, Arrays.asList(s1,s2));

        BookingService bookingService = BookingService.getInstance();

        bookingService.bookSeats(
                show,
                Arrays.asList(s1,s2),
                new RegularPricing()
        );
    }


}
