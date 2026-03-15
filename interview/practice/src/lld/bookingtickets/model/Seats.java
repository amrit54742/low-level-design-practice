package lld.bookingtickets.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Seats {
    private SeatState seatState;
    private String seatId;

    public Seats(String seatNumber) {

        this.seatId = seatNumber;
        this.seatState = SeatState.AVAILABLE;
    }


}
