package lld.trafficcontroldesign.model;

import java.util.Set;

public class TrafficPhase {

    private Set<Direction> allowedDirections;
    private int duration;

    public TrafficPhase(Set<Direction> allowedDirections, int duration) {

        this.allowedDirections = allowedDirections;
        this.duration = duration;
    }

    public Set<Direction> getAllowedDirections() {

        return allowedDirections;
    }

    public int getDuration() {

        return duration;
    }
}
