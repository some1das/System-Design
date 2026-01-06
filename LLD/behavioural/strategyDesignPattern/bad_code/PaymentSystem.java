package LLD.behavioural.strategyDesignPattern.bad_code;

public class PaymentSystem {
    public void makePayment(String paymentMethod) {
        if(paymentMethod.equals("CREDIT_CARD")) {
            System.out.println("Making Payment By Credit Card");
        }
        else if(paymentMethod.equals("DEBIT_CARD")) {
            System.out.println("Making payment via Debit Card");
        }
    }
}
