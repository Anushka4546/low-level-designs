package ParkingLot.AllocationStrategy;

import java.util.PriorityQueue;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.enums.AllocationType;

public abstract class SpotAllocationStrategy {
    AllocationType type;

    public SpotAllocationStrategy(AllocationType type) {
        this.type = type;
    }

    public AllocationType getType() {
        return this.type;
    }
    public abstract ParkingSpot allocateSpot(PriorityQueue<ParkingSpot> availableSpots);
}
