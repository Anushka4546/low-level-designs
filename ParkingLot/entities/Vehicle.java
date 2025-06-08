package ParkingLot.entities;

import ParkingLot.enums.VehicleType;

public class Vehicle {
    String vehicleNumber;
    VehicleType type;

    public Vehicle(String vehicleNumber, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    VehicleType getType() {
        return this.type;
    }

    public VehicleType getVehicleType() {
        return this.type;
    }
}
