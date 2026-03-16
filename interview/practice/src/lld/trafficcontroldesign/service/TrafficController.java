package lld.trafficcontroldesign.service;

import lld.trafficcontroldesign.model.Intersection;
import lld.trafficcontroldesign.strategy.ITrafficPatternStrategy;

public class TrafficController {

    private static TrafficController instance;

    private TrafficController() {}

    public static TrafficController getInstance() {

        if(instance == null)
            instance = new TrafficController();

        return instance;
    }

    public void start(Intersection intersection,
                      ITrafficPatternStrategy strategy) {

        strategy.runCycle(intersection);
    }
}