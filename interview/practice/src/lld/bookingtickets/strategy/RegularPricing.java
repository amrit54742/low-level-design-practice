package lld.bookingtickets.strategy;

import lld.bookingtickets.model.Seats;

public class RegularPricing implements PricingStrategy {

    @Override
    public double calculateShowPrice(Seats seats) {
        return 100.0;
    }
}
