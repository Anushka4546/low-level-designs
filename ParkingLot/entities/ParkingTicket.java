package ParkingLot.entities;

import java.time.Instant;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.enums.VehicleType;

public class ParkingTicket {
    private int id;
    private Instant entryTime;
    private ParkingSpot parkingSpot;
    private VehicleType vehicleType;

    ParkingTicket(int id, Instant entryTime, ParkingSpot parkingSpot, VehicleType vehicleType) {
        this.id = id;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicleType = vehicleType;
    }

    public Instant getEntryTime() {
        return this.entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }
}