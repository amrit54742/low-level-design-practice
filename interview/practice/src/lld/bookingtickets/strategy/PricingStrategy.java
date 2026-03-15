package lld.bookingtickets.strategy;

import lld.bookingtickets.model.Seats;

public interface PricingStrategy {
    double calculateShowPrice(Seats seats);
}
