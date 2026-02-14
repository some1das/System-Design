package behavioural.state_pattern.bad_code;

public class BadClient {
    public static void main(String[] args) {
        DirectionServiceBad service = new DirectionServiceBad(TransporationMode.CAR);

        System.out.println(service.getDirection());;

        service.getETA();
    }
}
