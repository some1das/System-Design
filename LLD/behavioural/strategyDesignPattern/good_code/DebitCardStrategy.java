package behavioural.strategyDesignPattern.good_code;

public class DebitCardStrategy implements PaymentStrategy{
    @Override
    public void makePayment() {
        System.out.println("Making Payment Via Debit Card...");
    }
}
