package lld.trafficdesign2.model;

public class TrafficSensor {

    public int detectVehicles(Lane lane) {
        return lane.getVehicleCount();
    }

}
