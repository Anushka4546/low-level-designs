package ParkingLot.PricingStrategy;

public interface PricingStrategy {
    double calculateFees(double pricePerHour, double timeSpentInHours);
}
