package lld.parkinglot.service;

import lld.parkinglot.model.Ticket;

public class ExitGate {

    private final PaymentService paymentService = new PaymentService();

    public void processExit(Ticket ticket) {
        double fee = paymentService.calculateFee(ticket);

        System.out.println("Fee: " + fee);

        ParkingLot.getInstance().unparkVehicle(ticket);
    }
}
