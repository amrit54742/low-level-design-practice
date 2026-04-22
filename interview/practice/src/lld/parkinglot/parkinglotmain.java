package lld.parkinglot;

import lld.parkinglot.model.*;
import lld.parkinglot.service.EntryGate;
import lld.parkinglot.service.ExitGate;
import lld.parkinglot.service.ParkingLot;

public class parkinglotmain {
    public static void main(String[] args) {

        ParkingLot lot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot(new ParkingSpot(1, VehicleType.CAR));
        floor1.addSpot(new ParkingSpot(2, VehicleType.BIKE));

        lot.addFloor(floor1);

        EntryGate entry = new EntryGate();
        ExitGate exit = new ExitGate();

        Vehicle car = new Car("KA01AB1234");
        //todo: try truck if only car/bike parking spot were created..

        Ticket ticket = entry.generateTicket(car);

        exit.processExit(ticket);
    }
}
