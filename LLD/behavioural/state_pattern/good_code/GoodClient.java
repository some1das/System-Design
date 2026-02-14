package behavioural.state_pattern.good_code;

public class GoodClient {
    public static void main(String[] args) {
        DirectionService service = new DirectionService(new Car());

        service.getDirection();

        service.getEta();
    }
}
