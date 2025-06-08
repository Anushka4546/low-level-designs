package ParkingLot.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
   
    @Override
    public boolean pay(double amount) {
        // receive payment and validate logic
        return true;
    }
}
