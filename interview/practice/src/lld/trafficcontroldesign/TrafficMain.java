package lld.trafficcontroldesign;

import lld.trafficcontroldesign.model.Direction;
import lld.trafficcontroldesign.model.Intersection;
import lld.trafficcontroldesign.model.TrafficPhase;
import lld.trafficcontroldesign.service.TrafficController;
import lld.trafficcontroldesign.strategy.FixedTimeTrafficStrategy;

import java.util.List;
import java.util.Set;

public class TrafficMain {

    public static void main(String[] args) {

        TrafficPhase phase1 = new TrafficPhase(
                Set.of(Direction.NORTH_SOUTH,
                        Direction.SOUTH_NORTH),
                30
        );

        TrafficPhase phase2 = new TrafficPhase(
                Set.of(Direction.EAST_WEST,
                        Direction.WEST_EAST),
                30
        );

        Intersection intersection = new Intersection(
                "CityCenter",
                List.of(phase1, phase2)
        );

        TrafficController controller =
                TrafficController.getInstance();

        controller.start(
                intersection,
                new FixedTimeTrafficStrategy()
        );
    }


}
