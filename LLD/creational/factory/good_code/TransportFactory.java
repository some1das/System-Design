package creational.factory.good_code;

public class TransportFactory {
    public static Transport createTransport(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();      
            default:
                throw new  IllegalArgumentException();
        }
    }
}
