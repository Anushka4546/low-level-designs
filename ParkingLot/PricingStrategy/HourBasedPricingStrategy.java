package ParkingLot.PricingStrategy;

public class HourBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFees(double pricePerhour, double timeSpentInHours) {
        return pricePerhour * timeSpentInHours;
    }
}
