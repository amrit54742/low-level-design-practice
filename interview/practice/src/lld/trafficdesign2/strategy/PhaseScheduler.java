package lld.trafficdesign2.strategy;

import lld.trafficdesign2.model.Intersection;
import lld.trafficdesign2.model.TrafficPhase;

public interface PhaseScheduler {

    TrafficPhase selectNextPhase(Intersection intersection);

}
