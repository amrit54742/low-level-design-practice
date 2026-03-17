package lld.trafficdesign2.strategy;

import lld.trafficdesign2.model.Intersection;
import lld.trafficdesign2.model.Lane;
import lld.trafficdesign2.model.Movement;
import lld.trafficdesign2.model.TrafficPhase;

public class AdaptiveScheduler implements PhaseScheduler {

    @Override
    public TrafficPhase selectNextPhase(Intersection intersection) {

        TrafficPhase bestPhase = null;
        int maxVehicles = -1;

        for (TrafficPhase phase : intersection.getPhases()) {

            int vehicles = 0;

            for (Movement movement : phase.getAllowedMovements()) {

                for (Lane lane : intersection.getLanes()) {

                    if (lane.getMovement().equals(movement))
                        vehicles += lane.getVehicleCount();
                }
            }

            if (vehicles > maxVehicles) {
                maxVehicles = vehicles;
                bestPhase = phase;
            }
        }

        return bestPhase;
    }
}
