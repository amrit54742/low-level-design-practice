package lld.parkinglot.strategy;

import lld.parkinglot.model.ParkingFloor;
import lld.parkinglot.model.ParkingSpot;
import lld.parkinglot.model.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
