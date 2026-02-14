package behavioural.state_pattern.good_code;

public class DirectionService {
    TransportationMode transportationMode;

    public DirectionService(TransportationMode mode) {
        this.transportationMode = mode;
    }

    public int getEta() {
        return transportationMode.calculateETA();
    }

    public String getDirection() {
        return transportationMode.getDirection();
    }
}
