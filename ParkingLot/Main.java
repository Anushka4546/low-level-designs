package ParkingLot;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.entities.Entry;
import ParkingLot.entities.Exit;
import ParkingLot.entities.ParkingTicket;
import ParkingLot.entities.Vehicle;
import ParkingLot.enums.SpotStatus;
import ParkingLot.enums.VehicleType;
import ParkingLot.enums.AllocationType;
import ParkingLot.AllocationStrategy.NearEntranceStrategy;
import ParkingLot.PricingStrategy.HourBasedPricingStrategy;
import ParkingLot.PricingStrategy.PricingStrategy;
import ParkingLot.PaymentStrategy.CardPaymentStrategy;
import ParkingLot.PaymentStrategy.PaymentStrategy;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Create Parking Spots
        List<ParkingSpot> spots = new ArrayList<>();
        // Add a few FourWheeler and TwoWheeler spots
        spots.add(new ParkingSpot(40.0, 1, SpotStatus.FREE, VehicleType.FOURWHEELER, 10, 5));
        spots.add(new ParkingSpot(50.0, 1, SpotStatus.FREE, VehicleType.FOURWHEELER, 20, 8));
        spots.add(new ParkingSpot(20.0, 1, SpotStatus.FREE, VehicleType.TWOWHEELER,5, 3));
        spots.add(new ParkingSpot(15.0, 1, SpotStatus.FREE, VehicleType.TWOWHEELER,12, 6));

        // 2. Create allocation strategy and manager
        NearEntranceStrategy allocStrategy = new NearEntranceStrategy(AllocationType.NearEntranceStrategy);
        ParkingSpotManager spotManager = new ParkingSpotManager(spots);

        // 3. Pricing and Payment strategies
        PricingStrategy pricingStrategy = new HourBasedPricingStrategy();
        PaymentStrategy paymentStrategy = new CardPaymentStrategy("1234-5678-9012-3456", "John Doe");

        // 4. Simulate vehicle entry
        Vehicle vehicle = new Vehicle("MH12AB1234", VehicleType.FOURWHEELER);
        Entry entry = new Entry(spotManager);
        ParkingTicket ticket = entry.getTicket(AllocationType.NearElevatorStrategy, vehicle);

        if (ticket == null) {
            System.out.println("No available spot for your vehicle!");
            return;
        }

        System.out.println("Vehicle parked. Ticket ID: 125u98u" + ", Entry Time: " + ticket.getEntryTime());

        // Simulate parking duration
        Thread.sleep(2000); // Simulate 2 seconds of parking (replace with real wait/time logic in production)

        // 5. Simulate vehicle exit
        Exit exit = new Exit(ticket, pricingStrategy, paymentStrategy);
        boolean paymentSuccess = exit.payPrice();

        if (paymentSuccess) {
            exit.vacateSpot(spotManager);
            System.out.println("Vehicle exited. Payment successful. Spot is now free.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}

