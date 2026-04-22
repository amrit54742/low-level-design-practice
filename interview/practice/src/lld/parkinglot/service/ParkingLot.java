package lld.parkinglot.service;

import lld.parkinglot.model.ParkingFloor;
import lld.parkinglot.model.ParkingSpot;
import lld.parkinglot.model.Ticket;
import lld.parkinglot.model.Vehicle;
import lld.parkinglot.strategy.NearestSpotStrategy;
import lld.parkinglot.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final ParkingStrategy strategy;

    private ParkingLot() {
        strategy = new NearestSpotStrategy();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = strategy.findSpot(floors, vehicle);

        if (spot == null) {
            System.out.println("No spot available");
            return null;
        }

        spot.assignVehicle(vehicle);
        return new Ticket(vehicle, spot);
    }

    public void unparkVehicle(Ticket ticket) {
        ticket.getSpot().removeVehicle();
    }
}
