package ParkingLot.PaymentStrategy;

public class CardPaymentStrategy implements PaymentStrategy{
    String cardNumber;
    String cardHolder;

    public CardPaymentStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public boolean pay(double amount) {
        // Integrate with third party payment gateway here
        System.out.println("Payment done!");
        // add validation here
        return true;
    }
}
