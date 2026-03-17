package lld.trafficdesign2.service;

import lld.trafficdesign2.model.Intersection;
import lld.trafficdesign2.model.Lane;
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

//    public void runCycle(Intersection intersection,
//                         PhaseScheduler scheduler) {
//
//        TrafficPhase phase = scheduler.selectNextPhase(intersection);
//
//        System.out.println("\nActive Phase:" + phase);
//
//        for (Movement m : phase.getAllowedMovements()) {
//            System.out.println("GREEN : " + m);
//        }
//
//        try {
//            Thread.sleep(phase.getDuration() * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    public void startSimulation(Intersection intersection,
                                PhaseScheduler scheduler) {

        while (true) {

            TrafficPhase phase = scheduler.selectNextPhase(intersection);

            System.out.println("\n=== New Phase ===");

            // Activate GREEN for allowed movements
            for (Movement m : phase.getAllowedMovements()) {
                System.out.println("GREEN: " + m);
            }

            // Vehicles pass during green signal
            for (Movement m : phase.getAllowedMovements()) {

                for (Lane lane : intersection.getLanes()) {

                    if (lane.getMovement().equals(m)) {

                        int before = lane.getVehicleCount();

                        // simulate vehicles passing
                        int vehiclesToPass = Math.min(2, before); // max 2 pass

                        for (int i = 0; i < vehiclesToPass; i++) {
                            lane.vehiclePassed();
                        }

                        int after = lane.getVehicleCount();

                        System.out.println(
                                m + " | Before: " + before + " After: " + after
                        );
                    }
                }
            }

            // Wait for phase duration
            try {
                Thread.sleep(phase.getDuration() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }





}