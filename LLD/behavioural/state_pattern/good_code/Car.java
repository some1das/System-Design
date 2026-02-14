package behavioural.state_pattern.good_code;

public class Car implements TransportationMode{

    @Override
    public int calculateETA() {
        System.out.println("Calculating ETA for Car...");
        return 50;
    }

    @Override
    public String getDirection() {
        return "Direction - [Car]: - Go staraight";
    } 
}
