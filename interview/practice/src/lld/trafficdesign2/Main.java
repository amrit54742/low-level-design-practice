package lld.trafficdesign2;

import lld.trafficdesign2.model.*;
import lld.trafficdesign2.service.TrafficController;
import lld.trafficdesign2.strategy.AdaptiveScheduler;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Movement ns = new Movement(Direction.NORTH, Direction.SOUTH);
        Movement sn = new Movement(Direction.SOUTH, Direction.NORTH);
        Movement ew = new Movement(Direction.EAST, Direction.WEST);
        Movement we = new Movement(Direction.WEST, Direction.EAST);

        Lane l1 = new Lane(ns);
        Lane l2 = new Lane(sn);
        Lane l3 = new Lane(ew);
        Lane l4 = new Lane(we);

        l1.vehicleArrived();
        l1.vehicleArrived();
        l3.vehicleArrived();

        TrafficPhase p1 = new TrafficPhase(Set.of(ns, sn), 5);
        TrafficPhase p2 = new TrafficPhase(Set.of(ew, we), 5);

        Intersection intersection = new Intersection(
                "CityCenter",
                List.of(l1, l2, l3, l4),
                List.of(p1, p2)
        );

        TrafficController controller =
                TrafficController.getInstance();

        controller.runCycle(intersection,
                new AdaptiveScheduler());
    }
}