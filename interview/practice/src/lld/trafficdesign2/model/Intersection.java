package lld.trafficdesign2.model;

import java.util.List;

public class Intersection {

    private String id;
    private List<Lane> lanes;
    private List<TrafficPhase> phases;

    public Intersection(String id, List<Lane> lanes, List<TrafficPhase> phases) {
        this.id = id;
        this.lanes = lanes;
        this.phases = phases;
    }

    public List<Lane> getLanes() {
        return lanes;
    }

    public List<TrafficPhase> getPhases() {
        return phases;
    }

    public String getId() {
        return id;
    }


}
