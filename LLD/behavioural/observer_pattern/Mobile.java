package behavioural.observer_pattern;

public class Mobile implements Device{

    @Override
    public void displayMessage(String message) {
        System.out.println("Mobile -> " + message);
    }
}
