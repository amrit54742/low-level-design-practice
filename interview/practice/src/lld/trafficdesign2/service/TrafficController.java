package lld.trafficdesign2.service;

import lld.trafficdesign2.model.Intersection;
import lld.trafficdesign2.model.Movement;
import lld.trafficdesign2.model.TrafficPhase;
import lld.trafficdesign2.strategy.PhaseScheduler;

public class TrafficController {

    private static TrafficController instance;

    private TrafficController() {}

    public static synchronized TrafficController getInstance() {

        if (instance == null)
            instance = new TrafficController();

        return instance;
    }

    public void runCycle(Intersection intersection,
                         PhaseScheduler scheduler) {

        TrafficPhase phase = scheduler.selectNextPhase(intersection);

        System.out.println("\nActive Phase:" + phase);

        for (Movement m : phase.getAllowedMovements()) {
            System.out.println("GREEN : " + m);
        }

        try {
            Thread.sleep(phase.getDuration() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}