package behavioural.observer_pattern;

public class Screen implements Device{

    @Override
    public void displayMessage(String message) {
        System.out.println("SCREEN -> " + message);
    }
}
