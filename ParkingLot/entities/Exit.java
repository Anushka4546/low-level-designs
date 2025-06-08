package ParkingLot.entities;

import java.time.Duration;
import java.time.Instant;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.PaymentStrategy.PaymentStrategy;
import ParkingLot.PricingStrategy.PricingStrategy;

public class Exit {
    ParkingTicket ticket;
    PricingStrategy pricingStrategy;
    PaymentStrategy paymentStrategy;

    public Exit(ParkingTicket ticket, PricingStrategy pricingStrategy, PaymentStrategy paymentStrategy) {
        this.ticket = ticket;
        this.pricingStrategy = pricingStrategy;
        this.paymentStrategy = paymentStrategy;
    }

    private double calculatePrice() {
        Instant exitTime = Instant.now();
        double timeSpent = Duration.between(this.ticket.getEntryTime(), exitTime).toMinutes() / 60.0;
        double price = this.ticket.getParkingSpot().getPricePerHour();
        return this.pricingStrategy.calculateFees(price, timeSpent);
    }
    
    public boolean payPrice() {
        double amount = this.calculatePrice();
        boolean payed = this.paymentStrategy.pay(amount);
        return payed;
    }

    public void vacateSpot(ParkingSpotManager manager) {
        ParkingSpot spot = this.ticket.getParkingSpot();
        spot.vacateSpot();
        manager.addParkingSpot(spot);
    }
}
