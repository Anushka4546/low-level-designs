package ParkingLot.entities;

import java.time.Instant;

import ParkingLot.AllocationStrategy.NearElevatorStrategy;
import ParkingLot.AllocationStrategy.NearEntranceStrategy;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.enums.AllocationType;

public class Entry {
    ParkingSpotManager manager;

    public Entry(ParkingSpotManager manager) {
        this.manager = manager;
    }

    public ParkingTicket getTicket(AllocationType type, Vehicle vt) {
        ParkingSpot spot = null;
        if(type == AllocationType.NearElevatorStrategy) {
            spot = this.manager.allocateSpot(vt, new NearElevatorStrategy(type));
        } else if(type == AllocationType.NearEntranceStrategy) {
            spot = this.manager.allocateSpot(vt, new NearEntranceStrategy(type));
        }
        
        if(spot == null) {
            System.out.println("Parking Full!");
            return null;
        }

        return new ParkingTicket(1,Instant.now(), spot, vt.getVehicleType());
    }
}
