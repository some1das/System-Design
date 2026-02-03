package behavioural.strategyDesignPattern.good_code;

public class CreditCardStrategy implements PaymentStrategy{

    @Override
    public void makePayment() {
        System.out.println("Making Payment Via Credit Card...");
    }
    
}
