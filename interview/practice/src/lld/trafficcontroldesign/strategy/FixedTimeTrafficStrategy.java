package lld.trafficcontroldesign.strategy;

import lld.trafficcontroldesign.model.Intersection;
import lld.trafficcontroldesign.model.TrafficPhase;

public class FixedTimeTrafficStrategy implements ITrafficPatternStrategy{

    @Override
    public void runCycle(Intersection intersection) {

        for(TrafficPhase phase : intersection.getPhases()) {

            System.out.println("Allowed Directions: "
                    + phase.getAllowedDirections());

            System.out.println("Duration: "
                    + phase.getDuration() + " seconds");
        }
    }
}
