package lld.trafficdesign2.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Lane {

    private Movement movement;
    private AtomicInteger vehicleCount = new AtomicInteger(0);

    public Lane(Movement movement) {
        this.movement = movement;
    }

    public Movement getMovement() {
        return movement;
    }

    public void vehicleArrived() {
        vehicleCount.incrementAndGet();
    }

    public void vehiclePassed() {
        if (vehicleCount.get() > 0)
            vehicleCount.decrementAndGet();
    }

    public int getVehicleCount() {
        return vehicleCount.get();
    }

}
