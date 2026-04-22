package lld.parkinglot.service;

import lld.parkinglot.model.Ticket;
import lld.parkinglot.model.Vehicle;

public class EntryGate {

    public Ticket generateTicket(Vehicle vehicle) {
        return ParkingLot.getInstance().parkVehicle(vehicle);
    }
}
