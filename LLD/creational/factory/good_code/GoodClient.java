package creational.factory.good_code;

public class GoodClient {
    public static void main(String[] args) {
        Transport vehicle = TransportFactory.createTransport("car");

        vehicle.deliver();
    }
}
