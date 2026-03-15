package lld.bookingtickets.service;

import lld.bookingtickets.model.*;
import lld.bookingtickets.strategy.PricingStrategy;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
public class BookingService {

    private static BookingService instance;

    public static BookingService getInstance(){
        if (instance==null){
            instance = new BookingService();
            return instance;
        } else {
            return instance;
        }
    }

    public Booking bookSeats(Show show, List<Seats> seatsToBeBooked, PricingStrategy pricingStrategy){
        double totalprice=0.0;
        Movie movie= show.getMovie();
        List<Seats> seatsListOfShow= show.getSeatsListForShow();
        //todo add check for checking all the seatstobebooked seats exists in the paricular show or not (or in the list seatsListOfShow)
        for(Seats seat : seatsToBeBooked) {


            if(seat.getSeatState() != SeatState.AVAILABLE) {

                throw new RuntimeException("Seat not available");
            }

            seat.setSeatState(SeatState.LOCKED);

            totalprice += pricingStrategy.calculateShowPrice(seat);
            System.out.println(" pricing is done.. proceeding to book the ticket");
        }

        for(Seats seat : seatsToBeBooked) {

            seat.setSeatState(SeatState.BOOKED);
        }

        System.out.println("Total Price: " + totalprice);

        return new Booking(UUID.randomUUID().toString(), show, seatsToBeBooked);


    }

}
