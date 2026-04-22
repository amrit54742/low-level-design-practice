package lld.parkinglot.strategy;

import lld.parkinglot.model.ParkingFloor;
import lld.parkinglot.model.ParkingSpot;
import lld.parkinglot.model.Vehicle;

import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy {

    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.canFit(vehicle)) {
                    return spot;
                }
            }
        }
        return null;
    }
}
