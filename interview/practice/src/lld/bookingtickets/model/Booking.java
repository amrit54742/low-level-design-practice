package lld.bookingtickets.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private String bookingId;
    private Show show;
    private List<Seats> seats;


}
