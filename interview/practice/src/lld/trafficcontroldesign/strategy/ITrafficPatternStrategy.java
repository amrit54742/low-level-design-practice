package lld.trafficcontroldesign.strategy;

import lld.trafficcontroldesign.model.Intersection;

public interface ITrafficPatternStrategy {
    void runCycle(Intersection intersection);
}
