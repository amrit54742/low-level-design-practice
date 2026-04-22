package lld.parkinglot.model;

public class ParkingSpot {
    private final int id;
    private final VehicleType type;
    private boolean isFree = true;
    private Vehicle vehicle;

    public ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    public boolean canFit(Vehicle vehicle) {
        return isFree && this.type == vehicle.getType();
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }

    public boolean isFree() { return isFree; }
    public int getId() { return id; }
}
