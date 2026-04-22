package lld.parkinglot.service;

import lld.parkinglot.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentService {

    public double calculateFee(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours() + 1;
        return hours * 10; // flat rate
    }
}
