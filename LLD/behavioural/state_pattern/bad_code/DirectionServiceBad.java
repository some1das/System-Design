package behavioural.state_pattern.bad_code;

enum TransporationMode {
    WALKING, CAR, TRAIN
}

public class DirectionServiceBad {
    private TransporationMode mode;

    public DirectionServiceBad(TransporationMode mode) {
        this.mode = mode;
    }

    public void setMode(TransporationMode mode) {
        this.mode = mode;
    }

    // Method to calculate ETA
    public int getETA() {
        switch (mode) {
            case WALKING:
                System.out.println("Calculating ETA walking...");
                return 10;
            case CAR:
                System.out.println("Calculating ETA walking...");
                return 5;
            default:
                throw new IllegalArgumentException("Unknown Mode");
        }
    }

    public String getDirection() {
        switch (mode) {
            case WALKING:
                return "Directions for Walking: Head to north 500m";
            case CAR:
                return "Directions for  Car: Use highway 99";
            default:
                return "No direction";
        }
    }
    
}
