package LLD.behavioural.strategyDesignPattern.good_code;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // service.setStrategy(new CreditCardStrategy());
        service.setStrategy(new DebitCardStrategy());

        service.processPayment();
    }
}
