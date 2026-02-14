package behavioural.state_pattern.good_code;

public class Walking implements TransportationMode{

    @Override
    public int calculateETA() {
        System.out.println("Calculating ETA for Walking...");
        return 100;
    }

    @Override
    public String getDirection() {
        return "Direction - [Walking]: - Go staraight";
    }
    
}
