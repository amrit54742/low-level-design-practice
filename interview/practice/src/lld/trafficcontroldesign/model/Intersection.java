package lld.trafficcontroldesign.model;

import java.util.List;

public class Intersection {

    private String name;
    private List<TrafficPhase> phases;

    public Intersection(String name, List<TrafficPhase> phases) {

        this.name = name;
        this.phases = phases;
    }

    public List<TrafficPhase> getPhases() {

        return phases;
    }

    public String getName() {

        return name;
    }
}
