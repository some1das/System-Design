package behavioural.strategyDesignPattern.bad_code;

public class Main {
    public static void main(String[] args) {
        PaymentSystem paymentSystem = new PaymentSystem();

        paymentSystem.makePayment("CREDIT_CARD");
        paymentSystem.makePayment("DEBIT_CARD");
    }
}
