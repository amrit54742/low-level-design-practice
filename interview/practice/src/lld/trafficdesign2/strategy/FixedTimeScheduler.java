package lld.trafficdesign2.strategy;

import lld.trafficdesign2.model.Intersection;
import lld.trafficdesign2.model.TrafficPhase;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedTimeScheduler implements PhaseScheduler {

    private AtomicInteger index = new AtomicInteger(0);

    @Override
    public TrafficPhase selectNextPhase(Intersection intersection) {

        int i = index.getAndIncrement();
        return intersection.getPhases().get(
                i % intersection.getPhases().size()
        );
    }
}
