package lld.trafficdesign2.model;

import java.util.Set;

public class TrafficPhase {

    private Set<Movement> allowedMovements;
    private int duration;

    public TrafficPhase(Set<Movement> allowedMovements, int duration) {
        this.allowedMovements = allowedMovements;
        this.duration = duration;
    }

    public Set<Movement> getAllowedMovements() {
        return allowedMovements;
    }

    public int getDuration() {
        return duration;
    }

}
