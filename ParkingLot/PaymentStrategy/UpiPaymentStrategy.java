package ParkingLot.PaymentStrategy;

public class UpiPaymentStrategy implements PaymentStrategy{
    String UPIId;

    UpiPaymentStrategy(String UPIId) {
        this.UPIId = UPIId;
    }

    public boolean pay(double amount) {
        // payment and validation logic here
        System.out.println("Payment done!");
        return true;
    }
}
