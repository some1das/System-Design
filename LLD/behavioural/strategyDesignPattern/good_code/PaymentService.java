package LLD.behavioural.strategyDesignPattern.good_code;

public class PaymentService {
    public PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment() {
        strategy.makePayment();
    }
}
