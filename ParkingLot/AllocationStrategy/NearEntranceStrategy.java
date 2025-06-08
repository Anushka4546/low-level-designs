package ParkingLot.AllocationStrategy;

import java.util.PriorityQueue;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.enums.AllocationType;

public class NearEntranceStrategy extends SpotAllocationStrategy {
    public NearEntranceStrategy(AllocationType type) {
        super(type);
    }

    @Override
    public ParkingSpot allocateSpot(PriorityQueue<ParkingSpot> availableSpots) {
        if(availableSpots.size() > 0) {
            return availableSpots.poll();
        }

        return null;
    }
}
