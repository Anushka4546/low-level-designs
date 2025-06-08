package ParkingLot.ParkingSpotManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import ParkingLot.AllocationStrategy.SpotAllocationStrategy;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.entities.Vehicle;
import ParkingLot.enums.AllocationType;
import ParkingLot.enums.VehicleType;

public class ParkingSpotManager {
    public List<ParkingSpot> parkingSpots;
    private Map<VehicleType, Map<AllocationType, PriorityQueue<ParkingSpot>>> filteredList;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
        this.filterSpots();
    }   

    private void filterSpots() {
        this.filteredList = new HashMap<>();
        for (ParkingSpot spot : parkingSpots) {
            this.addParkingSpot(spot);
        }
    }

    public ParkingSpot allocateSpot(Vehicle vt, SpotAllocationStrategy st) {
        ParkingSpot spot = st.allocateSpot(filteredList.get(vt.getVehicleType()).get(st.getType()));
        if(spot == null) {
            System.out.println("No Parking Available!");
            return null;
        }
        
        return spot;
    }

    public void addParkingSpot(ParkingSpot spot) {
        VehicleType vt = spot.getType();          
            if(!filteredList.containsKey(vt)) {
                filteredList.put(vt, new HashMap<>());
                filteredList.get(vt).put(AllocationType.NearElevatorStrategy, new PriorityQueue<>((a, b) -> {
                    return a.getDistanceFromElevator() - b.getDistanceFromElevator();
                }));
                filteredList.get(vt).put(AllocationType.NearEntranceStrategy, new PriorityQueue<>((a, b) -> {
                    return a.getDistanceFromEntrance() - b.getDistanceFromEntrance();
                }));
            }
        
            filteredList.get(vt).get(AllocationType.NearElevatorStrategy).add(spot);
            filteredList.get(vt).get(AllocationType.NearEntranceStrategy).add(spot);
    }
}
