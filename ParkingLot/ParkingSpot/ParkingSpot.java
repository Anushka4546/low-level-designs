package ParkingLot.ParkingSpot;

import ParkingLot.enums.SpotStatus;
import ParkingLot.enums.VehicleType;

public class ParkingSpot {
  double price;
    int floorNumber;
    SpotStatus status;
    int distanceFromEntrance;
    int distanceFromElevator;
    VehicleType type;

    public ParkingSpot(double price, int floorNumber, SpotStatus status, VehicleType type, int distanceFromEntrance, int distanceFromElevator) {
        this.price = price;
        this.floorNumber = floorNumber;
        this.status = status;
        this.type = type;
        this.distanceFromElevator = distanceFromElevator;
        this.distanceFromEntrance = distanceFromEntrance;
    }

    public boolean isEmpty() {
        return this.status.equals(SpotStatus.FREE);
    }

    public void allocateSpot() {
        this.status = SpotStatus.BOOKED;
    }

    public void vacateSpot() {
        this.status = SpotStatus.FREE;
    }

    public double getPricePerHour() {
        return this.price;
    }

    public VehicleType getType() {
      return this.type;
    }

    public int getDistanceFromEntrance() {
      return this.distanceFromEntrance;
    }

    public int getDistanceFromElevator() {
      return this.distanceFromElevator;
    }
}
